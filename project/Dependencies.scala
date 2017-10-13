import sbt.Keys.{resolvers, scalaVersion}
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

  val spray_json = "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion
  val swagger_jaxrs =  "io.swagger" % "swagger-jaxrs" % "1.5.16"

  val backendDeps = Seq(akkaActor,akkaHttp, akkaStream
    , akkaCluster, swagger, spray_json, spray_json)

}
