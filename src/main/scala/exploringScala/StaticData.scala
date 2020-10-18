package object StaticData {

  case class data(id: Int, city: String, distance: Int)

  val welcomeAndMenuOptions =
    List("\nMy exploration into learning Scala\n",
      "Figure out where I am born? (gamified) 🇳🇱",
      "Get to know how old I am. (gamified) 🎂",
      "Want to hear a joke? (api) 😁",
      "Explore covid Data (api) 🔢",
      "Stop program 💀")

  val citiesAndDistances: List[data] =
    List(data(1, "Wijchen", 0),
      data(2, "Maastricht", 120),
      data(3, "Amsterdam", 60),
      data(4, "Tilburg", 55),
      data(5, "Urk", 65),
      data(6, "Nieuwegein", 44),
      data(7, "Eindhoven", 48),
      data(8, "Groningen", 133))
}