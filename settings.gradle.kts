include(
    // region View
    ":view-base",
    // endregion

    // region Presentation
    ":presentation-base",
    // endregion

    // region Test
    ":test-base",
    // endregion

    // region Resources
    ":resources",
    // endregion

    // region Net
    ":net-di",
    ":net",
    // endregion

    // region Api
    ":api-di",
    ":api",
    // endregion

    // region App
    ":app",
    ":app-flow",
    ":app-view",
    // endregion

    // region Error Management
    ":error-management-di",
    ":error-management-view",
    ":error-management-view-imp",
    // endregion

)

// region Net
project(":net-di").projectDir = File("net-feature/net-di")
project(":net").projectDir = File("net-feature/net")
// endregion

// region Api
project(":api-di").projectDir = File("api-feature/api-di")
project(":api").projectDir = File("api-feature/api")
// endregion

// region App
//project(":app").projectDir = File("/app-feature/app")
project(":app-flow").projectDir = File("app-feature/app-flow")
project(":app-view").projectDir = File("app-feature/app-view")
// endregion

// region Error Management
project(":error-management-di").projectDir = File("error-management-feature/error-management-di")
project(":error-management-view").projectDir = File("error-management-feature/error-management-view")
project(":error-management-view-imp").projectDir = File("error-management-feature/error-management-view-imp")
// endregion
