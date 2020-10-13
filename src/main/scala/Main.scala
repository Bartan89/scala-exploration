import scala.io.StdIn.{readInt, readLine}

object Main extends App {






def programLoop(): Unit = {

  print("What would you like to do?\n")
  print("1. Age thingie\n")
  print("2. stop program\n")
  val menu = readInt()

  if(menu == 1){




  print("How old are you? ")
  val age = readInt()


  val birthday = age match {
    case 0 => "first"
    case 1 => "second"
    case 2 => "third"
    case _ => age + "th"
  }

  println(s"it is your $birthday birthday..")

  //conditionals
  if(age >= 18) println("you can learn to drive")

  //  val exampleList = List(1,4,5,7,8,10,1,0)
  //
  //  val something: List[Int] = exampleList.filter(x => x > 4 && x < 8)
  //
  ////
  //  print
    programLoop()
  } else {
    println("bye bye\n")
  }
}

  programLoop()








}

