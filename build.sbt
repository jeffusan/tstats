lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "org.kropek.tstats",
      scalaVersion := "2.11.11"
    )),
    name := "tstats",
    version := "0.0.1",
    javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
    parallelExecution in Test := false,
    fork := true,
    javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:+CMSClassUnloadingEnabled"),
    libraryDependencies ++= Seq(
      "com.typesafe" % "config" % "1.3.1",
      "io.circe" %% "circe-core" % "0.8.0",
      "io.circe" %% "circe-generic" % "0.8.0",
      "io.circe" %% "circe-parser" % "0.8.0",
      "io.circe" %% "circe-config" % "0.3.0",
      "org.apache.bahir" %% "spark-streaming-twitter" % "2.2.0",
      "org.apache.spark" %% "spark-core" % "2.2.0",
      "org.apache.spark" %% "spark-streaming" % "2.2.0",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test",
      "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
      "com.holdenkarau" %% "spark-testing-base" % "2.2.0_0.8.0" % "test"
    ),
    // most of the overrides are due to spark-testing-base, particularly hadoop
    // notably commons-net is also an issue for apache spark
    dependencyOverrides ++= Seq(
      "org.apache.hadoop" % "hadoop-hdfs" % "2.6.5",
      "org.apache.hadoop" % "hadoop-common" % "2.6.5",
      "org.apache.hadoop" % "hadoop-client" % "2.6.5",
      "org.apache.hadoop" % "hadoop-mapreduce-client" % "2.6.5",
      "org.apache.hadoop" % "hadoop-mapreduce-client-jobclient" % "2.6.5",
      "org.apache.hadoop" % "hadoop-mapreduce-client-app" % "2.6.5",
      "org.apache.hadoop" % "hadoop-mapreduce-client-core" % "2.6.5",
      "org.apache.hadoop" % "hadoop-mapreduce-client-common" % "2.6.5",
      "org.apache.hadoop" % "hadoop-annotations" % "2.6.5",
      "org.apache.hadoop" % "hadoop-yarn-common" % "2.6.5",
      "org.apache.hadoop" % "hadoop-yarn-api" % "2.6.5",
      "org.apache.hadoop" % "hadoop-yarn-server-common" % "2.6.5",
      "org.apache.hadoop" % "hadoop-yarn-server-nodemanager" % "2.6.5",
      "org.slf4j" % "slf4j-api" % "1.7.10",
      "org.slf4j" % "slf4j-log4j12" % "1.7.10",
      "org.codehaus.jackson" % "jackson-mapper" % "1.8.3",
      "org.codehaus.jackson" % "jackson-mapper-asl" % "1.8.3",
      "org.apache.curator" % "curator-client" % "2.6.0",
      "org.apache.avro" % "avro" % "1.7.4",
      "io.netty" % "netty" % "3.7.0.Final",
      "commons-net" % "commons-net" % "2.2",
      "com.google.guava" % "guava" % "11.0.2"
    ),
    conflictManager := ConflictManager.strict,
    scalacOptions ++= Seq("-deprecation", "-unchecked"),
    pomIncludeRepository := { x => false },
    resolvers ++= Seq(
      "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/",
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
      "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
      Resolver.typesafeIvyRepo("releases"),
      Resolver.sonatypeRepo("public")
    )
  )
