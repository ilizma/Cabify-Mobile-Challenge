plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        getByName("debug")
        getByName("release")
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
        getByName("test").java.srcDirs("src/test/kotlin")
    }

    testOptions {
        unitTests.isReturnDefaultValues = true

        unitTests.all {
            it.useJUnitPlatform()
        }
    }

}

dependencies {
    // region Di
    implementation(Di.hilt)
    kapt(Di.compiler)
    // endregion

    // region Rx
    implementation(Rx.java)
    // endregion

    // region Android
    implementation(Android.appcompat)
    implementation(AndroidUI.material)
    implementation(AndroidKtx.core)
    // endregion

    // region CAOC
    implementation(CustomActivityOnCrash.customactivityoncrash)
    // endregion

    // region Base
    implementation(project(":view-base"))
    // endregion

    // region Error Management
    implementation(project(":error-management-view"))
    // endregion

    // region Resources
    implementation(project(":resources"))
    // endregion
}
