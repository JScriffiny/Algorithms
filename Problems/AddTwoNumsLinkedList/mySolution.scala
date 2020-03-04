//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
You are given two linked-lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single digit.
Add the two numbers and return it as a linked list.
*/

sealed abstract class Node
case class ListNode(item: Int, next: Node) extends Node
case object Empty extends Node

object mySolution extends App {
  def addLinkNums(list1: Node, list2: Node): Node = {
    Empty
  }

  /**************   TESTING   **************/
  val tests = Array[(Node,Node,Node)](
    (Empty,Empty,Empty),

    (ListNode(9, ListNode(9, Empty)),               //   99
     ListNode(1, Empty),                            // +  1
     ListNode(0, ListNode(0, ListNode(1, Empty)))), // =100

    (ListNode(2, ListNode(4, ListNode(3, Empty))),  //  342
     ListNode(5, ListNode(6, ListNode(4, Empty))),  // +465
     ListNode(7, ListNode(0, ListNode(8, Empty)))), // =807

    (ListNode(1, ListNode(2, ListNode(3, Empty))), //  321
     ListNode(7, ListNode(4, ListNode(0, Empty))), // + 47
     ListNode(8, ListNode(6, ListNode(3, Empty)))) // =368
  )

  println("#########   TESTING   #########")
  for (test <- tests) {
    println("Node 1: " + test._1)
    println("Node 2: " + test._2)
    println()
    println("Expected: " + test._3)
    println("Received: " + addLinkNums(test._1,test._2))
    println("-------------------")
  }
  val num = tests.count(test => addLinkNums(test._1,test._2) == test._3)
  println("Passed " + num + "/" + tests.length + " tests")
}
