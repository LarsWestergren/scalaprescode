import akka.stream._
import akka.stream.scaladsl._

import akka.{ NotUsed, Done }
import akka.actor.ActorSystem
import akka.util.ByteString
import scala.concurrent._
import scala.concurrent.duration._
import java.nio.file.Paths


object StreamDemo extends App {

  implicit val as = ActorSystem("streamDemo")
  implicit val es = as.dispatcher
  implicit val materializer = ActorMaterializer()
  
  val source: Source[Int, NotUsed] = Source(1 to 10)

  val flow = Flow.fromFunction[Int, String](i => i.toString)

  val sink = Sink.foreach[String](i => println("Final value: " + i))

  source
   .via(flow) //Could have used .map on source
   //Keep the materialized value of the Sink (Future) not the source (NotUsed)
   .toMat(sink)(Keep.right)
   .run //And actually run it.
   //And shut down ActorSystem or program will not terminate.
   .onComplete(_ => { println("Done");as.terminate()} )
}
