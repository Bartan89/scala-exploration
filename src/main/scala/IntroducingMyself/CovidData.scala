import java.net.SocketTimeoutException

import IntroducingMyself.Main.{anyKey, programLoop}
import io.circe.generic.semiauto.deriveDecoder
import scalaj.http._
import io.circe.parser

import scala.io.StdIn.readLine

package object CovidRelated {
  def covidData(): Unit = {
    println("Type in a country to get accumulation of covid cases")
    val userTyped = readLine()
    val country = preCheck(userTyped)

    try {
      val response: HttpResponse[String] = Http(s"https://api.covid19api.com/total/dayone/country/$country/status/confirmed").asString
      val input = response.body
      case class Country(Cases: Int, Date : String)
      val inputString = s"""$input""".stripMargin
      implicit val studentDecoder = deriveDecoder[Country]
      val decodeResult = parser.decode[List[Country]](inputString)
      decodeResult match {
        case Right(country) =>
        {
          def totalToday(todaysAmountOfCases : Int, day : Int): String = {
            val dayOfPatientOne = 0
            if(day > dayOfPatientOne) {
              val yesterdays = country.zipWithIndex.filter((e => e._2 == day - 1))
              val yesterdaysAmountOfCases = yesterdays.head._1.Cases
              if(yesterdaysAmountOfCases > todaysAmountOfCases) {
                val amount = (todaysAmountOfCases - yesterdaysAmountOfCases).toString
                amount + "*" + (" " * (8-amount.length))
              } else {
                val amount = (todaysAmountOfCases - yesterdaysAmountOfCases).toString
                amount + (" " * (9-amount.length))
              }
            } else {
              todaysAmountOfCases.toString + (" "* (9-todaysAmountOfCases.toString.length))
            }
          }
          country.zipWithIndex.map {
            case (todays, i) => {
              val totalOrCorruptData = totalToday(todays.Cases, i)
              val latestEntry = country.length-1
              println(
                "date: " + todays.Date.substring(5, 10)
                  + " cases:"
                  + "  " + totalOrCorruptData
                  + " accumulated cases:" + todays.Cases)
              if(i == latestEntry) println("Total cases:" +  " "  + todays.Cases)
            }
          }
        }
        case Left(error) => println(error.getMessage())
      }
    }
    catch {
      case e : SocketTimeoutException => {
        println("Could not establish connection to API, try again later")
      }
    }
    anyKey()
    programLoop()
  }

  val preCheck = (userTyped : String) => {
    val response: HttpResponse[String] = Http("https://api.covid19api.com/countries").asString
    val input = response.body
    case class Countries(Country: String)
    val inputString = s"""$input""".stripMargin
    implicit val studentDecoder = deriveDecoder[Countries]
    val decodeResult = parser.decode[List[Countries]](inputString)
    decodeResult match {
      case Right(countries) => {
        val uppercased = userTyped.capitalize
        val condition = countries.exists(e => e.Country == uppercased)
        if(condition == true){
          uppercased
        } else {
          println("Seems you made a typo, want to see a complete country list instead? Y/N")
          val answer = readLine()
          if(answer.toLowerCase == "y"){
            countries.map(e => println(e.Country))
            readLine()
            covidData()
          } else covidData()
        }
      }
      case Left(error) => println(error.getMessage())
    }
  }
}