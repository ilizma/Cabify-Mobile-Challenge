plugins {
    id("com.android.library")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
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

    // region Architecture
    implementation(Architecture.lifecycleLivedata)
    implementation(Architecture.navigationFragment)
    // endregion

    // region Test
    testImplementation(Test.mockk)
    testImplementation(Test.junitApi)
    testRuntimeOnly(Test.junitEngine)
    testImplementation(project(":test-base"))
    // endregion

    // region App
    implementation(project(":app-flow"))
    // endregion

    // region Checkout
    implementation(project(":checkout-flow"))
    implementation(project(":checkout-view"))
    implementation(project(":checkout-presentation"))
    implementation(project(":checkout-data"))
    // endregion

}
