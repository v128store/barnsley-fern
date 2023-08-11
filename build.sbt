ThisBuild / scalaVersion := "2.13.3"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "net.cipherdogs"
ThisBuild / organizationName := "cipherdogs"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision
ThisBuild / scalafixScalaBinaryVersion := scalaBinaryVersion.value

lazy val root = (project in file("."))
  .settings(
    name := "barnsley-fern",
    // Warn if an import selector is not referenced.
    scalacOptions += "-Wunused:imports"
  )

// Run scalafmt on compile.
scalafmtOnCompile := true

// Run scalafix on compile.
scalafixOnCompile := true

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
