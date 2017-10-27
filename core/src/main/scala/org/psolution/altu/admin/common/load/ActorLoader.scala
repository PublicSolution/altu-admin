package org.psolution.altu.admin.common.load

import java.net
import java.net.{Authenticator, JarURLConnection, PasswordAuthentication, URL}

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.routing.Router
import org.psolution.altu.admin.common.security.UsernameAuthenticator

import scala.collection.JavaConverters._

object ActorLoader {

  private val JAR = "jar"

  def loadModuleByRef(ref: String)(admin: String, password: String): ModuleContext = {
    implicit val credentials = new PasswordAuthentication(admin, password.toCharArray)
    Authenticator.setDefault(new UsernameAuthenticator)
    implicit val url = new URL(JAR, "", ref + "!/")
    new net.URLClassLoader(Array.apply(url), Thread.currentThread().getContextClassLoader())
    return loadMetadataFromJar
  }

  def loadClassByClassName(className: String, actorName: String)
                          (implicit classLoader: ClassLoader, actorSystem: ActorSystem): ActorRef = {
    val clazz = classLoader.loadClass(className)
    actorSystem.actorOf(Props(clazz.asInstanceOf[Class[_ >: akka.actor.Actor]], actorName))
  }

  private[this] def loadMetadataFromJar(implicit url: URL): ModuleContext = {
    val connection = url.openConnection().asInstanceOf[JarURLConnection]
    val attributes = connection.getAttributes

    var routers = List[String]
    var actors = List[String]
    var moduleName = String
    attributes forEach ((k, v) => {
      k match {
        case ModuleAttributeType.routeType => {
         routers(v.asInstanceOf[List[String]])
        }
        case ModuleAttributeType.actorType => {
          actors(v.asInstanceOf[List[String]])
        }
        case ModuleAttributeType.moduleName => {
          moduleName = v.asInstanceOf[String]
        }
      }
    })
  }

}
