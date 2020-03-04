//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:

*/

object mySolution extends App {
  def algorithm(): ??? = {
    ???
  }

  /**************   TESTING   **************/
  val tests = Array[???](
    ???
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
    println("Data: " + test._1)
    println("Expected: " + test._2)
    println("Received: " + algorithm(test._1))
    if (algorithm(test._1) == test._2) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 60) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => algorithm(test._1) == test._2)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 60) foreach(_ => print("-"))
  print("\n")
}
