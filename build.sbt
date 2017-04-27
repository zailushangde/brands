name := "brands"

version := "1.0"

scalaVersion := "2.12.2"


libraryDependencies ++= {
  val akkaVersion = "2.5.0"
  val akkaHttpVersion = "10.0.5"
  val slickVersion = "3.2.0-M2"
  Seq(
    // akka
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    // streams
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    // akka http
    "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test",
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,

    "com.typesafe.slick" %% "slick" % slickVersion,
    "org.postgresql" % "postgresql" % "9.4-1201-jdbc41",

    "com.zaxxer" % "HikariCP" % "2.4.5",
    "org.slf4j" % "slf4j-nop" % "1.6.4",

    "ru.yandex.qatools.embed" % "postgresql-embedded" % "1.15" % "test"
  )
}