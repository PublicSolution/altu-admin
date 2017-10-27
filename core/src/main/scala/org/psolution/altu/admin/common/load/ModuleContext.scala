package org.psolution.altu.admin.common.load

case class ModuleContext(routers: List[String], actors: List[String], moduleName: String)(implicit classLoader: ClassLoader)
