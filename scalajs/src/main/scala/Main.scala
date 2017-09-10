import org.scalajs.dom
import dom.document
import org.scalajs.jquery.jQuery


object Main extends App {

  //Becomees console.log
  println("hello")


  def domAppend(targetNode: dom.Node, text: String): Unit = {
    val parNode = document.createElement("p")
    val textNode = document.createTextNode(text)
    parNode.appendChild(textNode)
    targetNode.appendChild(parNode)
  }

  def jqueryAppend(message: String): Unit = {
    jQuery("body").append(s"<p>$message</p>")
  }

  domAppend(document.body, "text added via direct DOM manipulation")
  jqueryAppend("Text added via jquery") 
  
  
}
