import utils.GameRunner
import scala.io.StdIn.readLine

object DiceGame {

  def main(args: Array[String]): Unit =
    println("Welcome to Santhosh DiceGame!\nPress any key to start playing")
    val discard = readLine()
    val runner = GameRunner()

    runner.run()

}
