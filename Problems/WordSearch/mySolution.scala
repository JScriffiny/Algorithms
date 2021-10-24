//Name: Jacob Scriffiny
//File: mySolution.scala

/** Problem:
Given a 2D-Array of characters and a target string, return whether or not the target word
exists in the matrix. Unlike a standard word search, the word must be going left-to-right
or top-to-bottom in the matrix.
*/

object mySolution extends App {
  def wordSearch(board: Array[Array[Char]],target: String): Boolean = {
    false
  }

  //Tests
  val testBoard: Array[Array[Char]] = Array(
    Array[Char]('F','A','C','I'),
    Array[Char]('O','B','Q','P'),
    Array[Char]('A','N','O','B'),
    Array[Char]('M','A','S','S')
  )
  val tests = Array[(Array[Array[Char]],String,Boolean)](
    (testBoard,"",false),
    (testBoard,"FOAM",true),
    (testBoard,"MASS",true),
    (testBoard,"NOB",true),
    (testBoard,"FACT",false)
  )

///////////////////////////////////////////////////////////////////

  def parseBoard(board: Array[Array[Char]]): String = {
    var result = ""
    for (arr <- board) {
      result += "("
      for (c <- arr) {
        result += (c.toString + ", ")
      }
      result = result.stripSuffix(", ")
      result += ")\n"
    }
    result.stripSuffix("\n")
  }

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
    println("Board:\n" + parseBoard(test._1))
    println("Target: " + test._2 + "\n")
    println("Expected: " + test._3)
    println("Received: " + wordSearch(test._1,test._2))
    if (wordSearch(test._1,test._2) == test._3) println("PASSED".green)
    else println("**FAILED**".red)
    print("".white)
    print("\n")
    (1 to 50) foreach(_ => print("-"))
    print("\n")
  }
  val num = tests.count(test => wordSearch(test._1,test._2) == test._3)
  println("#########   Passed " + num + "/" + tests.length + " tests   #########")
  (1 to 50) foreach(_ => print("-"))
  print("\n")
}
