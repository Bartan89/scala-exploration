package exploringScala
import CovidRelated.covidData
import exploringScala.AgeComparer.howOldAreYou
import StaticData.{citiesAndDistances, welcomeAndMenuOptions}
import dealingWithInput.forceUseOfNumber
import exploringScala.bornGamified.whereAreYouBorn
import exploringScala.helperTools.{anyKey, stopProgram}
import staticShowings.introductionMenu

import scala.annotation.tailrec
import scala.collection.convert.ImplicitConversions.`collection asJava`
import scala.io.StdIn.readLine

object Main extends App {
  @tailrec
  def programLoop(): Unit = {
    introductionMenu()

    val capturedInput = readLine()
    val onUserInput = forceUseOfNumber(capturedInput)

    onUserInput match {
      case Some(numericalInput) => numericalInput match {
        case 1 => whereAreYouBorn()
        case 2 => howOldAreYou()
        case 3 => wantToHearAJoke()
        case 4 => covidData()
        case 5 => stopProgram()
        case _ => forceUseOfNumber(s"$capturedInput is higher than ${welcomeAndMenuOptions.length-1}")
    }
      case None => anyKey(); programLoop()
    }
  }
  programLoop()
}
