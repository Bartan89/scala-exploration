package IntroducingMyself
import CovidRelated.covidData
import IntroducingMyself.AgeComparer.howOldAreYou
import StaticData.{citiesAndDistances, welcomeAndMenuOptions}
import dealingWithInput.{forceUseOfNumber}

import scala.io.StdIn.{readInt, readLine}

object Main extends App {
  def programLoop(): Unit = {


    welcomeAndMenuOptions
      .zipWithIndex
      .map {
        case (menuElement, menuElementNumber) => {
          val firstMenuItemLength = menuElement.length-2 //2 due to \n elements
          val firstMenuItem = 0
          val stylingAndNumber = if(menuElementNumber == firstMenuItem) "_" * (firstMenuItemLength) else menuElementNumber
          println(s"$stylingAndNumber $menuElement")
        }
    }

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
      case None => {
        anyKey()
        programLoop()

      }
    }
  }

  def whereAreYouBorn() = {
    print("Let's make it into a game, you guess from these options\n")
    citiesAndDistances.map((e) => println(s"${e.id} ${e.city}"))

    userGuesesBirthPlace()
    programLoop()
  }

  def userGuesesBirthPlace(): Unit = {


    val input = readLine()

    val x = forceUseOfNumber(input) match {
      case Some(input) => input
      case None => {
        userGuesesBirthPlace()
        666
      }
    }


    repeatedAskTillRightAswer(x)


    def repeatedAskTillRightAswer(guess: Int = -1, previousGuess: Int = -1) {

      val upperLimit = citiesAndDistances.last.id

      if (guess > upperLimit) {
        println(s"please provide a valid number between 1 and $upperLimit")
        whereAreYouBorn()

      } else {

        val prev = citiesAndDistances.find(e => e.id == previousGuess)
        val cur = citiesAndDistances.find(e => e.id == guess)


        if (previousGuess == -1 && cur.get.distance != 0) {
          println(s"${cur.get.city} is not correct")
        }
        else if (cur.get.distance == 0) {
          println(s"That is correct, well done, I was born in ${cur.get.city}")
          println("press any key to continue")
          val answer = readLine()
          if (answer != null) programLoop()
        } else if (cur.get.distance < prev.get.distance) {
          println(s"with ${cur.get.city} you are Warmer than ${prev.get.city}")
        } else {
          println(s"with ${cur.get.city} you are Colder than ${prev.get.city}")
        }


        val input = readLine()

        val x = forceUseOfNumber(input) match {
          case Some(value) => value
          case None => {
            userGuesesBirthPlace()
            666
          }
        }


        repeatedAskTillRightAswer(x, cur.get.id)
      }
    }


  }



  def anyKey() : Unit = {
    println("press any key to continue")
    val answer = readLine()
    if (answer != null) {
      programLoop()}
    else {
      anyKey()
    }
  }

  programLoop()

  def stopProgram(): Unit = {
    print("\nThanks for stopping by, see you again!\n")
    scala.sys.exit()
  }
}
