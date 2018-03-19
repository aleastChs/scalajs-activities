package activities.client.components

import activities.client.CssSettings._
/**
  * Created by alexa on 19/03/2018.
  */
object GlobalStyles extends StyleSheet.Inline {
  import dsl._

  style(unsafe("body")(paddingTop(70.px)))
  )
  val bootstrapStyles = new BootstrapStyles
}
