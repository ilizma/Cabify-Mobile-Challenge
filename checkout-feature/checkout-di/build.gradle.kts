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
    implementation(project(":presentation-base"))
    // endregion

    // region Resources
    implementation(project(":resources"))
    // endregion

    //region App
    implementation(project(":app-flow"))
    // endregion

    // region Checkout
    api(project(":checkout-flow"))
    api(project(":checkout-flow-imp"))
    /*api(project(":checkout-view"))
    api(project(":checkout-view-imp"))
    api(project(":checkout-presentation"))
    api(project(":checkout-presentation-imp"))
    api(project(":checkout-domain"))
    api(project(":checkout-domain-imp"))
    api(project(":checkout-data"))
    api(project(":checkout-data-imp"))*/
    // endregion

}
