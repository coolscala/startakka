import sbt._
import Keys._

object V {
  val version      = "0.1-SNAPSHOT"
  val scalaVersion = "2.9.1"
  val organization = "com.razie"
}

object MyBuild extends Build {

  def scalatest = "org.scalatest"  % "scalatest_2.9.1" % "1.6.1"
  def junit     = "junit"          % "junit"           % "4.5"      % "test->default"
  //def json      = "org.json"       % "json"            % "20090211"
  //def jxpath    = "commons-jxpath" % "commons-jxpath"  % "1.3"

  def akka      = "se.scalablesolutions.akka" % "akka-actor"   % "1.3-RC1"
  def akkar     = "se.scalablesolutions.akka" % "akka-remote"  % "1.3-RC1"
  
  lazy val core = Project(id="startakka", base=file("."),
                          settings = defaultSettings ++ 
                          Seq(libraryDependencies ++= Seq(scalatest, junit, akka, akkar))
                  )

  def defaultSettings = baseSettings ++ Seq()

  def baseSettings = Defaults.defaultSettings ++ Seq (
    scalaVersion := V.scalaVersion,
    version      := V.version,

    organization         := V.organization,
    organizationName     := "Cool Scala",
    organizationHomepage := Some(url("http://www.coolscala.com")),

    resolvers += ScalaToolsSnapshots,

    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",

    credentials += Credentials((Path.userHome / ".ivy2.credentials").asFile),

    publishTo <<= version { (v: String) =>
      if(v endsWith "-SNAPSHOT")
        Some ("Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/snapshots/")
      else
        Some ("Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/releases/")
    }  )

}
