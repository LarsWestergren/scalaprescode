import akka.actor.Actor

class PingActor extends Actor {

 override def preStart = {
   println("'Oh no, not again' thought the bowl of petunias")
 }

 def receive: Receive = {  
  case "Start" => sender() ! "Ok, starting"
 }


}

