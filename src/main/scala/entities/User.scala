package entities

case class User(id: Long,
                is_bot: Boolean,
                first_name: Option[String])

