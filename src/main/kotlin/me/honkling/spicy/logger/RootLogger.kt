package me.honkling.spicy.logger

class RootLogger : Logger() {
    private val children = mutableListOf<Logger>()

    fun log(): Boolean {
        var didLog = false

        for (logger in listOf(*children.toTypedArray(), this)) {
            val logs = listOf(
                *logger.errors.toTypedArray(),
                *logger.warnings.toTypedArray()
            )

            for (log in logs) {
                printLog(log)

                if (log.type == LogType.ERROR)
                    didLog = true
            }
        }

        return didLog
    }

    private fun printLog(log: Log) {
        val (type, message, location) = log
        println("${type.code}${type.name.lowercase()}: $message (${location.file}:${location.index})")
    }

    fun createLogger(): Logger {
        val logger = Logger()
        children += logger
        return logger
    }
}