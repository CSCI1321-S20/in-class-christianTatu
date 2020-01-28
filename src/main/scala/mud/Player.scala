package mud

class Player(val name: String, val loc: Int, var inv: List[Item]) {
    //do I need an "exits" list or array? or will this be
    // a command that calls the array of exits in loc and prints from there?

    def processCommand(command: String): Unit = {
        val input = readLine()
        input.toString
    //split input on spaces 
    //read first word, branch from there 

        //input.split(" +",2)            //" +" splits on spaces, 2 gives you MAX 2 diff items


        //OR

        //input.startsWith (first command)
        //input.drop        
    ???

    }

    def getFromInventory(itemName: String): Option[Item] = {
        //- Pull an item out of the inventory (if it exists) and return it.
        //filter inventory for name of item, if empty, return error
        //if there, remove it from player inv and add to room inventory
        ???
    }

    def addToInventory(item: Item): Unit = {
       //- Add the given item to inventory.
       // remove item froom Room inventory and add it to player inventory, 
       ???


    }

    def inventoryListing(): String = {
        //- Build a String with the contents of the inventory for printing.
        //take each item in Player's List:Inventory and append it to a string, then print
        ???
    }

    def move(dir: String): Unit = {
        //- Move the player in a particular direction if possible.
        //read input, if Room[Exits] contains a location AND destination
            //update player to that new destination
        ???

    }
    
    //def help
    def help(command: String): Unit = {
        val input = readLine()
        input.toString.trim
        if(input.toLowerCase == "help") {
            println(
            """
            \n move - moves your player in a direction
            \n  movement: Type North(N), East(E), South(S) West(W) Up(U) or Down(D)
            \n look - reprints the description of the current room
            \n Inventory(inv) - list the contents of your inventory
            \n get item - to get an item from the room and add it to your inventory
            \n drop item - to drop an item from your inventory into the room.
            \n exit - leave the game
            \n help - print the available commands and what they do
            """
            )
        }
    }
       //Do Movement

//     def move(command: String): Unit = {
//         val input = readLine()
//          input.split(" +",2)
//         input(0).tolowercase match {
//         case "north" || n => ??? dir = 0
//         case east || e => ??? dir = 1         
//         case south || s => ??? dir = 2
//         case west || w => ??? dir = 3
//         case up | u => ??? dir = 4
//         case down | d => ??? dir = 5
      
      
//         items = items.filter(_ != item)
//         Some(item)
//       case None => None
//     }
//   }
//             println(
    
}