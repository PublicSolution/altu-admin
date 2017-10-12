import Dependencies._

scalaVersion := "2.12.3"

//Settings
lazy val commonSetting = Seq(
  organization := "org.psolution.altu",
  version := "0.1.0-SNAPSHOT"
)

//Modules
lazy val root = (project in file("."))
  .settings(
    commonSetting,
    name := "Altu Administration Module",
    publishLocal := (),
    scalacOptions := {
      val log = streams.value.log
      log.info("Loading scala options")
      update.value.allConfigurations.take(3)
    }
  )
  .aggregate(core)

lazy val core = (project in file("core"))
  .settings(
    commonSetting,
    name := "Altu Core Module",
    libraryDependencies ++= backendDeps
  )
