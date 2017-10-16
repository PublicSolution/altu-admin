package org.psolution.altu.admin.api

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{HttpApp, Route, RouteConcatenation}
import akka.stream.ActorMaterializer
import org.psolution.altu.admin.api.route.ApiInfoService
import org.psolution.altu.admin.api.swagger.{SwaggerDocService, SwaggerUI}

object AltuServer extends HttpApp with RouteConcatenation{

  implicit val altuSystem  = ActorSystem("altu-system")
  implicit val materializer = ActorMaterializer()

  implicit val executionContext = altuSystem.dispatcher

  def main(args: Array[String]): Unit = {

    val host = Option(System.getProperty("host")).orElse(Option("localhost")).get
    val port = Option(System.getProperty("port")).orElse(Option("8080")).get.toInt;

    startServer(host,port);
  }

  override protected def routes = combineRoutes

  private[this] def combineRoutes: Route = {
    (new ApiInfoService).getApiInfo ~ SwaggerDocService.routes ~ SwaggerUI.site;
  }

}
