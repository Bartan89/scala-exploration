import scala.io.StdIn.{readInt, readLine}

object Main extends App {
  def programLoop(): Unit = {
  val welcome = List("What would you like to ask me?", "1. Where are you born?", "2. How old are you?", "3. stop program")
  welcome.map( e => println(e) )

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
    print("Why don't you tell me your age and I'll tell if you are younger or older? \n")
    val userAge = readInt()
    if(userAge > 31) println("\n You are older")
    if(userAge < 31) println("\n You are younger")
    programLoop()
  }

  programLoop()

  def stopProgram(): Unit = {
    print("\n Thanks for stopping by, see you again! \n")
  }
}



