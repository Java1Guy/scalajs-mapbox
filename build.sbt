// Turn this project into a Scala.js project by importing these settings
enablePlugins(ScalaJSPlugin)
enablePlugins(WorkbenchPlugin)

name := "scalajs-mapbox"

version := "0.2-SNAPSHOT"

scalaVersion := "2.12.4"

scalaJSUseMainModuleInitializer in Compile := false
scalaJSUseMainModuleInitializer in Test := false

testFrameworks += new TestFramework("utest.runner.Framework")

//Need to wait until new MapBox is available in WebJar:
//skip in packageJSDependencies := false
// @TODO Figure out how to use webjars
//  jsDependencies += "org.webjars" % "jquery" % "1.10.2" / "jquery.js"
//  jsDependencies += "org.webjars.npm" % "mapbox-gl" % "0.43.0" / "mapbox-gl.js"
//  jsDependencies += "org.webjars.npm" % "github-com-mapbox-mapbox-gl-draw" % "1.0.4" / "mabox-gl-draw.js"
//  jsDependencies += "org.webjars.npm" % "turf__turf" % "4.6.1" / "turf.min.js"

// Show more comments when using dubious features
scalacOptions += "-feature"

libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.4",
    "com.lihaoyi" %%% "scalatags" % "0.6.7",
    "com.lihaoyi" %%% "utest" % "0.4.5" % "test"
)

publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (version.value.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at nexus + "content/repositories/snapshots")
    else
        Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true
publishArtifact in Test := false
organization := "io.github.bbarker"

pomExtra :=
  <url>https://github.com/bbarker/scalajs-mapbox</url>
    <licenses>
        <license>
            <name>Apache 2</name>
            <url>http://www.apache.org/licenses/</url>
        </license>
    </licenses>
    <scm>
        <url>git://github.com/bbarker/scalajs-mapbox.git</url>
        <connection>scm:git://github.com/bbarker/scalajs-mapbox.git</connection>
    </scm>
    <developers>
        <developer>
            <id>bbarker</id>
            <name>Brandon Elam Barker</name>
            <url>http://bbarker.github.io</url>
        </developer>
    </developers>

credentials += Credentials(Path.userHome / ".ivy2/.credentials")
