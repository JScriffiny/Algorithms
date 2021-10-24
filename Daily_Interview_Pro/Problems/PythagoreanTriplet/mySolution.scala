//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a list of numbers, find if there exists a pythagorean triplet. A pythagorean
triplet is three variables (a, b, c) where a^2 + b^2 = c^2
*/

object mySolution extends App {
  def pyTriplet(list: List[Int]): Boolean = {
    false
  }

  //Tests
  val tests = Array[(List[Int],Boolean)](
    (List(),false),
    (List(1,2,3),false),
    (List(3,5,12,5,13),true)
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
    println("Data: " + test._1)
    println("Expected: " + test._2)
    println("Received: " + pyTriplet(test._1))
    if (pyTriplet(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => pyTriplet(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
