Quickly get started with scala and akka via eclipse and/or sbt. Clone this, get going, have fun now and worry about the details and all the monkeys later.

This includes the sbt project setup, a piece of sample code with remote actors and the eclipse project setup.

For eclipse:

 - clone this repository
  - cd workspace
  - git clone git://github.com/coolscala/startakka.git
 - install eclipse with the scala plugin: http://www.scala-ide.org/
 - open the project and run the AllInOne sample there OR the separate Server/Client
 - have fun

Optionally, you can install scala and sbt command line and evolve from there. We use SBT for dependency management but the required libs have been checked in for you.

For sbt:

 - install scala
 - install sbt 0.11
 - run sbt in the main folder, startakka
 - at the sbt prompt type 
  - "update" this will update the dependencies
  - "run" this will build and run the sample code

Versions used:
 - scala 2.9.1
 - sbt 0.11.2
 - akka 1.3-RC1

TODO: add posterous - Posterous is an SBT plugin that allows you to publish notes with every project release.

TODO: make it and sbt multi-project?

