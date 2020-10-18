package exploringScala
import exploringScala.Main.programLoop
import scala.io.StdIn.readLine

object helperTools {
  def anyKey() : Unit = {
    println("press any key to continue")
    val answer = readLine()
    if (answer != null) {
      programLoop()}
    else {
      anyKey()
    }
  }

  def stopProgram(): Unit = {
    print("\nThanks for stopping by, see you again!\n")
    scala.sys.exit()
  }

}
