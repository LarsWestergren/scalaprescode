import akka.actor.{Props, Actor, ActorSystem}
import akka.pattern.ask
import akka.util.Timeout
import scala.concurrent._
import scala.concurrent.duration._

object AkkaTest extends App {
  println("Running main class")
  
  //Init the actorsystem 
  val as = ActorSystem("test")
  implicit val executionContext = as.dispatcher
  
  //Props - fancy factory method.
  val parent = as.actorOf(Props(new PingActor))

  implicit val timeout = Timeout(1 seconds)
  val replyFuture = parent ? "Start"
  replyFuture.onSuccess { case rep => println("The reply was " + rep) }

  Await.result(as.terminate, 3 seconds)
}
