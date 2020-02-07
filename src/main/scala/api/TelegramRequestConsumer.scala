package api

import java.util.UUID

import akka.actor.ActorSystem
import akka.stream.Materializer

import akka.http.scaladsl.Http
import akka.http.scaladsl.marshalling.Marshal   //Marshal
import akka.http.scaladsl.model._    //for RequestEntity, Multipart, HttpEntity
import akka.http.scaladsl.model.HttpMethods._
import akka.http.scaladsl.unmarshalling.Unmarshal

import akka.stream.scaladsl.{Flow, Keep, Sink, Source}
import entities._
//import TelegramBotJsonProtocol._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import spray.json._
import ApiHelper._
import akka.NotUsed

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

class TelegramRequestConsumer(private val token: String)(implicit actorSystem: ActorSystem, materializer: Materializer){
  import actorSystem.dispatcher

  private val availableProcessors = Runtime.getRuntime.availableProcessors()

  private def createEntity(parameters: Map[String, Any]): Future[RequestEntity] = {
    def StringBodyPart(name: String, value: Any) = Multipart.FormData.BodyPart(
      name,
      HttpEntity(value.toString)
    )

    val formData = Multipart.FormData(
      parameters.toSeq.map{ case (name, value) =>
          value match {
            
          }

      }
    )
    Marshal(formData).to[RequestEntity]
  }




}
