package me.honkling.spicy.lexer

data class Token(
    val type: TokenType,
    val raw: String,
    val start: Int
)
