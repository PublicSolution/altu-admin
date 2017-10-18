package org.psolution.altu.admin.api.route

import javax.ws.rs.Path

import akka.http.scaladsl.server.{Directives, Route}
import io.swagger.annotations._
import net.liftweb.json.DefaultFormats
import net.liftweb.json.Serialization.writePretty

@Path("/api")
@Api(value = "/api", produces = "Provide API info")
class ApiService extends Directives {

  protected def basicPath(route: Route): Route = pathPrefix("api") {
    route
  }

  implicit val formats = DefaultFormats

  protected def prettyJson[A](a: A) = writePretty(a)

}
