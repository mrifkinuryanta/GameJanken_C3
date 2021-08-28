package utils

object GameUtils {
    fun isYesOrNo(value: String): Boolean {
        return value == Constant.CHAR_Y
    }

    fun isEmptyValue(value: String): Boolean {
        return if (value.isNotEmpty()) {
            false
        } else {
            println(Constant.MSG_EMPTY_VALUE)
            true
        }
    }

    fun isWrongInput(value: String?): Boolean {
        return if (value.equals(StatusJanken.ROCK.value) || value.equals(StatusJanken.PAPER.value) || value.equals(
                StatusJanken.SCISSORS.value
            )
        ) {
            false
        } else {
            isWrongMessage()
        }
    }

    fun isYesOrNoInput(value: String?): Boolean {
        return if (value.equals(Constant.CHAR_Y) || value.equals(Constant.CHAR_N)) {
            false
        } else {
            isWrongMessage()
        }
    }

    fun isWrongMenuNumber(value: String): Boolean {
        return when (value) {
            Constant.NUMBER_ONE -> false
            Constant.NUMBER_TWO -> false
            else -> isWrongMessage()
        }
    }

    private fun isWrongMessage(): Boolean {
        println(Constant.MSG_WRONG_INPUT)
        return true
    }
}