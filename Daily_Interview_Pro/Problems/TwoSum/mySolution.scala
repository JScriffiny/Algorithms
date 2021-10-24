//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a list of numbers and a target number, return whether or not
there are two numbers in the list that add up to the target.

Challenge: Try to do it in a single pass of the list.
*/

import scala.collection.mutable.HashSet

object mySolution extends App {

  //One Pass: O(n log n)
  def twoSum(list: List[Int], target: Int): Boolean = {
    if (list.isEmpty || list.tail.isEmpty) false
    else {
      val seen = HashSet[Int](list.head)
      for (num <- list.tail) {
        seen += num
        if (seen.contains(target-num)) return true
      }
      false
    }
  }

  //Brute Force: O(n^2)
  /**def twoSum(list: List[Int], target: Int): Boolean = {
    def getSum(cur: Int, rest: List[Int]): Int = {
      if (rest.tail.isEmpty) cur+rest.head
      else if (cur+rest.head != target) getSum(cur,rest.tail)
      else target
    }
    if (list.isEmpty || list.tail.isEmpty) false
    else {
      var rest = list.tail
      for (num <- list) {
        if (getSum(num,rest) == target) return true
        if (rest.tail.nonEmpty) rest = rest.tail
      }
      false
    }
  }*/

  //Tests
  val tests = Array[(List[Int],Int,Boolean)](
    (List(),5,false),
    (List(3),3,false),
    (List(1,2),3,true),
    (List(-5,2),-3,true),
    (List(1,3,6),3,false),
    (List(4,7,1,-3,2),5,true),
    (List(-10,3,0,12,10),0,true)
  )

///////////////////////////////////////////////////////////////////

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
    println(test._1)
    println("Target: " + test._2)
    println("Expected: " + test._3)
    println("Received: " + twoSum(test._1,test._2))
    if (twoSum(test._1,test._2) == test._3) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => twoSum(test._1,test._2) == test._3)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
