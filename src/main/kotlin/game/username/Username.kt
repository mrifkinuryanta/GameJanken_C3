package game.username

abstract class Username {

    fun printUsername() {
        println("""
                Okay, you just entered your username
                The first player named ${inputUsername()[0]} and second player named ${inputUsername()[1]}
                """.trimIndent()
        )
    }

    abstract fun inputUsername(): List<String>
}