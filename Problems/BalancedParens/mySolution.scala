//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Imagine you are building a compiler. Before running any code, the compiler must
check that the parentheses in the program are balanced. Every opening bracket
must have a corresponding closing bracket. We can approximate this using strings.

Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.
An input string is valid if:
- Open brackets are closed by the same type of brackets.
- Open brackets are closed in the correct order.
- Note that an empty string is also considered valid.
*/

object mySolution extends App {
  def isBalanced(s: String): Boolean = {
    false
  }

  //Tests
  val tests = Array[(String,Boolean)] (
    ("((()))",true),
    ("[()]{}",true),
    ("({[)]",false)
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
    println(("Test #" + testNum).cyan)
    testNum += 1
    print("".white)
    println("Data: " + test._1)
    println("Expected: " + test._2)
    println("Received: " + isBalanced(test._1))
    if (isBalanced(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 60) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => isBalanced(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 60) foreach(_ => print("-"))
  print("\n")
}
