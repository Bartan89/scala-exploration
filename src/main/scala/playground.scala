object playground extends App {

  val aValue = {
    val mood = 6


    if(mood > 5) 2 else 10

  }

  println(aValue)


  def fibonacci(number : Int): Int = {
   if(number <= 2) 1
   else fibonacci(number-1) + fibonacci(number-2)
  }

  val result = fibonacci(8)

  println(result)


  def callByValue(x : Long) = {
    println(x)
    println(x)
  }

  callByValue(System.nanoTime())

  def callByName(x : => Long) = {
    println(x)
    println(x)
  }

  callByName(System.nanoTime())


  val str : String = "hello"

  println('b' +:  str)

  case class data(naam: String, leeftijd: Int)

  val namenEnData: List[data] = List(data("Bart", 28), data("john", 230))

  val filtered = namenEnData.foreach(e => println(e.leeftijd))

}
