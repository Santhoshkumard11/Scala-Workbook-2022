import utils.GameRunner
import scala.io.StdIn.readLine

object DiceGame {

  def main(args: Array[String]): Unit =
    println("Welcome to Santhosh DiceGame!\nPress any key to start playing")

    // this is not needed but just in case
    val _ = readLine()
    val runner = GameRunner()

    // try to print all the args passed
    args.foreach(println)
    runner.run()

}
