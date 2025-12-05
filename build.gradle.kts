plugins {
    // 这里的版本改成 8.5.0，它可以完美运行在 Gradle 8.7 上
    id("com.android.application") version "8.5.0" apply false
    id("com.android.library") version "8.5.0" apply false

    // Kotlin 版本通常不需要动，但如果报错，可以尝试降级到 1.9.24
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
}