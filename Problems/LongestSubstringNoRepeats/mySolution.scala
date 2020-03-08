//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a string, find the length of the longest substring without repeating characters.
*/

import scala.collection.mutable.HashSet

object mySolution extends App {

  //O(n^2 log n)
  /**def uniqueRun(s: String): Int = {
    var best = 0
    for (i <- 0 until s.length) {
      var chars = HashSet[Char](s(i))
      var cur = 1
      if (i == s.length-1) cur = 1
      else {
        var j = i+1
        while (j < s.length && !chars.contains(s(j))) { // O(log n)
          cur += 1
          chars += s(j)
          j += 1
        }
        cur+1
      }
      best = best max cur
    }
    best
  }*/

  //O(n)
  val numChars = 256
  def uniqueRun(s: String): Int = {
    val chars = Array.fill(numChars)(0)
    var bestLen = 0
    var curLen = 0
    for (c <- s) {
      chars(c.toInt) += 1 //Increment the char's occurrences
      if (chars(c.toInt) == 1) { //Unique char
        curLen += 1
      }
      else { //Repeat char
        bestLen = bestLen max curLen
        chars(c.toInt) = 1
        curLen = 0
      }
    }
    bestLen
  }

  //Tests
  val tests = Array[(String,Int)](
    ("",0),
    ("a",1),
    ("abcde",5),
    ("abcab",3),
    ("abcalmnop",8),
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
