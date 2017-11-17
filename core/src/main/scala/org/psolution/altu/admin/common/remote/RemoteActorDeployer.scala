package org.psolution.altu.admin.common.remote

import akka.actor.{Actor, ActorLogging}
import org.psolution.altu.admin.common.load.ActorLoader

class RemoteActorDeployer extends Actor with ActorLogging{

  private var userName: String = "admin"
  private var password: String = "password"

  override def receive = {
    // Deploy new module
    case DeploymentCommand.DeployNewModule(moduleName, url) => {
      implicit val classLoader = ActorLoader.loadModuleByRef(url)(this.userName,this.password)
      ActorLoader.loadClassByClassName(moduleName,url)(classLoader,actorSystem = context.system)

    }
    case DeploymentCommand.UpdateCredentials(username, password) => {
      this.userName = username
      this.password = password
    }


  }
}
