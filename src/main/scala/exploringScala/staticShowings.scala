import StaticData.welcomeAndMenuOptions

package object staticShowings {
  def introductionMenu() : List[Unit] ={
    welcomeAndMenuOptions
      .zipWithIndex
      .map {
        case (menuElement, menuElementNumber) =>
          val firstMenuItemLength = menuElement.length-2 //2 due to \n elements
          val firstMenuItem = 0
          val stylingAndNumber = if(menuElementNumber == firstMenuItem) "_" * firstMenuItemLength else menuElementNumber
          println(s"$stylingAndNumber $menuElement")
      }
  }
}
