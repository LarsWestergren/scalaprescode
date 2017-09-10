name := "AkkaStreams"

scalaVersion := "2.12.3"
lazy val akkaV = "2.5.4"
libraryDependencies ++= Seq(
   "com.typesafe.akka" %% "akka-actor" % akkaV,
   "com.typesafe.akka" %% "akka-stream" % akkaV
)
fork in run := true
connectInput in run := true
