package activities.client

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExportTopLevel,JSExport}
import CssSettings._
import scalacss.ScalaCssReact._

import japgolly.scalajs.react.extra.router._
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom
/**
  * Created by alexa on 19/03/2018.
  */
@JSExportTopLevel("ACTIVITIESMain")
object ACTIVITIESMain extends js.JSApp{
  sealed trait Location

  case object DashbordLocation extends Location

  case object ActivitiesLocation extends Location

//  val routerConfig = RouterConfigDsl[Location].buildConfig {dsl =>
//    import dsl._
//
//    val activitiesWrapper = ACTIVITIESCircuit.connect(_.activities)
//    (staticRoute())
//  }

  def main(): Unit = {
//    log.warn("Application ACTIVITIES Starting")
//    log.enab
  }
}
