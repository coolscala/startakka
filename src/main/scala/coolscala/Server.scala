package coolscala

import akka.actor.Actor
import akka.actor.Actor._

/** code sample from http://akka.io
 *
 *  Start this server first and then the client
 */
object Server extends App {

  // server code
  class HelloWorldActor extends Actor {
    def receive = {
      case msg    => self reply (msg + " World")
    }
  }

  remote.start("localhost", 2552).register(
    "hello-service", actorOf[HelloWorldActor])

}