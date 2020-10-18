package exploringScala

import StaticData.citiesAndDistances
import dealingWithInput.forceUseOfNumber
import exploringScala.Main.programLoop

import scala.collection.convert.ImplicitConversions.`collection asJava`
import scala.io.StdIn.readLine

object bornGamified {
  def whereAreYouBorn() : Unit = {
    print("Let's make it into a game, you guess from these options\n")
    citiesAndDistances.forEach(e => println(s"${e.id} ${e.city}"))

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
}
