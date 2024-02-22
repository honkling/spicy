package me.honkling.spicy.logger

data class Log(
    val type: LogType,
    val message: String,
    val location: Location)