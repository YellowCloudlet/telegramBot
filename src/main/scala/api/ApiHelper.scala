package api

import akka.http.scaladsl.model.Uri

private object ApiHelper {
  def apiUri(methodName: String, token: String) = Uri(s"https://api.telegram.org/bot$token/$methodName")
}
