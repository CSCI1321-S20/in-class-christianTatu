package mud

object GameMain extends App {

  println("This is a product of my Pain")
  println("Explorer, What is your name? ")
  private val playerName = readLine()
  println("welcome, "+playerName)
  var playerInput = readLine.toLowerCase()
  while (playerInput != "exit" | "quit") {
      //player.process(playerInput)
    playerInput = readLine.toLowerCase()
  }

}
