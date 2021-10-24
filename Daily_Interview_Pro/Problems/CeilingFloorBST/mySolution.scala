//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given an integer and a binary search tree, find the floor (less than or equal to) and
the ceiling (larger than or equal to) of the integer. It's possible that neither exists.
*/

sealed abstract class Tree
case class BST(left: Tree, item: Int, right: Tree) extends Tree
case object Empty extends Tree

object mySolution extends App {
  def findHugging(tree: Tree, k: Int): (Option[Int],Option[Int]) = {
    def hugging(tree: Tree, floor: Option[Int], ceiling: Option[Int]):
    (Option[Int],Option[Int]) = tree match {
      case BST(left,item,right) => {
        if (k < item) {
          val ceil = {if (ceiling != None) ceiling.get min item else item}
          hugging(left,floor,Some(ceil))
        }
        else if (k > item) {
          val flo = {if (floor != None) floor.get min item else item}
          hugging(right,Some(flo),ceiling)
        }
        else (Some(k),Some(k))
      }
      case _ => (floor,ceiling)
    }
    hugging(tree,None,None)
  }

  //Tests
  val tests = Array[(Tree,Int,(Option[Int],Option[Int]))](
    (Empty,0,(None,None)),
    (BST(Empty,2,BST(Empty,3,Empty)),1,(None,Some(2))),
    (BST(BST(Empty,2,Empty),3,Empty),1,(None,Some(2))),
    (BST(BST(Empty,3,Empty),5,BST(Empty,7,Empty)),5,(Some(5),Some(5))),
    (BST(BST(BST(Empty,2,Empty),4,BST(Empty,6,Empty)),8,
         BST(BST(Empty,10,Empty),12,BST(Empty,14,Empty))),5,(Some(4),Some(6)))
  )

///////////////////////////////////////////////////////////////////

  def parseTree(tree: Tree): String = tree match {
    case Empty => "*"
    case BST(left,item,right) =>
      item.toString + " -> (" + parseTree(left) + ", " + parseTree(right) + ")"
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
    println("BST:\n" + parseTree(test._1))
    println("k: " + test._2 + "\n")
    println("Expected: " + test._3)
    println("Received: " + findHugging(test._1,test._2))
    if (findHugging(test._1,test._2) == test._3) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => findHugging(test._1,test._2) == test._3)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
