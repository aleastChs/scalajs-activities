package activities.client

/**
  * Created by alexa on 20/03/2018.
  */
package object logger {
  private val defualtLogger = LoggerFactory.getLogger("Log")

  def log = defualtLogger
}
