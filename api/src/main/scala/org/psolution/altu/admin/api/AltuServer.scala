package org.psolution.altu.admin.api

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{HttpApp, Route, RouteConcatenation}
import akka.stream.ActorMaterializer
import org.psolution.altu.admin.api.route.{InfoService, MenuService}
import org.psolution.altu.admin.api.swagger.{SwaggerDocService, SwaggerUI}

object AltuServer extends HttpApp with RouteConcatenation {

  // default parameters
  val ALTU_SYSTEM = "altu-system"
  val ALTU_HOST = "localhost"
  val ALTU_PORT = "8080"

  implicit val altuSystem = ActorSystem(ALTU_SYSTEM)
  implicit val materializer = ActorMaterializer()

  implicit val executionContext = altuSystem.dispatcher

  def main(args: Array[String]): Unit = {

    val host = Option(System.getProperty("host")).orElse(Option(ALTU_HOST)).get
    val port = Option(System.getProperty("port")).orElse(Option(ALTU_PORT)).get.toInt

    startServer(host, port)
  }

  override protected def routes = combineRoutes

  private[this] def combineRoutes: Route = {
    (new InfoService).getApiInfo ~ (new MenuService).getMenuByTemplate() ~
      SwaggerDocService.routes ~ SwaggerUI.site
  }

}
