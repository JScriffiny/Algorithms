//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given the root of a binary tree, invert the binary tree in place.
All left children should become right children, and all right children
should become left children.
*/

object mySolution extends App {
  def algorithm(): ??? = {
    ???
  }

  //Tests
  val tests = Array[(Tree,Tree)](
    (root=a(l=b(l=d,r=e),r=c(l=f,r=None)),root=a(l=c(l=None,r=f),r=b(l=e,r=d)))
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
    println("Received: " + algorithm(test._1))
    if (algorithm(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => algorithm(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
