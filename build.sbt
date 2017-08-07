name := "sweeper"

version := "1.0"

scalaVersion := "2.11.11"


scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots"),
  Resolver.jcenterRepo
)


libraryDependencies ++= {
  val akkaV       = "2.4.16"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.enragedginger" %% "akka-quartz-scheduler" % "1.6.0-akka-2.4.x"
  )
}
        