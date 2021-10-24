//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a mathematical expression with just single digits, plus signs, negative signs,
and brackets, evaluate the expression. Assume the expression is properly formed.
*/

object mySolution extends App {
  def evaluate(expr: String): Int = {
    0
  }

  //Tests
  val tests = Array[(String,Int)](
    ("1 + 2",3),
    ("- ( 3 + ( 2 - 1 ) )",-4)
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
    println(test._1)
    println("Expected: " + test._2)
    println("Received: " + evaluate(test._1))
    if (evaluate(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => evaluate(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
