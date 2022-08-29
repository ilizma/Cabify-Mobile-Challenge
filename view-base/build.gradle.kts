plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
    }

    viewBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

dependencies {

    // region Android
    implementation(Android.appcompat)
    implementation(AndroidUI.material)
    // endregion

    // region Rx
    implementation(Rx.java)
    implementation(Rx.binding)
    // endregion

    // region Architecture
    implementation(Architecture.lifecycleRuntime)
    implementation(Architecture.lifecycleCommon)
    // endregion

    // region Annotation
    implementation(Annotation.annotation)
    // endregion

    // region Resources
    implementation(project(":resources"))
    // endregion

}
