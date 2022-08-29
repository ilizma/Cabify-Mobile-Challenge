plugins {
    id("java-library")
    id("kotlin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.test {
    useJUnitPlatform()
}

dependencies {

    // region Rx
    implementation(Rx.java)
    // endregion

    // region Network
    implementation(Network.retrofitAdapter)
    // endregion

    // region Test
    testImplementation(Test.mockk)
    testImplementation(Test.junitApi)
    testRuntimeOnly(Test.junitEngine)
    // endregion

    // region Api
    implementation(project(":api"))
    // endregion

    // region Marketplace
    implementation(project(":marketplace-domain"))
    implementation(project(":marketplace-data"))
    // endregion

}