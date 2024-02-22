package me.honkling.spicy

import me.honkling.spicy.lexer.Lexer
import me.honkling.spicy.logger.RootLogger
import java.io.File

fun main() {
    val file = File("/media/rosalyn/DATA/IDEAProjects/Spicy/test.spicy")
    val logger = RootLogger()

    val lexer = Lexer(file, logger.createLogger())
    val tokens = lexer.lex().filter { !it.type.shouldIgnore }

    if (logger.log())
        return

    println(tokens)
}