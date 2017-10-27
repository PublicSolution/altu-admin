package org.psolution.altu.admin.common.load

object ModuleAttributeType extends Enumeration {
  type ModuleAttributeType = Value

  val routeType = Value("altu-routes")
  val actorType = Value("altu-actors")
  val moduleName = Value("altu-name")
}
