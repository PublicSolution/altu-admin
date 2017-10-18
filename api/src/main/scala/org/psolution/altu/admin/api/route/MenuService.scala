package org.psolution.altu.admin.api.route

import java.util.Locale
import javax.ws.rs.Path

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import io.swagger.annotations.{ApiOperation, ApiResponse, ApiResponses}

import scala.collection.mutable.ListBuffer
import org.psolution.altu.admin.api.model.{Menu, MenuItem}

class MenuService extends ApiService {

  @ApiOperation(value = "Get menu by template", httpMethod = "GET", response = classOf[MenuService])
  @ApiResponses(Array(
    new ApiResponse(code = 500, message = "Internal server error")
  ))
  @Path("/menu")
  def getMenuByTemplate(): Route = {
    basicPath(
      path("menu") {
        get {
          complete {
            StatusCodes.OK -> prettyJson(Menu(getMockItems()))
          }
        }
      }
    )
  }

  private[api] def getMockItems(): List[MenuItem] = {
    var items = new ListBuffer[MenuItem];
    items += MenuItem(Locale.US.toLanguageTag, "Dashboard")
    items += MenuItem(Locale.US.toLanguageTag, "Settings")
    items.toList
  }

}
