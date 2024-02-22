package me.honkling.spicy.lexer

import me.honkling.spicy.logger.Logger
import java.io.File
import java.util.Optional

class Lexer(private val file: File, private val logger: Logger) {
    private val input = file.readText()
    private var index = 0

    fun lex(): List<Token> {
        val tokens = mutableListOf<Token>()

        while (index <= input.length) {
            val nextToken = getNextToken()

            if (nextToken.isEmpty) {
                logger.error("Unexpected token.", file, index)
                break
            }

            val token = nextToken.get()
            index += token.raw.length
            tokens += token

            if (token.type == TokenType.EOF)
                break
        }

        return tokens
    }

    private fun getNextToken(): Optional<Token> {
        val remaining = input.substring(index)

        for (type in TokenType.entries)
            if (type.regex.containsMatchIn(remaining)) {
                val match = type.regex.matchAt(remaining, 0) ?: continue
                return Optional.of(Token(type, match.value, index))
            }

        return Optional.empty()
    }
}