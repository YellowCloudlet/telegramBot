package bot

import akka.NotUsed
import akka.actor.{ActorRef, ActorSystem}
import akka.stream._
import akka.stream.scaladsl._
import com.github.meln1k.reactive.telegrambot.api.{ApiRequest, ApiResponse, TelegramRequestConsumer, TelegramUpdatePublisher}
import com.github.meln1k.reactive.telegrambot.methods.SendMessage
import com.github.meln1k.reactive.telegrambot.models._

object SimpleBot extends App {
  implicit val system: ActorSystem = ActorSystem("reactive-telegrambot")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val token: String = "949584283:AAHErsRI1dQrg0XUcNCPbzWHrbDQzBCTqeI"

  val source: Source[Message, ActorRef] = TelegramUpdatePublisher(token).source

  val flow: Flow[ApiRequest, ApiResponse, NotUsed] = TelegramRequestConsumer(token).flow

  source
    .collect {
      case tm: TextMessage => ApiRequest(SendMessage(chat_id = tm.chat.id, text = tm.text))
      case am: AudioMessage => ApiRequest(SendMessage(chat_id = am.chat.id, text = "this is audio"))
      case dm: DocumentMessage => ApiRequest(SendMessage(chat_id = dm.chat.id, text = "this is document"))
      case pm: PhotoMessage => ApiRequest(SendMessage(chat_id = pm.chat.id, text = "this is photo"))
      case sm: StickerMessage => ApiRequest(SendMessage(chat_id = sm.chat.id, text = "this is sticker"))
      case vm: VideoMessage => ApiRequest(SendMessage(chat_id = vm.chat.id, text = "this is video"))
      case vcm: VoiceMessage => ApiRequest(SendMessage(chat_id = vcm.chat.id, text = "this is voice"))
      case cm: ContactMessage => ApiRequest(SendMessage(chat_id = cm.chat.id, text = "this is contact"))
      case lm: LocationMessage => ApiRequest(SendMessage(chat_id = lm.chat.id, text = "this is location"))
    }
    .via(flow)
    .to(Sink.ignore)
    .run

}