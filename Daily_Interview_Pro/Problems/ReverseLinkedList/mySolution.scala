//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a singly-linked list, reverse the list.
Solve it recursively and iteratively.
*/

sealed abstract class Node
case class SList(item: Int, next: Node) extends Node
case object Empty extends Node

object mySolution extends App {
  def reverseRec(list: Node): Node = {
    def rev(cur: Node, soFar: Node): Node = cur match {
      case SList(x,xs) => rev(xs, SList(x,soFar))
      case _ => soFar
    }
    list match {
      case SList(x,xs) => rev(xs, SList(x, Empty))
      case _ => Empty
    }
  }
  def reverseIter(list: Node): Node = list match {
    case SList(x,SList(y,ys)) => {
      var cur: Node = SList(y,ys)
      var soFar = SList(x, Empty)
      var iterating = true
      while (iterating) {
        cur match {
          case SList(x,xs) => {
            soFar = SList(x,soFar)
            cur = xs
          }
          case Empty => iterating = false
        }
      }
      soFar
    }
    case _ => list
  }

  //Tests
  val tests = Array[(Node,Node)](
    (Empty,Empty),

    (SList(1, Empty),
     SList(1, Empty)),

    (SList(7, SList(4, Empty)),
     SList(4, SList(7, Empty))),

    (SList(1, SList(2, SList(3, SList(4, Empty)))),
     SList(4, SList(3, SList(2, SList(1, Empty)))))
  )

///////////////////////////////////////////////////////////////////

  def parseNode(list: Node): String = list match {
    case Empty => "Empty"
    case SList(item,next) => {
      if (next == Empty) item.toString
      else item.toString + " -> " + parseNode(next)
    }
  }

  implicit class ConsoleColorise(val str: String) extends AnyVal {
    import Console._
    def red    = s"$RED$str"
    def green  = s"$GREEN$str"
    def white  = s"$WHITE$str"
    def cyan   = s"$CYAN$str"
  }

  (1 to 50) foreach(_ => print("-"))
  println("\n#########   TESTING   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
  var testNum = 1
  for (test <- tests) {
    println(("Test #" + testNum).cyan)
    testNum += 1
    print("".white)
    println("SList: " + parseNode(test._1))
    println("Expected (Recursive): " + parseNode(test._2))
    println("Received (Recursive): " + parseNode(reverseRec(test._1)))
    if (reverseRec(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("\n".white)
    println("Expected (Iterative): " + parseNode(test._2))
    println("Received (Iterative): " + parseNode(reverseIter(test._1)))
    if (reverseIter(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test =>
    reverseRec(test._1) == test._2 && reverseIter(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
