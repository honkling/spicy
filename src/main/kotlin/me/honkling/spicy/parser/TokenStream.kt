package me.honkling.spicy.parser

import me.honkling.spicy.lexer.Token

class TokenStream(private val tokens: List<Token>) {
    private var index = 0

    fun peek(): Token {
        return tokens[index]
    }

    fun consume(): Token {
        val token = tokens[index]
        index++
        return token
    }

    fun isEnd(): Boolean {
        return index >= tokens.size
    }
}