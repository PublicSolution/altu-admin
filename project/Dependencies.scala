import sbt.Keys.resolvers
import sbt._

object Dependencies {

  lazy val akkaVersion = "2.3.8"

  resolvers += Resolver.sonatypeRepo("public")
  resolvers += Resolver.mavenLocal

  // Libraries
  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % akkaVersion
  val specs2core = "org.specs2" %% "specs2-core" % "2.4.17"

  val backendDeps = Seq(akkaActor)

}
