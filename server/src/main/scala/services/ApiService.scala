package services

import java.util.{UUID, Date}

import activities.shared._

/**
  * Created by alexa on 19/03/2018.
  */
class ApiService extends Api {
  var activities = Seq(
    ActivityItem("1", 0x61626364, "Good Wheather out Running in the forest", Running),
    ActivityItem("1", 0x61626364, "The Wheather was horrible, in the pool ", Swimming),
    ActivityItem("1", 0x61626364, "Swimming in the Lake", Swimming),
    ActivityItem("1", 0x61626364, "Running in the streets with Mark", Running)
  )

  override def welcomeMsg(name: String): String =
    s"Welcome to Activity In Scalajs, $name! Time is now ${new Date}"

  override def getAllActivities(): Seq[ActivityItem] = {
    Thread.sleep(200)
    // Commando Message
    println(s"Sending ${activities.size} Activity Items")
    // Return the Sequence
    activities
  }

  override def updateActivity(item: ActivityItem): Seq[ActivityItem] = {
    if(activities.exists(_.id == item.id)) {
      activities = activities.collect {
        case i if i.id == item.id => item
        case i => i
      }
      println(s"Acticity item was added: $item")
    } else {
      val newItem = item.copy(id = UUID.randomUUID().toString)
      activities :+= newItem
      println(s"Activity Item was added: $newItem")
    }
    Thread.sleep(200)
    activities
  }

  override def deleteActivity(itemId: String): Seq[ActivityItem] = {
    println(s"Deleting item with id = $itemId")
    Thread.sleep(200)
    activities = activities.filterNot(_.id == itemId)
    activities
  }
}