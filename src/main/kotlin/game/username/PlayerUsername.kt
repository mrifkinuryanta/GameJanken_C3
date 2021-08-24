package game.username

class PlayerUsername(private val list: List<String>) : Username() {

    override fun inputUsername(): List<String> {
        return list
    }
}