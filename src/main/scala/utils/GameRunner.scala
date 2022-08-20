package utils
import scala.util.Random.between
import utils.Player

// used to launch the game and handle players
class GameRunner {
  var playerList: List[Player] = List(Player("foo"), Player("bar"))
  var currentPlayer: Player = playerList.head
  var currentPlayerIndex = 0

  def getWinner: Player =
    playerList.maxBy(p=> (p.score,1))

  def printCurrentScore(): Unit =
    // print the score of the players
    println(s"Current Score:\n${playerList.head.name} - ${playerList.head.score}\n${playerList(1).name} - ${playerList(1).score}")

  def resetCurrentPlayer(): Unit =
    currentPlayer = playerList(currentPlayerIndex)

  def run(): Any =
    try
      var isDone = false
      var timePlayed = 0

      // never use a while true loop
      while !isDone
      do
        timePlayed += 1
        println(s"\nRolling $timePlayed - current player - ${currentPlayer.name}")
        // rolling the dice
        currentPlayer.score += between(1,6)

        // check if the player has won
        if currentPlayer.score >= 10 then
          isDone = true

        // swap current player
        currentPlayerIndex match
        case 0 => currentPlayerIndex = 1
        case 1 => currentPlayerIndex = 0

        resetCurrentPlayer()
        printCurrentScore()
        // sleep for two minutes before moving onto the next player
        Thread.sleep(2000)
      end while

      val winner: Player = getWinner

      println(s"The winner is ${winner.name} with ${winner.score} points in ${timePlayed/2
      } rounds")

    catch
      case c: RuntimeException => c.printStackTrace()
    finally
      println("Game over!")
}
