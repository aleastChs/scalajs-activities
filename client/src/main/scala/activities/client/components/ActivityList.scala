package activities.client.components

import activities.shared.{ActivityItem, Running, Swimming}

import scalacss.ScalaCssReact._
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.html_<^._
import activities.client.components.Bootstrap.{CommonStyle, Button}
import activities.shared._

/**
  * Created by alexa on 20/03/2018.
  */
object ActivityList {
  @inline private def bss = GlobalStyles.bootstrapStyles

  case class ActivityListProps(
                              items: Seq[ActivityItem],
                              stateChange: ActivityItem => Callback,
                              editItem: ActivityItem => Callback,
                              deleteItem: ActivityItem => Callback
                              )

  private val ActivitList = ScalaComponent.builder[ActivityListProps]("ActivityList")
    .render_P(p => {
      val style = bss.listGroup
      def renderItem(item: ActivityItem) = {
        val itemStyle = item.activityType match {
          case Running    => style.itemOpt(CommonStyle.success)
          case Swimming   => style.itemOpt(CommonStyle.info)
        }
        <.li(itemStyle,
          <.input.radio(),
          <.span(" "),
          Button(Button.Props(p.editItem(item, addStyles = Seq(bss.pullRight, bss.buttonXS))), "Edit"),
          Button(Button.Props(p.deleteItem(item, addStyles = Seq(bss.pullRight, bss.buttonXS))), "Delete")
        )
      }
      <.ul(style.listGroup)(p.items toTagMod renderItem)
    })
    .build

  def apply(items: Seq[ActivityItem], stateChange: ActivityItem => Callback, editItem: ActivityItem => Callback, deleteItem: ActivityItem => Callback) =
    ActivitList(ActivityListProps(items, stateChange, editItem, deleteItem))
}
