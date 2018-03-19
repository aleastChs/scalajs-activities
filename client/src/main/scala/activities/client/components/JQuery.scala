package activities.client.components

import org.scalajs.dom._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSGlobal

/**
  * Created by alexa on 19/03/2018.
  */

@js.native
trait JQueryEventObject extends Event {
  var data: js.Any = js.native
}

@js.native
@JSGlobal("jQuery")
object JQueryStatic extends js.Object {
  def apply(element: Element): JQuery = js.native
}

@js.native
class JQuery extends js.Object {
  def on(events: String, selector: js.Any, data: js.Any, handler: js.Function1[JQueryEventObject, js.Any]): JQuery = js.native
}
