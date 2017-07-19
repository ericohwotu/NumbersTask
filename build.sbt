name := "NumbersTask"

version := "1.0"

//scalaVersion := "2.12.1"

//wart remover error level declaration
wartremoverErrors ++= Warts.unsafe

// main scala test module import
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"

//junit test module import
libraryDependencies += "junit" % "junit" % "4.10" % "test"