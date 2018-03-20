package activities.client.modules

import activities.client.ACTIVITIESMain.{ActivitiesLocation, Location}
import activities.client.components.Motd
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.html_<^._
import diode.react._
import diode.data.Pot

/**
  * Created by alexa on 20/03/2018.
  */
class Dashboard {
  case class Props(router: RouterCtl[Location], proxy: ModelProxy[Pot[String]])
  case class State(motdWrapper: ReactConnectProxy[Pot[String]])

  private val component = ScalaComponent.builder[Props]("Dashboard")
      .initialStateFromProps(props => State(props.proxy.connect(m => m)))
    .renderPS { (_, props, state) =>
      <.div(
        <.h2("Dashboard"),
        state.motdWrapper(Motd(_)),
        <.div(props.router.link(ActivitiesLocation)("Here is your activities"))
      )
    }
    .build

  def apply(router: RouterCtl[Location], proxy: ModelProxy[Pot[String]]) =
    component(Props(router, proxy))
}
