package coolscala

import akka.actor.Actor
import akka.actor.Actor._

/** code sample from http://akka.io
 *
 *  Start the server first and then this client
 */
object Client extends App {

  val server = remote.actorFor("hello-service", "localhost", 2552)
  
  val result = (server ? "Hello").as[String]

  println (result)
}