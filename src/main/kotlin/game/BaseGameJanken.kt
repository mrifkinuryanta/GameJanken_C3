package game

import utils.Constant
import utils.GameUtils
import kotlin.system.exitProcess

class BaseGameJanken {
    private lateinit var listUsername: List<String>
    private lateinit var valueInputMenu: String
    private lateinit var valuePlayerOne: String
    private lateinit var valuePlayerTwo: String
    private lateinit var valuePlayAgain: String
    private val controllerGame = ControllerGame()

    fun startGame() {
        navigateToMainMenu()
    }

    private fun navigateToMainMenu() {
        print(Constant.HEADER)
        do {
            print(Constant.MSG_INPUT_MENU)
            valueInputMenu = readLine().orEmpty()
        } while (GameUtils.isWrongMenuNumber(valueInputMenu))
        navigateToMenu(valueInputMenu)
    }

    private fun navigateToMenu(menu: String) {
        when (menu) {
            Constant.NUMBER_ONE -> playGame()
            Constant.NUMBER_TWO -> {
                println(Constant.MSG_EXIT_GAME)
                exitProcess(0)
            }
        }
    }

    private fun playGame() {
        listUsername = controllerGame.inputUsername()
        println(Constant.MSG_PLAY_GAME)
        do {
            do {
                printMessageInput(Constant.NUMBER_ONE)
                valuePlayerOne = readLine()?.lowercase().orEmpty()
            } while (GameUtils.isWrongInput(valuePlayerOne))
            println(Constant.MSG_CHOOSE + valuePlayerOne)

            do {
                printMessageInput(Constant.NUMBER_TWO)
                valuePlayerTwo = readLine()?.lowercase().orEmpty()
            } while (GameUtils.isWrongInput(valuePlayerTwo))
            println(Constant.MSG_CHOOSE + valuePlayerTwo)

            controllerGame.resultGame(valuePlayerOne, valuePlayerTwo, listUsername)

            do {
                print(Constant.MSG_PLAY_AGAIN)
                valuePlayAgain = readLine()?.uppercase().orEmpty()
            } while (GameUtils.isYesOrNoInput(valuePlayAgain))
        } while (playAgain(GameUtils.isYesOrNo(valuePlayAgain)))
    }

    private fun playAgain(state: Boolean): Boolean {
        return if (state) {
            println(Constant.MSG_PLAY_GAME)
            state
        } else {
            navigateToMainMenu()
            state
        }
    }

    private fun printMessageInput(value: String) {
        if (listUsername.isNotEmpty()) {
            when (value) {
                Constant.NUMBER_ONE -> print("\n" + listUsername[0] + Constant.MSG_INPUT)
                Constant.NUMBER_TWO -> print("\n" + listUsername[1] + Constant.MSG_INPUT)
            }
        } else {
            when (value) {
                Constant.NUMBER_ONE -> print(Constant.MSG_INPUT_ONE)
                Constant.NUMBER_TWO -> print(Constant.MSG_INPUT_TWO)
            }
        }
    }
}