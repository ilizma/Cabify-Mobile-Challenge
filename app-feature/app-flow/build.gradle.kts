plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    viewBinding {
        isEnabled = true
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

dependencies {

    // region Di
    implementation(Di.hilt)
    kapt(Di.compiler)
    // endregion

    // region Android
    implementation(Android.appcompat)
    implementation(AndroidUI.material)
    // endregion

    // region Architecture
    implementation(Architecture.navigationFragment)
    implementation(Architecture.navigationUi)
    // endregion

    // region Base
    implementation(project(":view-base"))
    // endregion

    // region Marketplace
    implementation(project(":marketplace-view"))
    // endregion

}
