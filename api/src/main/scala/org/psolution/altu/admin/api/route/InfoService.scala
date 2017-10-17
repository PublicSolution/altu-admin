package org.psolution.altu.admin.api.route

import javax.ws.rs.Path

import akka.http.scaladsl.model.StatusCodes
import io.swagger.annotations.{ApiOperation, ApiResponse, ApiResponses}
import org.psolution.altu.admin.api.model.ApiModel

import spray.json._
import fommil.sjs.FamilyFormats._

class InfoService extends ApiService{

  @ApiOperation(value = "Get info about server", httpMethod = "GET", response = classOf[InfoService])
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
