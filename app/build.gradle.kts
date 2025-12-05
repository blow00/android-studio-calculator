plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    // 这里我们删除了报错的 testOptions 配置
    // 将它们全部移动到了文件最底部的 tasks.withType<Test> 中
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.test:runner:1.5.0")   // ← 降级
    androidTestImplementation("androidx.test:rules:1.5.0")    // ← 降级
}

// ========================================================
// 终极配置：所有测试相关的设置都放在这里
// ========================================================
tasks.withType<Test> {
    // 1. 基础配置
    useJUnit()

    // 2. 解决 "管道关闭" 和 "ClassNotFound" 的核心参数
    // 强制每次测试完一个类就重启 JVM，避免内存泄漏或环境污染
    forkEvery = 1
    // 禁止并行运行，防止 Windows 进程锁死
    maxParallelForks = 1
    // 给测试进程分配足够的内存
    jvmArgs = listOf("-Xmx512m", "-XX:MaxMetaspaceSize=256m")

    // 3. 日志打印配置 (之前报错的代码移到这里就好了)
    testLogging {
        // 打印标准输出，这样你可以看到测试过程中的 System.out.println
        events("passed", "skipped", "failed", "standardOut", "standardError")
        showStandardStreams = true
    }

    // 4. 错误处理
    failFast = false
}