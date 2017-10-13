import Dependencies._

scalaVersion := "2.12.3"

autoScalaLibrary := false

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
  )
  .aggregate(core, api)

lazy val core = (project in file("core"))
  .settings(
    commonSetting,
    mainClass in (run) :=
      Some("org.psolution.altu.admin.common.ModuleLoader"),
    name := "Altu Core Module",
    libraryDependencies ++= backendDeps
  )

lazy val api = (project in file("api"))
   .settings(
     commonSetting,
     name := "Altu API Module",
     libraryDependencies ++= backendDeps
   )
