package org.psolution.altu.admin.common.remote

object DeployerCommand {

  sealed trait Command

  case class DeployNewModule(moduleName: String, url: String) extends Command
  case class UnDeployModule(moduleName: String) extends Command

}
