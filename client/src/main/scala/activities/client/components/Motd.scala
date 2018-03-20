package activities.client.components

import activities.client.components.Bootstrap.{Button, CommonStyle, Panel}
import diode.react._
import diode.react.ReactPot._
import diode.data.Pot
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import activities.client.services.UpdateMotd
/**
  * Created by alexa on 20/03/2018.
  */
object Motd {
  val Motd = ScalaComponent.builder[ModelProxy[Pot[String]]]("Motd")
    .render_P { proxy =>
      Panel(Panel.Props("Message to You All!"),
        proxy().renderPending(_ > 500, _ => <.p("Loading...")),
        proxy().renderFailed(ex => <.p("Failed to Load Message")),
        proxy().render(m => <.p(m)),
        Button(Button.Props(proxy.dispatchCB(UpdateMotd()), CommonStyle.danger, Icon.refresh, " Update")))
    }
   .componentDidMount(scope =>
     Callback.when(scope.props.value.isEmpty)(scope.props.dispatchCB(UpdateMotd()))
   )
   .build

  def apply(proxy: ModelProxy[Pot[String]]) = Motd(proxy)
}
