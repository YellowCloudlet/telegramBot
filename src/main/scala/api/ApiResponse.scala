package api

import java.util.UUID
import entities.Response

import scala.util.Try

class ApiResponse(id: UUID, response: Try[Response])
