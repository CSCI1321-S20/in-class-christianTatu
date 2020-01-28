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
    name + shortDesc
    

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
    //exits.find(_)
    //we want getExit to check inside room to see if what the user requests lines up, if so, pass Some(Room) back
    //we are already in Room
      //check if Room contains Dir
        //if So, move player to Dest
        //if Not, println"Invalid Direction"

    //find player room #
    //grab exits & destinations
    //print
    ???
  }


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

    //readRooms is supposed to create our master Array of rooms, each
    // of which contain subArrays of exits, and a sub(list) of items
    
    
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
      val items = (n \ "item").map(itemFromNode).toList
      val exits = (n \\ "exit").toArray.map(_.text.toInt)  
      new Room(num, name, shortDesc, items, exits)
    }

}



