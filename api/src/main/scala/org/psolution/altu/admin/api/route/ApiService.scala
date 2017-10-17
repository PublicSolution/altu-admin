package org.psolution.altu.admin.api.route

import javax.ws.rs.Path

import akka.http.scaladsl.server.{Directives, Route}
import io.swagger.annotations._
import org.psolution.altu.admin.api.swagger.DefaultJsonFormats

@Path("/api")
@Api(value = "/api", produces = "Provide API info")
class ApiService extends Directives with DefaultJsonFormats {

  protected def basicPath(route: Route): Route = pathPrefix("api") {route}

}
