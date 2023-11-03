package database

import kotlin.Long
import kotlin.String

public data class TaskEntity(
  public val id: Long,
  public val title: String,
  public val complete: Long
) {
  public override fun toString(): String = """
  |TaskEntity [
  |  id: $id
  |  title: $title
  |  complete: $complete
  |]
  """.trimMargin()
}
