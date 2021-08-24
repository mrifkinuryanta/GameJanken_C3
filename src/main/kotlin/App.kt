import game.BaseGameJanken

class App {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            BaseGameJanken().startGame()
        }
    }
}