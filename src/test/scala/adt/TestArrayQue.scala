package adt

import org.junit.Test
import org.junit.Assert._
import org.junit.Before

class TestArrayQueue {
   var q: ArrayQueue[Int] = null

    @Before  def createQueue = {
        q: new ArrayQueue[Int]
    }
    
        @Test def emptyOnNew(): Unit = {
        val q = new ArrayQueue[Int]
        assertTrue(q.isEmpty)
    }

    @Test def addRemoveOne(): Unit = {
       q.enqueue(5)
       assertFalse(q.isEmpty)
       assertEquals(5, q.peek)
       assertEquals(5, q.dequeue())
       
    }

}
}