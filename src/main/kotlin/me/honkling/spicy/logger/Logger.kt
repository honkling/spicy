package me.honkling.spicy.logger

import java.io.File

open class Logger {
    val errors = mutableListOf<Log>()
    val warnings = mutableListOf<Log>()

    fun error(message: String, file: File, index: Int) {
        errors += createLog(LogType.ERROR, message, file, index)
    }

    fun warning(message: String, file: File, index: Int) {
        warnings += createLog(LogType.ERROR, message, file, index)
    }

    private fun createLog(type: LogType, message: String, file: File, index: Int): Log {
        return Log(type, message, Location(file, index))
    }
}