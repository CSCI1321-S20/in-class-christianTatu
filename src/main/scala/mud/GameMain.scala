package mud

object GameMain extends App {

  var playing = true

  println("This is a product of my Pain")
  println("Explorer, What is your name? ")
  private val playerName = readLine()

  while (playing) {
    val playerInput = readLine()

    if (playerInput == "Exit") playing = false
  }

}
