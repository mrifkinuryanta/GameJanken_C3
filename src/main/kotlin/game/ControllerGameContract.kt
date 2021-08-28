package game

interface ControllerGameContract {
    fun inputUsername(): List<String>
    fun resultGame(input1: String, input2: String, listUsername: List<String>)
}