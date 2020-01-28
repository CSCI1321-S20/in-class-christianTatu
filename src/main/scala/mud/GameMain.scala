package mud

object GameMain extends App {

  println("This is a product of my Pain")
  println("Explorer, What is your name? ")
  private val playerName = readLine()

  var playerInput = readLine.toLowerCase()
  while (playerInput != "exit") {
      player.process(playerInput)
    playerInput = readLine.toLowerCase()
  }

}
