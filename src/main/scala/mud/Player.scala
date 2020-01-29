package mud

class Player(val name: String, val loc: Room, var inv: List[Item]) {
    //do I need an "exits" list or array? or will this be
    // a command that calls the array of exits in loc and prints from there?

    def processCommand(command: String): Unit = {
         val com = command.split(" +",2)
         com(0).trim.toLowerCase match {
            case "north" | "n" | "east" | "e" | "south" | "s" | "west" | "w" | "up" | "u" | "down" | "d" => move(command)
            
            case "look" | "l" => println(loc.description)
            
            case "inventory" | "inv" => inventoryListing()
            
            case "get" =>  getToInventory(com(1))     getItem(com(1))

            case "drop" => dropFromInventory(com(1))  dropItem(com(1))

            //case "exit" | "quit" => playerInput = "exit"

            case "help" => help()

            case _ => println("Command not recognized. type \"help\" to see a list of commands")
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
        if(inv.isEmpty) None

        else {
            
         if(inv.contains(itemName)) {
                inv = inv.filter(_ != itemName)
            Some(itemName)
            }
            None 
        }
    }
            
        
    

    def getToInventory(item: Item): Unit = {        //used to be add, i changed the name to getToInventory from dropToInventory
        items ::= inv
        //- Add the given item to inventory.
       // remove item froom Room inventory and add it to player inventory, 
    }

    def inventoryListing(): String = {
        var genString = ""                              //Empty String genString
        for(i <- inv) {                                 //in this for loop, I going through List of Item (using i)  and building the name and desc onto genString
            genString = genString+i.name+" - "+i.desc            
        }
    genString

        //- Build a String with the contents of the inventory for printing.
        //take each item in Player's List:Inventory and append it to a string, then print
    }

    def move(command: String): Unit = {
        val input = readLine()
         input.split(" +",2)
        input(0).toLowerCase match {
        case "north" || "n" => ??? dir = 0
        case "east" || "e" => ??? dir = 1         
        case "south" || "s" => ??? dir = 2
        case "west" || "w" => ??? dir = 3
        case "up" | "u" => ??? dir = 4
        case "down" | "d" => ??? dir = 5
        }
    }   

    //def move(dir: String): Unit = {
        //- Move the player in a particular direction if possible.
        //read input, if Room[Exits] contains a location AND destination
            //update player to that new destination
        //???

    //}
    
    def help(command: String): Unit = {
        def help(): Unit = {
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
}