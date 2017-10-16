package org.psolution.altu.admin.api.swagger

import org.psolution.altu.admin.api.route.ApiInfoService

import scala.collection.immutable.HashSet

object SwaggerApiRegistry {

  def getRegistredInstances : Set[Class[_]] = {
    var classes = new HashSet[Class[_]]
    classes.+=(classOf[ApiInfoService])
    classes
  }

}
