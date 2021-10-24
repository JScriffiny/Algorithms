//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given two strings, determine the edit distance between them. The edit distance is
defined as the minimum number of edits (insertion, deletion, or substitution) needed
to change one string to the other.
*/

object mySolution extends App {
  def editDistance(s1: String, s2: String): Int = {
    0
  }

  //Tests
  val tests = Array[(String,String,Int)](
    ("","",0),
    ("abc","bc",1),
    ("biting","sitting",2)
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
    println("s1: " + test._1)
    println("s2: " + test._2)
    println("Expected: " + test._3)
    println("Received: " + editDistance(test._1,test._2))
    if (editDistance(test._1,test._2) == test._3) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => editDistance(test._1,test._2) == test._3)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
