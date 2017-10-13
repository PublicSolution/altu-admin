package org.psolution.altu.admin.api.swagger

import akka.http.scaladsl.server.{Directives}

object SwaggerUI extends Directives{

  val site = path("swagger") { getFromResource("swagger/index.html")} ~
    getFromResourceDirectory("swagger")

}
