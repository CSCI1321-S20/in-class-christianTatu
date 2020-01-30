package mud

object GameMain extends App {
  println("This is a product of my Pain")
  println("Explorer, What is your name? ")
  private val playerName = readLine()
  println("welcome, "+playerName)
  val player = new Player(playerName, Room.rooms(0), Nil)
  println(player.loc.description())
  var playerInput = readLine.toLowerCase()
  while (playerInput != "exit" && playerInput != "quit") {
    player.processCommand(playerInput)
    playerInput = readLine.toLowerCase()
  }

}
