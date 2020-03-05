//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a string, find the length of the longest substring without repeating characters.
*/

import scala.collection.mutable.HashSet

object mySolution extends App {

  //Second Attempt (linear) - O(n)
  //Referenced geeksforgeeks.org
  val numChars = 256
  def uniqueRun(s: String): Int = {
    val visited = Array.fill(numChars)(-1)
    var bestLen = 0
    for (i <- 0 until s.length) {
      visited(s(i).toInt) += 1 //Log the char in visited
      var curLen = 0
      if (visited(s(i).toInt) == 0) { //Unique char
        curLen += 1
        visited(s(i).toInt) += 1
      }
      else { //Repeat char
        visited(s(i).toInt) += curLen
      }
      bestLen = bestLen max curLen
    }
    bestLen
  }

  //First Attempt (too slow) - O(n^2 log n)
  /**def uniqueRun(s: String): Int = {
    var best = 0
    for (i <- 0 until s.length) {
      var visited = HashSet[Char](s(i))
      var cur = 1
      if (i == s.length-1) cur = 1
      else {
        var j = i+1
        while (j < s.length && !visited.contains(s(j))) { // O(log n)
          cur += 1
          visited += s(j)
          j += 1
        }
        cur+1
      }
      best = best max cur
    }
    best
  }*/

  //Tests
  val tests = Array[(String,Int)](
    ("",0),
    ("a",1),
    ("abcde",5),
    ("abcab",3),
    ("abrkaabcdefghijjxxx",10)
  )

///////////////////////////////////////////////////////////////////

  implicit class ConsoleColorise(val str: String) extends AnyVal {
    import Console._
    def red    = s"$RED$str"
    def green  = s"$GREEN$str"
    def white  = s"$WHITE$str"
    def cyan = s"$CYAN$str"
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
    println("Received: " + uniqueRun(test._1))
    if (test._2 == uniqueRun(test._1)) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => uniqueRun(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
