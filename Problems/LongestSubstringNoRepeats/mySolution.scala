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

  println("#########   TESTING   #########")
  for (test <- tests) {
    println(test._1)
    println("Expected: " + test._2)
    println("Received: " + uniqueRun(test._1))
    println("-------------------")
  }
  val num = tests.count(test => uniqueRun(test._1) == test._2)
  println("Passed " + num + "/" + tests.length + " tests")
}
