Here is a ready-to-paste `README.md` (Markdown) in **English** for your GitHub repo.  
Copy it to the root of your project and commit—GitHub will render a beautiful landing page instantly.

---

```markdown
# Android Minimal Calculator (7-Function Edition)

[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://www.android.com/)
[![Language](https://img.shields.io/badge/Language-Kotlin-blue.svg)](https://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/Gradle-8.10.2-blue)](https://gradle.org/)
[![API](https://img.shields.io/badge/API-26%2B-brightgreen.svg)](https://developer.android.com/distribute/best-practices/develop/target-sdk)

> 3-button-per-row iPhone style, **7 basic operations only**: add, subtract, multiply, divide, clear, equals, decimal.  
> Full unit & Espresso tests, **all green ✔**

---

## 📱 Features
| Operation | Demo |
|-----------|------|
| Add       | 3 + 4 = 7 |
| Subtract  | 9 − 4 = 5 |
| Multiply  | 6 × 7 = 42 |
| Divide    | 8 ÷ 2 = 4 |
| Clear     | C → 0 |
| Decimal   | 1 . 5 → 1.5 |
| Equals    | 2 + 3 = 5 |

---

## 🎯 Environment
- **Min SDK**: 26 (Android 8.0)
- **Target SDK**: 34 (Android 14)
- **Gradle**: 8.10.2
- **JDK**: 17
- **Kotlin**: 1.9.0

---

## 🚀 Quick Start

### 1. Clone
```bash
git clone https://github.com/YOUR_USER/MyApplication.git
cd MyApplication
```

### 2. Run Locally
- Open **Android Studio Arctic Fox** or newer
- **File → Open** project root
- Connect **emulator** or device → click **Run ▶**

### 3. Run Tests
```bash
# Unit tests (local JVM)
.\gradlew testDebugUnitTest

# Instrumented tests (emulator)
.\gradlew connectedDebugAndroidTest
```

---

## 📸 Screenshots
| Main Screen | Tests Passed |
|-------------|--------------|
| ![Main](docs/main.png) | ![Test](docs/test.png) |
<img width="865" height="460" alt="image" src="https://github.com/user-attachments/assets/b6344791-29a5-45fc-9b9a-2a33b45bdf19" />
<img width="785" height="417" alt="image" src="https://github.com/user-attachments/assets/b05ca0ba-8d1e-476f-89d4-fb7b3b39f4d7" />



> Put images in `docs/` folder, GitHub will display them.

---

## 📂 Project Tree
```
app/
├── src/
│   ├── main/                 # Main source
│   ├── test/                 # JVM unit tests
│   └── androidTest/          # Espresso instrumented tests
├── build.gradle.kts          # Module build script
└── proguard-rules.pro        # ProGuard rules
docs/                         # Screenshots for README
README.md                     # This file
```

---

## 🔧 Key Files
- **UI**: `res/layout/activity_main.xml`
- **Logic**: `MainActivity.kt`
- **Unit Tests**: `ExampleUnitTest.kt`
- **Instrumented Tests**: `ExampleInstrumentedTest.kt`

---

## 📜 License
 BSU © 2025 LI Bao

---

## 🤝 Contributing
Issues and Pull Requests are welcome!

---

**Copy → Save as `README.md` → Commit to root → GitHub renders instantly!**
