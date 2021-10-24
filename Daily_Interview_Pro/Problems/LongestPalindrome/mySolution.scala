//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
A palindrome is a sequence of characters that reads the same backwards and forwards.
Given a string, s, find the longest palindromic substring in s.
*/

object mySolution extends App {
  def longestPal(s: String): String = {
    var best = ""
    for (i <- 0 until s.length) {
      var lo = i-1
      var hi = i+1
      var pal = s(i).toString
      while (lo >= 0 && hi <= s.length-1) {
        if (s(lo) == s(hi)) {
          pal = s(lo).toString + pal + s(hi).toString
          lo -= 1
          hi += 1
        }
        else if (s(lo+1) == s(hi)) {
          pal = s(lo+1).toString + s(hi).toString
          hi += 1
        }
        else lo = -1
      }
      if (lo == 0 && s(lo) == s(i)) pal += s(lo).toString
      else if (hi == s.length-1 && s(hi) == s(i)) pal += s(hi).toString
      if (pal.length > best.length) best = pal
    }
    best
  }

  //Tests
  val tests = Array[(String,String)](
    ("",""),
    ("a","a"),
    ("bbbb","bbbb"),
    ("ccccc","ccccc"),
    ("banana","anana"),
    ("million","illi"),
    ("racecar","racecar"),
    ("abbcccdde","ccc"),
    ("aaXlmnoXaaaaa","aaaaa")
  )

///////////////////////////////////////////////////////////////////

  implicit class ConsoleColorise(val str: String) extends AnyVal {
    import Console._
    def red    = s"$RED$str"
    def green  = s"$GREEN$str"
    def white  = s"$WHITE$str"
    def cyan   = s"$CYAN$str"
  }

  (1 to 60) foreach(_ => print("-"))
  println("\n#########   TESTING   #########")
  (1 to 60) foreach(_ => print("-"))
  print("\n")
  var testNum = 1
  for (test <- tests) {
    val output = longestPal(test._1)
    println(("Test #" + testNum).cyan)
    testNum += 1
    print("".white)
    println("String: " + test._1)
    println("Expected: " + test._2)
    println("Received: " + output)
    if (output == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 60) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => longestPal(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 60) foreach(_ => print("-"))
  print("\n")
}
