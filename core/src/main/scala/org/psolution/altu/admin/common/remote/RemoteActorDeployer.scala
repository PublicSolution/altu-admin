package org.psolution.altu.admin.common.remote

import akka.actor.Actor
import org.psolution.altu.admin.common.load.ActorLoader

class RemoteActorDeployer extends Actor{

  override def receive = {
    // Deploy new module
    case DeployerCommand.DeployNewModule(moduleName, url) => {
      val classLoader = ActorLoader.loadModuleByRef(url);
      ActorLoader.loadClassByClassName("","")
    }
  }
}
