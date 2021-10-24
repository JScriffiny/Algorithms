//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a list of numbers with only three unique numbers,
sort the list in O(n) time using constant space.
*/

import scala.collection.mutable.Map

object mySolution extends App {

  // Big-O: O(3)
  def revSort(db: Map[Int,Int]): Array[(Int,Int)] = {
    val arr = Array.fill(3)((Int.MinValue,0)) //O(3)
    var i = 0
    for ((k,v) <- db) { //O(3)
      if (i == 0) arr(2) = ((k,v))
      else if (i == 1) {
        if (k > arr(2)._1) arr(1) = ((k,v))
        else {
          arr(1) = arr(2)
          arr(2) = ((k,v))
        }
      }
      else {
        if (k > arr(1)._1) arr(0) = ((k,v))
        else if (k > arr(2)._1) {
          arr(0) = arr(1)
          arr(1) = ((k,v))
        }
        else {
          arr(0) = arr(1)
          arr(1) = arr(2)
          arr(2) = ((k,v))
        }
      }
      i += 1
    }
    arr
  }

  // Big-O: O(n)
  def sort3(nums: List[Int]): List[Int] = {
    val db = Map.empty[Int,Int]
    for (num <- nums) db(num) = 1 + db.getOrElse(num, 0) //O(n)
    var list = List[Int]()
    for ((k,v) <- revSort(db); i <- 0 until v) list = k :: list //O(n + 3)
    list
  }

  //Tests
  val tests = Array[(List[Int],List[Int])](
    (List(),List()),
    (List(3,2,1),List(1,2,3)),
    (List(2,2,3,3,1,1),List(1,1,2,2,3,3)),
    (List(3,3,2,1,3,2,1),List(1,1,2,2,3,3,3)),
    (List(70,0,-30,0,0,-30,70),List(-30,-30,0,0,0,70,70))
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
    println("Received: " + sort3(test._1))
    if (sort3(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => sort3(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
