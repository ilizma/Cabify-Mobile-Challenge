object Project {
    val buildGradle by lazy { "com.android.tools.build:gradle:${Versions.buildGradleVersion}" }
    val kotlinGradle by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}" }
    val navigation by lazy { "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}" }
    val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}" }
    val junit by lazy { "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junitVersion}" }
}

object Rx {
    val kotlin by lazy { "io.reactivex.rxjava3:rxkotlin:${Versions.rxKotlinVersion}" }
    val java by lazy { "io.reactivex.rxjava3:rxjava:${Versions.rxJavaVersion}" }
    val binding by lazy { "com.jakewharton.rxbinding4:rxbinding:${Versions.rxBindingVersion}" }
}

object Android {
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.supportVersion}" }
    val v4 by lazy { "androidx.legacy:legacy-support-v4:${Versions.legacyVersion}" }
}

object AndroidKtx {
    val core by lazy { "androidx.core:core-ktx:${Versions.coreKtxVersion}" }
    val fragment by lazy { "androidx.fragment:fragment-ktx:${Versions.fragmentKtxVersion}" }
}

object AndroidUI {
    val constraintLayout by lazy { "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}" }
    val material by lazy { "com.google.android.material:material:${Versions.materialVersion}" }
}

object UI {
    val lottie by lazy { "com.airbnb.android:lottie:${Versions.lottieVersion}" }
    val shimmer by lazy { "com.facebook.shimmer:shimmer:${Versions.shimmerVersion}" }
}

object Architecture {
    val navigationFragment by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}" }
    val navigationUi by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}" }
    val lifecycleRuntime by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleVersion}" }
    val lifecycleCommon by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}" }
    val lifecycleViewModel by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}" }
    val lifecycleLivedata by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}" }
}

object CustomActivityOnCrash {
    val customactivityoncrash by lazy { "cat.ereza:customactivityoncrash:${Versions.customactivityoncrashVersion}" }
}

object Network {
    val moshi by lazy { "com.squareup.moshi:moshi:${Versions.moshiVersion}" }
    val moshiKotlin by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}" }
    val moshiAdapters by lazy { "com.squareup.moshi:moshi-adapters:${Versions.moshiVersion}" }
    val moshiConverter by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverterVersion}" }
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}" }
    val retrofitAdapter by lazy { "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofitVersion}" }
    val okhttpLogging by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingVersion}" }
    val chucker by lazy { "com.github.chuckerteam.chucker:library:${Versions.chuckerVersion}" }
    val chuckerNoOp by lazy { "com.github.chuckerteam.chucker:library-no-op:${Versions.chuckerVersion}" }
}

object Di {
    val hilt by lazy { "com.google.dagger:hilt-android:${Versions.hiltVersion}" }
    val compiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}" }
    val testing by lazy { "com.google.dagger:hilt-android-testing:${Versions.hiltVersion}" }
}

object Annotation {
    val annotation by lazy { "androidx.annotation:annotation:${Versions.annotationVersion}" }
}

object Test {
    val mockk by lazy { "io.mockk:mockk:${Versions.mockkVersion}" }
    val junitApi by lazy { "org.junit.jupiter:junit-jupiter-api:${Versions.junitJupiterVersion}" }
    val junitEngine by lazy { "org.junit.jupiter:junit-jupiter-engine:${Versions.junitJupiterVersion}" }
}

object AndroidTest {
    val mockk by lazy { "io.mockk:mockk-android:${Versions.mockkVersion}" }
    val runner by lazy { "androidx.test:runner:${Versions.runnerVersion}" }
    val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoVersion}" }
    val fragmentScenario by lazy { "androidx.fragment:fragment-testing:${Versions.fragmentKtxVersion}" }
}
