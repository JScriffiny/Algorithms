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
    def link(list1: Node, list2: Node, carry: Int): Node =
    (list1,list2) match {
      case (ListNode(item1,next1),ListNode(item2,next2)) => {
        val sum = item1+item2+carry
        if (sum > 9) ListNode(sum%10,link(next1,next2,1))
        else ListNode(sum,link(next1,next2,0))
      }
      case _ => {
        var cur = list1
        if (list1 == Empty) cur = list2
        cur match {
          case ListNode(item,next) => {
            val sum = item+carry
            if (sum == 10) {
              if (next == Empty)
                ListNode(0,link(ListNode(1, Empty),Empty,0))
              else ListNode(0,link(next,Empty,1))
            }
            else ListNode(sum,link(next,Empty,0))
          }
          case _ => Empty
        }
      }
    }
    link(list1,list2,0)
  }

  /**************   TESTING   **************/
  val tests = Array[(Node,Node,Node)](
    (Empty,Empty,Empty),

     // 99 + 1 = 100
    (ListNode(9, ListNode(9, Empty)),
     ListNode(1, Empty),
     ListNode(0, ListNode(0, ListNode(1, Empty)))),

     // 1 + 99 = 100
    (ListNode(1, Empty),
     ListNode(9, ListNode(9, Empty)),
     ListNode(0, ListNode(0, ListNode(1, Empty)))),

     // 997 + 4 = 1001
    (ListNode(9, ListNode(9, ListNode(9, ListNode(9, Empty)))),
     ListNode(1, Empty),
     ListNode(0, ListNode(0, ListNode(0, ListNode(0, ListNode(1, Empty)))))),

     // 198 + 2 = 200
    (ListNode(8, ListNode(9, ListNode(1, Empty))),
     ListNode(2, Empty),
     ListNode(0, ListNode(0, ListNode(2, Empty)))),

     // 342 + 465 = 807
    (ListNode(2, ListNode(4, ListNode(3, Empty))),
     ListNode(5, ListNode(6, ListNode(4, Empty))),
     ListNode(7, ListNode(0, ListNode(8, Empty)))),

     // 325 + 47 = 372
    (ListNode(5, ListNode(2, ListNode(3, Empty))),
     ListNode(7, ListNode(4, Empty)),
     ListNode(2, ListNode(7, ListNode(3, Empty))))
  )

  def parseNode(list: Node): String = list match {
    case Empty => "Empty"
    case ListNode(item,next) => {
      if (next == Empty) item.toString
      else item.toString + " -> " + parseNode(next)
    }
  }

  def displayNum(list: Node): String = list match {
    case Empty => "0"
    case ListNode(item,next) => {
      if (next == Empty) item.toString
      displayNum(next) + item.toString
    }
  }

  def stripLeadZero(s: String): String = {
    var i = 0
    var s2 = s
    if (s == "") ""
    else {
      var i = 0
      while (i < s2.length && s2(i).toString == "0") s2 = s2.stripPrefix("0")
      s2
    }
  }

  implicit class ConsoleColorise(val str: String) extends AnyVal {
    import Console._
    def red    = s"$RED$str"
    def green  = s"$GREEN$str"
    def white  = s"$WHITE$str"
    def cyan = s"$CYAN$str"
  }

  (1 to 60) foreach(_ => print("-"))
  println("\n#########   TESTING   #########")
  (1 to 60) foreach(_ => print("-"))
  print("\n")
  var testNum = 1
  for (test <- tests) {
    println(("Test #" + testNum).cyan)
    testNum += 1
    print("".white)
    println("Node 1: " + parseNode(test._1))
    println("Node 2: " + parseNode(test._2))
    println("Expected: " + parseNode(test._3))
    println("Received: " + parseNode(addLinkNums(test._1,test._2)))
    val sum = displayNum(test._1).toInt + displayNum(test._2).toInt
    println("Explanation: " + stripLeadZero(displayNum(test._1)) + " + " +
            stripLeadZero(displayNum(test._2)) + " = " + sum)
    if (test._3 == addLinkNums(test._1,test._2)) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 60) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => addLinkNums(test._1,test._2) == test._3)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 60) foreach(_ => print("-"))
  print("\n")
}
