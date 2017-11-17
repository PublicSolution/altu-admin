package org.psolution.altu.admin.common.load

import java.net
import java.net.{Authenticator, PasswordAuthentication, URL}

import akka.actor.{ActorRef, ActorSystem, Props}
import org.psolution.altu.admin.common.security.UsernameAuthenticator

object ActorLoader {

  private val JAR = "jar"

  def loadModuleByRef(ref: String)(admin: String, password: String): ClassLoader = {

    implicit val credentials = new PasswordAuthentication(admin, password.toCharArray)
    Authenticator.setDefault(new UsernameAuthenticator)

    implicit val url = new URL(JAR, "", ref + "!/")
    implicit val classLoader = new net.URLClassLoader(Array.apply(url),
                                          Thread.currentThread().getContextClassLoader())
    return classLoader
  }

  def loadClassByClassName(className: String, actorName: String)
                          (implicit classLoader: ClassLoader, actorSystem: ActorSystem): ActorRef = {
    val clazz = classLoader.loadClass(className)
    actorSystem.actorOf(Props(clazz.asInstanceOf[Class[_ >: akka.actor.Actor]], actorName))
  }


}
