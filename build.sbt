name:= "TestingBase"
version := "0.1"
scalaVersion := "2.11.8"
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.1.0"
libraryDependencies += "com.typesafe" % "config" % "1.3.1"
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming_2.11
libraryDependencies += "org.apache.spark" % "spark-streaming_2.11" % "2.1.0"
libraryDependencies +="com.holdenkarau" %% "spark-testing-base" % "2.1.0_0.6.0" % "test"