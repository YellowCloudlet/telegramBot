package entities

trait Response{
  def ok: Boolean
}

case class SuccessfulResponse(result : ResponseEntity) extends Response {
  override def ok: Boolean = true
}

case class UnsuccessfulResponse(result : ResponseEntity) extends Response {
  override def ok: Boolean = false
}