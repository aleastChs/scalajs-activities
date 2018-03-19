package activities.shared

import boopickle.Default._

/**
  * Created by alexa on 19/03/2018.
  */
sealed trait ActivityType

case object Running extends ActivityType
case object Swimming extends ActivityType

case class ActivityItem(id: String, timestamp: Int, comment: String, activityType: ActivityType)

object ActivityType {
  implicit val activityTypePickler: Pickler[ActivityType] = generatePickler[ActivityType]
}
