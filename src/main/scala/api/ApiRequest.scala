package api

import java.util.UUID
import methods.ApiMethod

case class ApiRequest (method: ApiMethod, id: UUID = UUID.randomUUID())
