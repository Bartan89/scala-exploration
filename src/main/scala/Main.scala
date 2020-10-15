

import scala.collection.immutable.HashMap
import scala.io.StdIn.{readInt, readLine}

object Main extends App {

  case class data(id: Int, city: String, distance: Int)

  val citiesAndDistances: List[data] = List(data(1, "Amsterdam", 67), data(2, "Maastricht", 120), data(3, "Wijchen", 0), data(4, "Tilburg", 55), data(5, "Urk", 65))




  def programLoop(): Unit = {
  val welcome = List("\nWhat would you like to ask me?\n", "Where are you born?", "How old are you?", "Stop program")
  welcome.zipWithIndex.map { case (e, i) => println(s"${if(i>0) i else {
    e.flatMap(x => if(x >= e.length) "_" else "")
  }}  $e") }

  val menu = readInt()

  val choice = menu match {
    case 1 => born()
    case 2 => ageComparer()
    case _ => stopProgram()
  }

}

  def born() = {
    print("Let's make it into a game, you guess from these options\n")
    citiesAndDistances.map((e) => println(s"${e.id} ${e.city}"))


    userGuesesBirthPlace()

    programLoop()
  }

  def userGuesesBirthPlace() ={
    val guess = readInt()

    repeatedAskTillRightAswer(guess)
    def repeatedAskTillRightAswer(guess : Int, previousGuess : Int = -1){


      val prev = citiesAndDistances.find(e => e.id == previousGuess)
      val cur = citiesAndDistances.find(e => e.id == guess)

      if(previousGuess == -1 && cur.get.distance != 0){
        println("That is not correct")
      }
      else if(cur.get.distance == 0){
        println("Thas is correct, well done")
        println("press any key to continue")
        val answer = readLine()
        if(answer != null) programLoop()
      } else if (cur.get.distance < prev.get.distance) {
        println("Warmer")
      }  else {
        println("Colder")
      }


      val nextGuess = readInt()

      repeatedAskTillRightAswer(nextGuess, cur.get.id)
    }




  }

  def ageComparer() = {
    print("\nWhy don't you tell me your age and I'll tell if you are younger or older?\n")
    val userAge = readInt()
    if(userAge > 31) println("\n You are older")
    if(userAge < 31) println("\n You are younger")
    anyKey()
    programLoop()
  }

  def anyKey() = {
    println("press any key to continue")
    val answer = readLine()
    if(answer != null) programLoop()
  }

  programLoop()

  def stopProgram(): Unit = {
    print("\nThanks for stopping by, see you again!\n")
    scala.sys.exit()
  }
}



