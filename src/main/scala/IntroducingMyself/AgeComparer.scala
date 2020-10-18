package IntroducingMyself
import IntroducingMyself.Main.{anyKey, programLoop}
import dealingWithInput.{forceUseOfNumber}

import scala.io.StdIn.readLine

object AgeComparer {

  def howOldAreYou() = {
    print("\nWhy don't you tell me your age and I'll tell if you are younger or older?\n")
    val x = readLine()
    val userAge = forceUseOfNumber(x) match {
      case Some(value) => value
      case None => 99
    }



    val options = List("We are the same age", "You are older", "You are younger")
    val myAge = 31

    if(userAge > myAge) println("You are older")
    if(userAge == myAge) println("We are the same age")
    if(userAge < myAge) println("You are younger")

    anyKey()
    programLoop()
  }

}
