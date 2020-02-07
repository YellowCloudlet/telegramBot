package methods

trait WithParameters {
  def parameters: Map[String, Any]
}

trait ApiMethod extends WithParameters{
  def name: String

  def methodParameters: Map[String, Any]

  override def parameters: Map[String, Any] = methodParameters
}

case object getMe extends ApiMethod {
  override def name: String = "getMe"

  override def methodParameters: Map[String, Any] = Map.empty
}
