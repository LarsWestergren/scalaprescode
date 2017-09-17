enablePlugins(ScalaJSPlugin)

name := "Scala.js Demo"
scalaVersion := "2.12.2"

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.1"
libraryDependencies += "be.doeraene" %%% "scalajs-jquery" % "0.9.1"

// Applikationen har en main metod
scalaJSUseMainModuleInitializer := true


jsDependencies +=
  "org.webjars" % "jquery" % "2.1.4" / "2.1.4/jquery.js"
