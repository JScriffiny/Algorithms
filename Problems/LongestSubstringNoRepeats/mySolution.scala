//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a string, find the length of the longest substring without repeating characters.
*/

import scala.collection.mutable.HashSet

object mySolution extends App {
  def uniqueRun(s: String): Int = {
    def longest(i: Int, hs: HashSet[Char]): Int = {
      if (i == s.length-1) 1
      else {
        var best = 0
        var j = i+1
        while (j < s.length && !hs.contains(s(j))) {
          best += 1
          hs += s(j)
          j += 1
        }
        best+1
      }
    }
    var best = 0
    for (i <- 0 until s.length) {
      best = best max longest(i,HashSet[Char](s(i)))
    }
    best
  }

  /**************   TESTING   **************/
  val tests = Array[(String,Int)](
    ("",0),
    ("a",1),
    ("abcde",5),
    ("abcab",3),
    ("abrkaabcdefghijjxxx",10)
  )

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
    println(test._1)
    println("Expected: " + test._2)
    println("Received: " + uniqueRun(test._1))
    if (test._2 == uniqueRun(test._1)) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 60) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => uniqueRun(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 60) foreach(_ => print("-"))
  print("\n")
}
