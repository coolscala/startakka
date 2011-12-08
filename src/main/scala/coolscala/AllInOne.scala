/*   ____    __    ____  ____  ____,,___     ____  __  __  ____
 *  (  _ \  /__\  (_   )(_  _)( ___)/ __)   (  _ \(  )(  )(  _ \           Read
 *   )   / /(__)\  / /_  _)(_  )__) \__ \    )___/ )(__)(  ) _ <     README.txt
 *  (_)\_)(__)(__)(____)(____)(____)(___/   (__)  (______)(____/    LICENSE.txt
 */
package coolscala

import akka.actor.Actor
import akka.actor.Actor._

/** code sample from http://akka.io
 *
 *  This is the all-in-one sample
 *  
 *  Note that, in the example below, since the "remote" port is co-located,
 *  akka will optimize and give you a local reference
 */
object Test1 extends App {

  // server code
  class HelloWorldActor extends Actor {
    def receive = {
      case msg => self reply (msg + " World")
    }
  }

  remote.start("localhost", 2552).register("hello-service", actorOf[HelloWorldActor])

  // client code
  val actor = remote.actorFor("hello-service", "localhost", 2552)

  val result = (actor ? "Hello").as[String]

  println (result)
}
