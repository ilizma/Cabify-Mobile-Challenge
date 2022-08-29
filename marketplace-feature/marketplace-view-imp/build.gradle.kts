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
        testInstrumentationRunner = "com.ilizma.androidtest.runner.CustomTestRunner"
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
        getByName("test").java.srcDirs("src/test/kotlin")
        getByName("androidTest").java.srcDirs("src/androidTest/kotlin")
    }

    testOptions {
        unitTests.isReturnDefaultValues = true

        unitTests.all {
            it.useJUnitPlatform()
        }
    }

    packagingOptions {
        resources.excludes.add("META-INF/*")
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
    implementation(AndroidUI.material)
    // endregion

    // region UI
    implementation(UI.shimmer)
    // endregion

    // region AndroidKtx
    implementation(AndroidKtx.core)
    // endregion

    // region Test
    testImplementation(Test.mockk)
    testImplementation(Test.junitApi)
    testRuntimeOnly(Test.junitEngine)
    // endregion

    // region AndroidTest
    androidTestImplementation(Di.testing)
    androidTestImplementation(AndroidTest.mockk)
    androidTestImplementation(AndroidTest.runner)
    androidTestImplementation(AndroidTest.espressoCore)
    androidTestImplementation(AndroidTest.fragmentScenario)
    kaptAndroidTest(Di.compiler)
    androidTestImplementation(project(":android-test-base"))
    androidTestImplementation(project(":marketplace-di"))
    androidTestImplementation(project(":marketplace-flow-imp"))
    androidTestImplementation(project(":checkout-di"))
    // endregion

    // region Base
    implementation(project(":view-base"))
    // endregion

    // region Resources
    implementation(project(":resources"))
    // endregion

    // region Marketplace
    implementation(project(":marketplace-view"))
    implementation(project(":marketplace-presentation"))
    implementation(project(":marketplace-presentation-imp"))
    // endregion

}
