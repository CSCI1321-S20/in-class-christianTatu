package mud

class Player(val name: String, var loc: Room, var inv: List[Item]) {
  //do I need an "exits" list or array? or will this be
  // a command that calls the array of exits in loc and prints from there?
  
  def processCommand(command: String): Unit = {
    val com = command.split(" +", 2)
      com(0).trim.toLowerCase match {
        case "north" | "n" | "east" | "e" | "south" | "s" | "west" | "w" | "up" |
          "u" | "down" | "d" => move(com(0))

        case "look" | "l" => println(loc.description)

        case "inventory" | "inv" => println(inventoryListing())

        case "get" => loc.getItem(com(1)) match {
          case None => println("there is no item with this name.")
          
          case Some(item) => 
            getToInventory(item) 
            println(item.name+" has been added to your inventory.")
        }

        case "drop" => dropFromInventory(com(1)) match {
          case None => println("this item is not in your inventory.")
          case Some(item) =>
          loc.dropItem(item)
          println(item.name+" has been dropped.")
        }

        case "exit" | "quit" => 

        case "help" => help()

        case _ =>
          println("Command not recognized. type \"help\" to see a list of commands.")
      }
  }

  //split input on spaces
  //read first word, branch from there
  //ingetput.split(" +",2)            item" +" splits on spaces, 2 gives you MAX 2 diff items

  //ORgetitem

  //ingetput.startsWith (first commanditem)
  //ingetput.drop       item

  def dropFromInventory(itemName: String): Option[Item] = {
    // YES: Pull an item out of the inventory (if it exists) and return it.
    // YES: filter inventory for name of item, if empty, return error
    // NO: if there, remove it from player inv and add to room inventory
    // YES: check if inv size is 0
    inv.find(_.name.toLowerCase == itemName.toLowerCase) match {
      case Some(item) =>
        inv = inv.filter(_ != item)
        Some(item)
      case None => None
    }
  }

  def getToInventory(item: Item): Unit = { //used to be add, i changed the name to getToInventory from dropToInventory
    inv ::= item
    //- Add the given item to inventory.
    // remove item froom Room inventory and add it to player inventory,
  }

  def inventoryListing(): String = {
    var genString = "." //Empty String genString
    for (i <- inv) { //in this for loop, I going through List of Item (using i)  and building the name and desc onto genString
      genString = genString + i.name + " - " + i.desc
    }
    if(inv.isEmpty) {
      genString = "Your Inventory is Empty"
    }
    genString

    //- Build a String with the contents of the inventory for printing.
    //take each item in Player's List:Inventory and append it to a string, then print
  }

  def move(dir: String): Unit = { 
    val dirNum = dir.toLowerCase match {
      case "north" | "n" => 0
      case "east" | "e"  => 1
      case "south" | "s" => 2
      case "west" | "w"  => 3
      case "up" | "u"     => 4
      case "down" | "d"   => 5
    }
    loc.getExit(dirNum) match {
      case None => println("Not a valid direction")
      case Some(newRoom) => loc = newRoom 
        println(loc.description())
        //println("loc "+loc.num)
       // println(Room.exits.toList)
    }
  }

  //def move(dir: String): Unit = {
  //- Move the player in a particular direction if possible.
  //read input, if Room[Exits] contains a location AND destination
  //update player to that new destination
  //???

  //}

  def help(): Unit = {
    println(
      """
move - moves your player in a direction
  movement: Type North(N), East(E), South(S) West(W) Up(U) or Down(D)
~
look - reprints the description of the current room
~
Inventory(inv) - list the contents of your inventory
~
get item - to get an item from the room and add it to your inventory
~
drop item - to drop an item from your inventory into the room.
~
exit - leave the game
~
help - print the available commands and what they do
      """
    )
  }
}