/* basic project info */
name := "org.ops.scala.test"

organization := "org.ops"

version := "1.0.0-SNAPSHOT"

// description := "an awesome program"
// homepage := Some( url("http://example.com"))
// licenses := Seq("GPLv3" -> url("http://www.gnu.org/licenses/gpl-3.0.html"))
// organizationName := "My Company"

/* scala versions and options */
scalaVersion := "2.9.2"

crossScalaVersions := Seq("2.9.1")

scalacOptions ++= Seq("-deprecation", "-unchecked")

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* entry point */
mainClass in (Compile, packageBin) := Some("org.ops.scala.test")

mainClass in (Compile, run) := Some("org.ops.scala.test")

scalaVersion := "2.9.2"

/* dependencies */
libraryDependencies ++= Seq (
  "commons-codec" % "commons-codec" % "1.7",
  "com.fasterxml.jackson.core" % "jackson-core" % "2.0.6",
  "com.fasterxml.jackson.core" % "jackson-annotations" % "2.0.6",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.0.6",
  "org.scalatest" %% "scalatest" % "latest.integration" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "latest.integration" % "test"
)

/* improve REPL */
initialCommands in console :=
  """|import scalaz._
     |import Scalaz._
     |println("scalaz 7 loaded!")
     |""".stripMargin

/* you may need these repos */
resolvers ++= Seq(
  "Maven2" at "http://repo1.maven.org/maven2"
  // "sonatype snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  // "sonatype releases" at "https://oss.sonatype.org/content/repositories/releases",
  // Classpaths.typesafeResolver,
  // Classpaths.typesafeSnapshots,
  // JavaNet1Repository,
  // JavaNet2Repository,
)

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

/* assembly plugin */
mainClass in AssemblyKeys.assembly := Some("org.ops.scala.test.App")

assemblySettings

test in AssemblyKeys.assembly := {}

// dependecy graph plugin (waiting for sbt 0.12.0 update) //
// net.virtualvoid.sbt.graph.Plugin.graphSettings

/* start script plugin */
seq(
  com.typesafe.startscript.StartScriptPlugin.startScriptForClassesSettings: _*
)

/* buildinfo plugin */
buildInfoSettings

sourceGenerators in Compile <+= buildInfo

buildInfoKeys := Seq[Scoped](name, version, scalaVersion, sbtVersion)

buildInfoPackage := "org.ops.scala.test"

/* publishing */
publishMavenStyle := true

//publishTo <<= version { (v: String) =>
//  val nexus = "https://oss.sonatype.org/"
//  if (v.trim.endsWith("SNAPSHOT")) Some(
//    "snapshots" at nexus + "content/repositories/snapshots"
//  )
//  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
//}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

//pomExtra := (
//  <url>https://github.com/ACCOUNT/MYPROJ</url>
//  <licenses>
//    <license>
//      <name>LICENSE NAME</name>
//      <url>https://github.com/ACCOUNT/MYPROJ/blob/master/LICENSE</url>
//      <distribution>repo</distribution>
//    </license>
//  </licenses>
//  <scm>
//    <url>git@github.com:ACCOUNT/MYPROJ.git</url>
//    <connection>scm:git:git@github.com:ACCOUNT/MYPROJ.git</connection>
//  </scm>
//  <developers>
//    <developer>
//      <id>HANDLE</id>
//      <name>MY FULL NAME</name>
//      <email>EMAIL</email>
//      <url>HOMEPAGE</url>
//    </developer>
//  </developers>
//)

// pgpPassphrase := Some("PASSWORD".toCharArray)

// pgpSigningKey := Some(0L)

// pgpSecretRing := file("/path/to/file")

// pgpPublicRing := file("/path/to/file")

// credentials += Credentials(
//   "Sonatype Nexus Repository Manager",
//   "oss.sonatype.org",
//   "ACCOUNT",
//   IO read file("/path/to/file")
// )
