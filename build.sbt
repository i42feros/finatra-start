name := "scala-finatra"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "Twitter maven" at "http://maven.twttr.com",
  "Finatra Repo" at "http://twitter.github.com/finatra"
)

libraryDependencies ++= Seq(
  "com.twitter.finatra" % "finatra-http_2.11" % "2.1.0",
  "com.twitter.finatra" % "finatra-httpclient_2.11" % "2.1.0",
  "com.twitter.finatra" % "finatra-utils_2.11" % "2.1.0",
  "com.twitter.finatra" % "finatra-slf4j_2.11" % "2.1.0",
  "com.twitter.finatra" % "finatra-jackson_2.11" % "2.1.0",
  "ch.qos.logback" % "logback-classic" % "1.1.3" % "test",
  "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test",
  "org.mockito" % "mockito-core" % "1.9.5" % "test",
  "org.specs2" %% "specs2" % "2.3.12" % "test",
  "junit" % "junit" % "4.7" % "test",
  // Test dependencies for finatra
  "com.twitter.finatra" %% "finatra-http" % "2.1.0" % "test",
  "com.twitter.inject" %% "inject-core"  % "test",
  "com.twitter.inject" %% "inject-modules" % "test",
  "com.twitter.inject" %% "inject-app" % "test",
  "com.twitter.inject" %% "inject-server" % "test",
  "com.twitter.finatra" %% "finatra-http" % "2.1.0"  % "test" classifier "tests",
  "com.twitter.inject" %% "inject-server" % "2.1.0"  % "test" classifier "tests",
  "com.twitter.inject" %% "inject-app" % "2.1.0"  % "test" classifier "tests",
  "com.twitter.inject" %% "inject-core" % "2.1.0"  % "test" classifier "tests",
  "com.twitter.inject" %% "inject-modules" % "2.1.0"  % "test" classifier "tests",
  "com.twitter.inject" %% "inject-thrift-client" % "2.1.0" ,
  "com.twitter.inject" %% "inject-request-scope" % "test"
)

