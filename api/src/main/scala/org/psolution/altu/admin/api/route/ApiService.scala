package org.psolution.altu.admin.api.route

import javax.ws.rs.Path

import akka.http.scaladsl.server.Directives
import io.swagger.annotations._
import org.psolution.altu.admin.api.swagger.DefaultJsonFormats

import scala.concurrent.ExecutionContext

@Path("/api")
@Api(value = "/api", produces = "Provide API model")
class ApiService(implicit executionContext: ExecutionContext)
  extends Directives with DefaultJsonFormats {

  @ApiOperation(value = "Return Hello greeting", httpMethod = "GET", response = classOf[ApiService])
  @ApiResponses(Array(
    new ApiResponse(code = 500, message = "Internal server error")
  ))
  def route =
    path("api") {
      get {
        complete {
          "API"
        }
      }
    }
}
