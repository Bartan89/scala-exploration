import scala.io.StdIn.{readInt, readLine}

object Main extends App {







def programLoop(): Unit = {

  print("What would you like to ask me?\n")
  print("1. Where are you born?\n")
  print("2. How old are you?\n")
  print("3. stop program\n")
  val menu = readInt()


  val choice = menu match {
    case 1 => born()
    case 2 => ageComparer()
    case _ => stopProgram()
  }

}




  def born() = {
    print("\nI was born in Wijchen \n")
    print("\n Tell my where you were born and I'll let you know the distance from my birthplace \n")
    val userPlaceOfBirth = readLine()
    distanceFromMe(userPlaceOfBirth)

    programLoop()
  }

  def distanceFromMe(userPlaceOfBirth : String) ={
    println(s" $userPlaceOfBirth, nice I haven't implemented data fetching from \n an external API yet, come back later.")
  }

  def ageComparer() = {
    print("Why don't you tell me your age and I'll tell you the difference?")
    val userAge = readInt()
    if(userAge > 31) println("You are older")
    if(userAge < 31) println("You are younger")
    programLoop()
  }

  def stopProgram(): Unit = {
    print("\n Thanks for stopping by, see you again! \n")
  }



  programLoop()
}



