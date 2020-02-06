package entities

trait RequestResponse{
  def ok: Boolean
}

case class SuccessfulResponse(result : ResponseIdentity) extends RequestResponse {
  override def ok: Boolean = true
}

case class UnsuccessfulResponse(result : ResponseIdentity) extends RequestResponse {
  override def ok: Boolean = false
}