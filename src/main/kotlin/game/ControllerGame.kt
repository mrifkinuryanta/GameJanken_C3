package game

import game.username.PlayerUsername
import utils.Constant
import utils.GameUtils
import utils.StatusJanken

class ControllerGame : ControllerGameContract {
    private lateinit var usernames: List<String>

    override fun inputUsername(): List<String> {
        val list = mutableListOf<String>()
        var valueInput: String
        var username1: String
        var username2: String

        do {
            print(Constant.MSG_INPUT_USERNAME)
            valueInput = readLine()?.uppercase().orEmpty()
        } while (GameUtils.isYesOrNoInput(valueInput))

        if (GameUtils.isYesOrNo(valueInput)) {
            do {
                print(Constant.MSG_INPUT_USERNAME_ONE)
                username1 = readLine().orEmpty()
            } while (GameUtils.isEmptyValue(username1))
            do {
                print(Constant.MSG_INPUT_USERNAME_TWO)
                username2 = readLine().orEmpty()
            } while (GameUtils.isEmptyValue(username2))

            val listUsername = listOf(username1, username2)
            list.addAll(listUsername)
            PlayerUsername(listUsername).printUsername()
        }
        return list
    }

    override fun resultGame(input1: String, input2: String, listUsername: List<String>) {
        usernames = listUsername
        when (input1) {
            StatusJanken.ROCK.value -> {
                when (input2) {
                    StatusJanken.SCISSORS.value -> {
                        messageResult(Constant.NUMBER_ONE)
                    }
                    StatusJanken.PAPER.value -> {
                        messageResult(Constant.NUMBER_TWO)
                    }
                    else -> messageResult(Constant.EMPTY_VALUE)
                }
            }
            StatusJanken.PAPER.value -> {
                when (input2) {
                    StatusJanken.SCISSORS.value -> {
                        messageResult(Constant.NUMBER_TWO)
                    }
                    StatusJanken.ROCK.value -> {
                        messageResult(Constant.NUMBER_ONE)
                    }
                    else -> messageResult(Constant.EMPTY_VALUE)
                }
            }
            StatusJanken.SCISSORS.value -> {
                when (input2) {
                    StatusJanken.PAPER.value -> {
                        messageResult(Constant.NUMBER_ONE)
                    }
                    StatusJanken.ROCK.value -> {
                        messageResult(Constant.NUMBER_TWO)
                    }
                    else -> messageResult(Constant.EMPTY_VALUE)
                }
            }
        }
    }

    private fun messageResult(value: String) {
        if (usernames.isNotEmpty()) {
            when (value) {
                Constant.NUMBER_ONE -> println(Constant.MSG_RESULT + usernames[0] + Constant.MSG_PLAYER_WIN)
                Constant.NUMBER_TWO -> println(Constant.MSG_RESULT + usernames[1] + Constant.MSG_PLAYER_WIN)
                else -> println(Constant.MSG_RESULT + Constant.MSG_DRAW)
            }
        } else {
            when (value) {
                Constant.NUMBER_ONE -> println(Constant.MSG_RESULT + Constant.MSG_PLAYER_ONE_WIN)
                Constant.NUMBER_TWO -> println(Constant.MSG_RESULT + Constant.MSG_PLAYER_TWO_WIN)
                else -> println(Constant.MSG_RESULT + Constant.MSG_DRAW)
            }
        }
    }
}