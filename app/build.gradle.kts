plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.ilizma.cabify"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
        testInstrumentationRunner = ConfigData.testInstrumentationRunner
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        getByName("debug")
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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
    implementation(Android.v4)
    // endregion

    // region Error
    implementation(CustomActivityOnCrash.customactivityoncrash)
    // endregion

    // region Base
    implementation(project(":view-base"))
    implementation(project(":presentation-base"))
    // endregion

    // regionResources
    implementation(project(":resources"))
    // endregion

    // region api
    implementation(project(":api-di"))
    // endregion

    // region net
    implementation(project(":net-di"))
    // endregion

    // region App
    implementation(project(":app-flow"))
    implementation(project(":app-view"))
    // endregion

    // region Error Management
    implementation(project(":error-management-di"))
    // endregion

    // region Marketplace
    implementation(project(":marketplace-di"))
    // endregion

    // region Checkout
    implementation(project(":checkout-di"))
    // endregion

}
