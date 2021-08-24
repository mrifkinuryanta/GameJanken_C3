package game

import game.username.PlayerUsername
import utils.Constant
import utils.GameUtils
import utils.StatusJanken
import kotlin.system.exitProcess

class ControllerGame : ControllerGameContract {
    override fun menuGame() {
        var inputMenu: String
        print(Constant.INTRO)
        print(Constant.MENU)
        do {
            print(Constant.MSG_INPUT_MENU)
            inputMenu = readLine() ?: Constant.EMPTY_VALUE
        } while (GameUtils.isWrongMenuNumber(inputMenu))

        when (inputMenu) {
            Constant.NUMBER_TWO -> {
                println(Constant.MSG_EXIT_GAME)
                exitProcess(0)
            }
        }
    }

    override fun inputUsername(): List<String> {
        val list = mutableListOf<String>()
        var valueInput: String
        var username1: String
        var username2: String

        do {
            print(Constant.MSG_INPUT_USERNAME)
            valueInput = readLine()?.uppercase() ?: Constant.EMPTY_VALUE
        } while (GameUtils.isYesOrNoInput(valueInput))

        if (GameUtils.isYesOrNo(valueInput)) {
            do {
                print(Constant.MSG_INPUT_USERNAME_ONE)
                username1 = readLine() ?: Constant.EMPTY_VALUE
            } while (GameUtils.isEmptyValue(username1))
            do {
                print(Constant.MSG_INPUT_USERNAME_TWO)
                username2 = readLine() ?: Constant.EMPTY_VALUE
            } while (GameUtils.isEmptyValue(username2))

            val listUsername = listOf(username1, username2)
            list.addAll(listUsername)
            PlayerUsername(listUsername).printUsername()
        }
        return list
    }

    override fun resultGame(input1: String, input2: String, listUsername: List<String>) {
        when (input1) {
            StatusJanken.ROCK.value -> {
                when (input2) {
                    StatusJanken.SCISSORS.value -> {
                        GameUtils.messageResult(Constant.NUMBER_ONE, listUsername)
                    }
                    StatusJanken.PAPER.value -> {
                        GameUtils.messageResult(Constant.NUMBER_TWO, listUsername)
                    }
                    else -> GameUtils.messageResult(Constant.EMPTY_VALUE, listUsername)
                }
            }
            StatusJanken.PAPER.value -> {
                when (input2) {
                    StatusJanken.SCISSORS.value -> {
                        GameUtils.messageResult(Constant.NUMBER_TWO, listUsername)
                    }
                    StatusJanken.ROCK.value -> {
                        GameUtils.messageResult(Constant.NUMBER_ONE, listUsername)
                    }
                    else -> GameUtils.messageResult(Constant.EMPTY_VALUE, listUsername)
                }
            }
            StatusJanken.SCISSORS.value -> {
                when (input2) {
                    StatusJanken.PAPER.value -> {
                        GameUtils.messageResult(Constant.NUMBER_ONE, listUsername)
                    }
                    StatusJanken.ROCK.value -> {
                        GameUtils.messageResult(Constant.NUMBER_TWO, listUsername)
                    }
                    else -> GameUtils.messageResult(Constant.EMPTY_VALUE, listUsername)
                }
            }
        }
    }
}