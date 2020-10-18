import exploringScala.Main.{anyKey, programLoop}
import scalaj.http._
import io.circe.parser
import io.circe.generic.semiauto.deriveDecoder

package object exploringScala {
  def wantToHearAJoke(): Unit = {
  val response: HttpResponse[String] = Http("https://sv443.net/jokeapi/v2/joke/Programming?blacklistFlags=nsfw,religious,political,racist,sexist&type=single").asString
    case class Jokes(joke: String)
        val input = response.body.stripMargin
        implicit val staffDecoder = deriveDecoder[Jokes]
        val decodeResult = parser.decode[Jokes](input)
        decodeResult match {
          case Right(staff) => println(staff.joke)
          case Left(error) => println(error.getMessage())
        }
    anyKey()
    programLoop()
  }
}
