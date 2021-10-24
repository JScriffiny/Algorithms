//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given an array of integers in an arbitrary order, return whether or not
it is possible to make the array purely decreasing by modifying at most
one element to any value.

An array is non-decreasing if array(i) <= array(i+1) holds for every i,
where 1 <= i < n.
*/

object mySolution extends App {
  def pureDescension(arr: Array[Int]): Boolean = {
    if (arr.isEmpty) false
    else {
      true
    }
  }

  //Tests
  val tests = Array[(Array[Int],Boolean)](
    (Array(),false),
    (Array(13,4,7),true),
    (Array(13,4,1),false)
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
    println(test._1.toList)
    println("Expected: " + test._2)
    println("Received: " + pureDescension(test._1))
    if (pureDescension(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => pureDescension(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
