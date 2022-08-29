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

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
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
    implementation(AndroidUI.constraintLayout)
    implementation(AndroidUI.material)
    implementation(AndroidKtx.fragment)
    // endregion

    // region Architecture
    implementation(Architecture.navigationFragment)
    implementation(Architecture.navigationUi)
    // endregion

    // region Base
    implementation(project(":view-base"))
    implementation(project(":presentation-base"))
    // endregion

    // region Api
    implementation(project(":api"))
    // endregion

    // region Resources
    implementation(project(":resources"))
    // endregion

    // region App
    implementation(project(":app-flow"))
    // endregion

    // region Marketplace
    api(project(":marketplace-flow"))
    api(project(":marketplace-flow-imp"))
    api(project(":marketplace-view"))
    api(project(":marketplace-view-imp"))
    api(project(":marketplace-presentation"))
    api(project(":marketplace-presentation-imp"))
    api(project(":marketplace-domain"))
    api(project(":marketplace-domain-imp"))
    api(project(":marketplace-data"))
    api(project(":marketplace-data-imp"))
    // endregion

    // region Checkout
    implementation(project(":checkout-flow"))
    // endregion

}
