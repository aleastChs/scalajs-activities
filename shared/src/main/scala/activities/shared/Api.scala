package activities.shared

/**
  * Created by alexa on 19/03/2018.
  */
trait Api {
  def welcomeMsg(name: String): String

  def getAllActivities(): Seq[ActivityItem]
  def updateActivity(item: ActivityItem): Seq[ActivityItem]
  def deleteActivity(itemId: String): Seq[ActivityItem]
}
