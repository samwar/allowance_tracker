// Comment to get more information during initialization
logLevel := Level.Warn


// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

//HTML 5 Tags repository
resolvers += Resolver.url("github repo for html5tags", url("http://loicdescotte.github.io/releases/"))(Resolver.ivyStylePatterns)

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.1")

// HTM5 Tags plugin
libraryDependencies ++= Seq(
    "com.loicdescotte.coffeebean" % "html5tags_2.10" % "1.1.1"
)