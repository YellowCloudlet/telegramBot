package entities

trait  Message {
  def message_id: Long
  def from: User
  def date: Long
  def chat: Chat
}

case class TextMessage(message_id: Long,
                   from: User,
                   date: Long,
                   chat: Chat,
                   text: String) extends  Message
