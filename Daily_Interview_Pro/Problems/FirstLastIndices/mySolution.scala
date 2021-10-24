//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a sorted array with possibly duplicate elements, find the indices of
the first and last occurrences of a target element. Return (-1,-1) if the
target is not found.
*/

object mySolution extends App {
  // Big-O: O(log n)
  def firstLast(x: Int, arr: Array[Int]): (Int,Int) = {
    if (arr.isEmpty) (-1,-1)
    else {
      def findFirst(lower: Int, upper: Int): Int = {
        var lo = lower
        var hi = upper
        while (lo < hi) {
          val mid = (lo+hi)/2
          if (arr(mid) < x) lo = mid+1
          else hi = mid
        }
        lo
      }
      def findSecond(lower: Int, upper: Int): Int = {
        var lo = lower
        var hi = upper
        while (lo < hi) {
          val mid = (lo+hi)/2
          if (arr(mid) == x) lo = mid+1
          else hi = mid
        }
        if (arr(lo) == x) lo
        else lo-1
      }
      val first = findFirst(0,arr.length-1)
      if (arr(first) == x) (first,findSecond(first,arr.length-1))
      else (-1,-1)
    }
    //Linear Solution - O(n)
    /**for (i <- 0 until arr.length) {
      if (arr(i) == x) {
        for (j <- arr.length-1 to i by -1)
          if(arr(j) == x) return (i,j)
      }
    }
    (-1,-1)*/
  }

  //Tests
  val tests = Array[(Int,Array[Int],(Int,Int))](
    (0,Array(),(-1,-1)),
    (4,Array(4),(0,0)),
    (3,Array(1,2,4,5),(-1,-1)),
    (5,Array(0,0,5,5,5,5,5,10,10),(2,6)),
    (1,Array(0,1,1,1,1,1,1,1),(1,7)),
    (9,Array(1,3,3,5,7,8,9,9,9,15),(6,8)),
    (150,Array(100,150,150,153),(1,2)),
    (5,Array(0,1,2,3,4,5,6,7,8,9),(5,5))
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
    println(test._2.toList)
    println("Target: " + test._1)
    println("Expected: " + test._3)
    println("Received: " + firstLast(test._1,test._2))
    if (firstLast(test._1,test._2) == test._3) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => firstLast(test._1,test._2) == test._3)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
