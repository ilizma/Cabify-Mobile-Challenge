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

    // region AndroidTest
    ":android-test-base",
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

    // region Marketplace
    ":marketplace-di",
    ":marketplace-flow-imp",
    ":marketplace-view",
    ":marketplace-view-imp",
    ":marketplace-presentation",
    ":marketplace-presentation-imp",
    ":marketplace-domain",
    ":marketplace-domain-imp",
    ":marketplace-data",
    ":marketplace-data-imp",
    // endregion

    // region Checkout
    ":checkout-di",
    ":checkout-flow",
    ":checkout-flow-imp",
    /*":checkout-view",
    ":checkout-view-imp",
    ":checkout-presentation",
    ":checkout-presentation-imp",
    ":checkout-domain",
    ":checkout-domain-imp",
    ":checkout-data",
    ":checkout-data-imp",*/
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
project(":app-flow").projectDir = File("app-feature/app-flow")
project(":app-view").projectDir = File("app-feature/app-view")
// endregion

// region Error Management
project(":error-management-di").projectDir = File("error-management-feature/error-management-di")
project(":error-management-view").projectDir = File("error-management-feature/error-management-view")
project(":error-management-view-imp").projectDir = File("error-management-feature/error-management-view-imp")
// endregion

// region Marketplace
project(":marketplace-di").projectDir = File("marketplace-feature/marketplace-di")
project(":marketplace-flow-imp").projectDir = File("marketplace-feature/marketplace-flow-imp")
project(":marketplace-view").projectDir = File("marketplace-feature/marketplace-view")
project(":marketplace-view-imp").projectDir = File("marketplace-feature/marketplace-view-imp")
project(":marketplace-presentation").projectDir = File("marketplace-feature/marketplace-presentation")
project(":marketplace-presentation-imp").projectDir = File("marketplace-feature/marketplace-presentation-imp")
project(":marketplace-domain").projectDir = File("marketplace-feature/marketplace-domain")
project(":marketplace-domain-imp").projectDir = File("marketplace-feature/marketplace-domain-imp")
project(":marketplace-data").projectDir = File("marketplace-feature/marketplace-data")
project(":marketplace-data-imp").projectDir = File("marketplace-feature/marketplace-data-imp")
// endregion

// region Checkout
project(":checkout-di").projectDir = File("checkout-feature/checkout-di")
project(":checkout-flow").projectDir = File("checkout-feature/checkout-flow")
project(":checkout-flow-imp").projectDir = File("checkout-feature/checkout-flow-imp")
/*project(":checkout-view").projectDir = File("checkout-feature/checkout-view")
project(":checkout-view-imp").projectDir = File("checkout-feature/checkout-view-imp")
project(":checkout-presentation").projectDir = File("checkout-feature/checkout-presentation")
project(":checkout-presentation-imp").projectDir = File("checkout-feature/checkout-presentation-imp")
project(":checkout-domain").projectDir = File("checkout-feature/checkout-domain")
project(":checkout-domain-imp").projectDir = File("checkout-feature/checkout-domain-imp")
project(":checkout-data").projectDir = File("checkout-feature/checkout-data")
project(":checkout-data-imp").projectDir = File("checkout-feature/checkout-data-imp")*/
// endregion