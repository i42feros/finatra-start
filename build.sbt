name := "finatra-start"

scalaVersion := "2.11.7"


assemblyMergeStrategy in assembly := {
  case "BUILD" => MergeStrategy.discard
  case other => MergeStrategy.defaultMergeStrategy(other)
}

libraryDependencies ++= Seq(
  "com.twitter.finatra" %% "finatra-http" % "2.1.0",
  "com.twitter.finatra" %% "finatra-httpclient" % "2.1.0",
  "com.twitter.finatra" %% "finatra-slf4j" % "2.1.0",
  "com.twitter.inject" %% "inject-core" % "2.1.0",
  "ch.qos.logback" % "logback-classic" % "1.0.13",
  "com.twitter" %% "finagle-stats" % "6.29.0",
  "com.twitter.finatra" %% "finatra-http" % "2.1.0" % "test",
  "com.twitter.finatra" %% "finatra-jackson" % "2.1.0" % "test",
  "com.twitter.inject" %% "inject-server" % "2.1.0" % "test",
  "com.twitter.inject" %% "inject-app" % "2.1.0" % "test",
  "com.twitter.inject" %% "inject-core" % "2.1.0" % "test",
  "com.twitter.inject" %% "inject-modules" % "2.1.0" % "test",
  "com.twitter.finatra" %% "finatra-http" % "2.1.0" % "test" classifier "tests",
  "com.twitter.finatra" %% "finatra-jackson" % "2.1.0" % "test" classifier "tests",
  "com.twitter.inject" %% "inject-server" % "2.1.0" % "test" classifier "tests",
  "com.twitter.inject" %% "inject-app" % "2.1.0" % "test" classifier "tests",
  "com.twitter.inject" %% "inject-core" % "2.1.0" % "test" classifier "tests",
  "com.twitter.inject" %% "inject-modules" % "2.1.0" % "test" classifier "tests",
  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.scalatest" %% "scalatest" % "2.2.3" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test")

