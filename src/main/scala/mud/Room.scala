package mud
import scala.xml._

class Room(
    val num: Int,
    val name: String,
    val shortDesc: String,
    private var items: List[Item],
    private val exits: Array[Int]
    ) {


  def description(): String = {
    var output = ""                                                                    //output is our final we are returning. we append things to outstring as we go. 
    val arrayOfDirections = Array("north","east","south","west","up","down")          //Array of directions is used as a reference for validDir. Since the directions our player can go in a room are static 0-6 
    val validDir = for(i <- 0 until 6 if(exits(i) >= 0) ) yield {                      //(-1 being a non-valid direction). If our exits are >0 they exist, and thus we can call ArrayOfDirections
      arrayOfDirections(i) 
    }
    var roomInv = ""
    if(items.isEmpty) roomInv = "There are no Items in the room." else 
      for(i <- items){
        roomInv = roomInv+i.name
      }
      roomInv

    output = "You are in the "+name+"\n"+shortDesc+"\n"+"Available exits: \n"
    output = output+validDir.mkString("\n")
    output = output+"\n"+"Items: \n"+roomInv
    //output = output+"\n"+"your items are: \n"+items.map(_.name).mkString(" ")
    output

    //find Player's room #
    //print room name
    //find "description" in XML doc
    //print Exits
    //check if any items available
    //Print Items
  }

    // n = 0
    // e = 1
    // s = 2
    // w = 3
    // u = 4
    // d = 5
  def getExit(dir: Int): Option[Room] = {
    if(exits(dir) < 0) None else Some(Room.rooms(exits(dir))) //Right now, my getExit function is giving me the index location of my room, but not the room number. How do I change the function to use the room number instead? Greyson reccomends some sort of higher order function to filter/find the room number in the array. 
  }    
    // < 0 checks if the direction is valid
    //exits.find(_)
    //we want getExit to check inside room to see if what the user requests lines up, if so, pass Some(Room) back
    //we are already in Room
      //check if Room contains Dir
        //if So, move player to Dest
        //if Not, println"Invalid Direction"

    //find player room #
    //grab exits & destinations
    //print
  


  def getItem(itemName: String): Option[Item] = {
    items.find(_.name.toLowerCase == itemName.toLowerCase) match {
      case Some(item) =>
        items = items.filter(_ != item)
        Some(item)
      case None => None
    }
  }

  def dropItem(item: Item): Unit = items ::= item

}

object Room {
  val rooms = readRooms()
  def readRooms():Array[Room] = {
    val xmlData = XML.loadFile("Map.xml")
    (xmlData \ "room").map(roomFromNode).toArray
  }

    def itemFromNode(n:Node):Item = {
      val itemName = (n \ "@name").text 
      val itemDesc = n.text
      new Item(itemName,itemDesc)
    }

    def roomFromNode(n:Node):Room = {
      val num = (n \ "@roomNum").text.toInt
      val name = (n \ "@roomName").text
      val shortDesc = (n \ "desc").text
      val items = (n \\ "item").map(itemFromNode).toList
      val exits = (n \\ "exit").text.split(", ").map(_.trim.toInt).toArray  
      new Room(num, name, shortDesc, items, exits)
    }

}



