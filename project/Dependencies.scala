import sbt.Keys.{resolvers}
import sbt._

object Dependencies {

  lazy val akkaVersion = "2.5.6"
  lazy val akkaHttpVersion = "10.0.10"

  resolvers += Resolver.sonatypeRepo("public")
  resolvers += JavaNet2Repository

  // Libraries for Akka
  val akkaActor = "com.typesafe.akka" % "akka-actor_2.12" % akkaVersion
  val akkaCluster = "com.typesafe.akka" % "akka-cluster_2.12" % akkaVersion
  val akkaStream = "com.typesafe.akka" % "akka-stream_2.12" % akkaVersion
  val akkaHttp = "com.typesafe.akka" % "akka-http_2.12" % akkaHttpVersion

  val swagger = "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.11.0"

  val swagger_jaxrs =  "io.swagger" % "swagger-jaxrs" % "1.5.16"

  val scalactic = "org.scalactic" %% "scalactic" % "3.0.4"
  val scalatest = "org.scalatest" %% "scalatest" % "3.0.4" % "test"

  val liftJson = "net.liftweb" %% "lift-json" % "3.1.1"

  val backendDeps = Seq(akkaActor,akkaHttp, akkaStream
    , akkaCluster, swagger
    , scalactic, scalatest, liftJson)

}
