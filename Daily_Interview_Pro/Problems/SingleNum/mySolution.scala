//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a list of numbers where every number occurs twice,
find the one number that occurs just once.

Challenge: Use O(1) space.
*/

import scala.collection.mutable.Map

object mySolution extends App {
  //Time-Complexity  - O(n log n)
  //Space-Complexity - O(1)
  def singleNum(list: List[Int]): Int = {
    if (list.tail.isEmpty) list.head
    else {
      val sorted = list.sorted //O(n log n)
      for (num <- sorted) { //O(n)
        if (num != sorted.tail.head) return num
      }
      throw new Exception("There is no value that appears once.")
    }
  }

  //Time-Complexity  - O(n)
  //Space-Complexity - O(n)
  /**def singleNum(list: List[Int]): Int = {
    val db = Map.empty[Int,Int]
    for (num <- list) db(num) = 1 + db.getOrElse(num, 0)
    for ((k,v) <- db) if (v == 1) return k
    throw new Exception("There is no value that appears once.")
  }*/

  //Tests
  val tests = Array[(List[Int],Int)](
    (List(1),1),
    (List(2,3,2),3),
    (List(4,3,2,4,1,3,2),1)
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
    println("Expected: " + test._2)
    println("Received: " + singleNum(test._1))
    if (singleNum(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => singleNum(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
