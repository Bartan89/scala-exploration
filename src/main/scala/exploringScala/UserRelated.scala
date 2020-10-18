package object dealingWithInput {


  def forceUseOfNumber(whatUserInputted: String): Option[Int] = {
    try {
      Some(whatUserInputted.toInt)
    }
    catch {
      case e: NumberFormatException => {
        val response = if(whatUserInputted.length == 0) "Enter press without any thing else" else s"'$whatUserInputted''"
        println(s"$response is not a valid input. Please provide a valid number")
        None
      }
    }
  }

}
