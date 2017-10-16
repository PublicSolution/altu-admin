package org.psolution.altu.admin.api.route

import javax.ws.rs.Path

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.{Directive, Directive1, Directives, Route}
import io.swagger.annotations._
import org.psolution.altu.admin.api.model.ApiModel
import org.psolution.altu.admin.api.swagger.DefaultJsonFormats
import spray.json._
import fommil.sjs.FamilyFormats._
import shapeless.ops.zipper.Get

import scala.concurrent.ExecutionContext

@Path("/api")
@Api(value = "/api", produces = "Provide API info")
class ApiInfoService(implicit executionContext: ExecutionContext)
  extends Directives with DefaultJsonFormats {

  private[this] def basicPath(route: Route): Route = pathPrefix("api") {route}

  @ApiOperation(value = "Get info about server", httpMethod = "GET", response = classOf[ApiInfoService])
  @ApiResponses(Array(
    new ApiResponse(code = 500, message = "Internal server error")
  ))
  @Path("/info")
  def getApiInfo =
    basicPath(
      path("info") {
        get {
          complete {
            StatusCodes.OK ->
              ApiModel("https://altu.publicsolution.com", "Altu Admin", "0.1.0", "altu-admin.xsd").toJson
          }
        }
      })

}
