import utils.Constant
import utils.Utils

class BaseGameJanken {
    private lateinit var controllerGame: ControllerGame
    private lateinit var valuePlayerOne: String
    private lateinit var valuePlayerTwo: String
    private lateinit var valuePlayAgain: String

    fun startGame() {
        controllerGame = ControllerGame()
        controllerGame.menuGame()
        do {
            do {
                print(Constant.MSG_INPUT_ONE)
                valuePlayerOne = readLine()?.uppercase() ?: Constant.EMPTY_VALUE
            } while (Utils.isWrongInput(valuePlayerOne))
            println(Constant.MSG_CHOOSE + valuePlayerOne)

            do {
                print(Constant.MSG_INPUT_TWO)
                valuePlayerTwo = readLine()?.uppercase() ?: Constant.EMPTY_VALUE
            } while (Utils.isWrongInput(valuePlayerTwo))
            println(Constant.MSG_CHOOSE + valuePlayerTwo)

            controllerGame.resultGame(valuePlayerOne, valuePlayerTwo)

            do {
                print(Constant.MSG_PLAY_AGAIN)
                valuePlayAgain = readLine()?.uppercase() ?: Constant.EMPTY_VALUE
            } while (Utils.isPlayAgainWrongInput(valuePlayAgain))
        } while (Utils.isPlayAgain(valuePlayAgain))
    }
}