
## Cabify Mobile Challenge by Iosu Lizarraga Madinabeitia

## Summary

Cabify Mobile Challenge is an app that a user can pick products from a list and checkout them to get the resulting price.

## App Flow

![App Flow](art/Flow.svg)

## App structure description

The app was made using Clean Architecture with MVVM pattern and reactive components. The app modularization is done thinking on improve the app time compilation, avoiding the possible circular dependencies. The modules are splited in features and in CA layers as it can see in the following scheme:

## Modularization structure

![Clean Architecture](art/Modularization.png)

The responsibility to know the other layers, are in the -imp modules; the abstractions must not in any case be aware of other modules.

## Modules

#### Data module
Provide, send or keep the data info that the app needs to work.

#### Domain module
The business logic.

#### Presentation module
The viewmodels.

#### View module
The views and the definitions of router.

#### Flow module
The responsible to allow navigation between features.

## Packaging
The packaging structure is based in four parts: app package path definition + feature + layer + component. For example:
com.ilizma.cabify.checkout.presentation.viewmodel.

## Naming
The class naming is based in the feature division, the abstracted classes are called X.kt and the implementation classes are called XImp.kt.

### Important used libraries
- DaggerHilt: To do the dependency injection.
- RxKotlin3: To get/send data asynchronously.
- FragmentScenario: To do the instrumentation tests.
- Mockk: A Kotlin library to mock the objects on Tests.
- JUnit5: To do unit the tests.
- Navigation-component: To navigate between views.

### Annotation
This project contains Unit Test for almost all classes, and some instrumentation tests.

