package me.honkling.spicy.lexer

enum class TokenType(regex: String, val shouldIgnore: Boolean = false) {
    COMMENT("(\\/\\/.*|/\\*.*\\*/)", true),
    WHITESPACE("\\s+", true),

    KEYWORD_FUNCTION("func"),

    SYMBOL_OPEN_PAREN("\\("),
    SYMBOL_CLOSE_PAREN("\\)"),
    SYMBOL_OPEN_BRACE("\\{"),
    SYMBOL_CLOSE_BRACE("\\}"),

    LITERAL_STRING("\"(\\\\\"|[^\"])*\""),

    IDENTIFIER("\\w+"),
    EOF("$");

    val regex = Regex("^$regex")
}