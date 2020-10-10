object Main extends App {



  val exampleList = List(1,4,5,7,8,10,1,0)

  val something: List[Int] = exampleList.filter(x => x > 3 && x < 8)

  println(something)

}

