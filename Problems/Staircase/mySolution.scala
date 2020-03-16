//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a positive integer that represents the number of steps in
a staircase, write a function that returns the total number of
unique ways to climb the stairs by climbing either one or two
steps a time.

Challenge: Find a solution in O(n) time.
*/

object mySolution extends App {
  //Dynamic Programming
  def staircase(height: Int): Int = {
    if (height < 3) height
    else {
      val climb = Array.fill(height+2)(0)
      for (stair <- height to 0 by -1) climb(stair) = {
        if (stair >= height-1) 1
        else if (stair >= height-2) 2
        else climb(stair+1) + climb(stair+2)
      }
      climb(0)
    }
  }

  //Memoization
  /**def staircase(height: Int): Int = {
    if (height < 3) height
    else {
      val memo = Array.fill(height+2)(-99)
      def climb(stair: Int): Int = {
        if (stair == height-1) 1
        else if (stair == height-2) 2
        else {
          if (memo(stair) == -99) memo(stair) = {
            climb(stair+1) + climb(stair+2)
          }
          memo(stair)
        }
      }
      climb(0)
    }
  }*/

  //Original
  /**def staircase(height: Int): Int = {
    def climb(stair: Int): Int = {
      if (stair == height-1) 1
      else if (stair == height-2) 2
      else climb(stair+1) + climb(stair+2)
    }
    climb(0)
  }*/

  //Tests
  val tests = Array[(Int,Int)](
    (0,0),
    (1,1),
    (2,2),
    (3,3),
    (4,5),
    (5,8),
    (6,13)
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
    println("Stairs: " + test._1)
    println("Expected: " + test._2)
    println("Received: " + staircase(test._1))
    if (staircase(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => staircase(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
