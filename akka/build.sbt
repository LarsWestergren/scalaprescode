name := "Akka"

scalaVersion := "2.12.3"
lazy val akkaV = "2.5.4"
libraryDependencies ++= Seq(
   "com.typesafe.akka" %% "akka-actor" % akkaV
)
fork in run := true
connectInput in run := true
