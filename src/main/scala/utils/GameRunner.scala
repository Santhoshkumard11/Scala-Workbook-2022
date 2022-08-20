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


  def run(): Any =
    try
      var isDone = false
      while !isDone
      do
        currentPlayer.score += between(1,6)
        if currentPlayer.score >= 50 then
          isDone = true

        currentPlayerIndex match
        case 0 => currentPlayerIndex = 1
        case 1 => currentPlayerIndex = 0
        for player <- playerList
        do
          println(s"Current Score:\n${player.name} - ${player.score}")
        currentPlayer = playerList(currentPlayerIndex)
      end while

      val winner: Player = getWinner

      println(s"The winner is ${winner.name} with ${println(winner.score)} points")

    catch
      case c: RuntimeException => c.printStackTrace()
    finally
      println("Game over!")

}
