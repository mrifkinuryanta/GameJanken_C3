package utils

object Utils {
    fun isPlayAgain(value: String?): Boolean {
        var state = false
        if (value == Constant.CHAR_Y) {
            state = true
            println(Constant.playGame)
        } else {
            println(Constant.exitGame)
        }
        return state
    }

    fun isWrongInput(value: String?): Boolean {
        return if (value.equals(StatusJanken.ROCK.status) || value.equals(StatusJanken.PAPER.status) || value.equals(StatusJanken.SCISSORS.status)) {
            false
        } else {
            isWrongMessage()
        }
    }

    fun isPlayAgainWrongInput(value: String?): Boolean {
        return if (value.equals(Constant.CHAR_Y) || value.equals(Constant.CHAR_N)) {
            false
        } else {
            isWrongMessage()
        }
    }

    fun isWrongMenuNumber(value: String): Boolean {
        return when (value) {
            Constant.MENU_ONE -> false
            Constant.MENU_TWO -> false
            else -> isWrongMessage()
        }
    }

    fun messageResult(value: String) {
        return println(Constant.MSG_RESULT + value)
    }

    private fun isWrongMessage(): Boolean {
        println(Constant.MSG_WRONG_INPUT)
        return true
    }
}