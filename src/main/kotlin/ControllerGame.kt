import utils.Constant
import utils.StatusJanken
import utils.Utils
import kotlin.system.exitProcess

class ControllerGame : ControllerGameContract {
    override fun menuGame() {
        var inputMenu: String
        print(Constant.INTRO)
        print(Constant.MENU)
        do {
            print(Constant.MSG_INPUT_MENU)
            inputMenu = readLine() ?: Constant.EMPTY_VALUE
        } while (Utils.isWrongMenuNumber(inputMenu))

        when (inputMenu.toInt()) {
            1 -> println(Constant.MSG_PLAY_GAME)
            2 -> {
                println(Constant.MSG_EXIT_GAME)
                exitProcess(0)
            }
        }
    }

    override fun resultGame(input1: String?, input2: String?) {
        when (input1) {
            StatusJanken.ROCK.status -> {
                when (input2) {
                    StatusJanken.SCISSORS.status -> {
                        Utils.messageResult(Constant.MSG_PLAYER_ONE_WIN)
                    }
                    StatusJanken.PAPER.status -> {
                        Utils.messageResult(Constant.MSG_PLAYER_TWO_WIN)
                    }
                    else -> Utils.messageResult(Constant.MSG_DRAW)
                }
            }
            StatusJanken.PAPER.status -> {
                when (input2) {
                    StatusJanken.SCISSORS.status -> {
                        Utils.messageResult(Constant.MSG_PLAYER_TWO_WIN)
                    }
                    StatusJanken.ROCK.status -> {
                        Utils.messageResult(Constant.MSG_PLAYER_ONE_WIN)
                    }
                    else -> Utils.messageResult(Constant.MSG_DRAW)
                }
            }
            StatusJanken.SCISSORS.status -> {
                when (input2) {
                    StatusJanken.PAPER.status -> {
                        Utils.messageResult(Constant.MSG_PLAYER_ONE_WIN)
                    }
                    StatusJanken.ROCK.status -> {
                        Utils.messageResult(Constant.MSG_PLAYER_TWO_WIN)
                    }
                    else -> Utils.messageResult(Constant.MSG_DRAW)
                }
            }
        }
    }
}