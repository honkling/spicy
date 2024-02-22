plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "me.honkling"
version = "0.1.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("me.honkling.spicy.MainKt")
}