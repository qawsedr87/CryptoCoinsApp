# Crypto Coins App
This repository is built to showcase the implementation of the cryptocurrency information using Kotlin Android and various modern technologies such as Kotlin Coroutines, Hilt Dagger, Jetpack Compose, MVVM pattern, and more.

- The app uses the [Coin Paprika API](https://coinpaprika.com/) to fetch cryptocurrency data without token and display it in a clean and organized manner.

- With [Coroutine Lifecycle Scopes](https://developer.android.com/topic/libraries/architecture/coroutines), the app can manage the lifecycle of coroutines and
ensure they are properly cancelled when the associated UI component is destroyed. This helps prevent memory leaks and other issues that can occur when coroutines are not properly managed.

- The app uses [Hilt Dagger](https://developer.android.com/training/dependency-injection/hilt-android) for dependency injection, which simplifies the setup and provides better maintainability.

- The [Jetpack Compose UI toolkit](https://developer.android.com/jetpack/compose) is used to build the UI, and the `Coil` Compose library is used for image loading.

- The implementation of the `MVVM`(Model-View-ViewModel or ViewModel pattern) pattern separates the UI-related data (i.e. Activities and Fragments) from the UI logic. The 
[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel?gclid=Cj0KCQiA7qP9BRCLARIsABDaZzhDtIsNoyAcuVYiA3F3smhaKd4THplNIp1nDr-KGB_XWkzZxiIvrVAaAjYKEALw_wcB&gclsrc=aw.ds) allows for better testing and a more maintainable codebase.


## Installation
You can clone the project with IntelliJ IDEA 2022.3+ or download the [v1.0.0 apk](https://github.com/qawsedr87/CryptoCoinsApp/releases/tag/1.0.0) directly from release. 

```shell
git clone git@github.com:qawsedr87/CryptoCoinsApp.git
cd CryptoCoinsApp

idea . 
```

## Environments 

- IntelliJ IDEA 2022.3+
- Device Emulator Pixel 5 API 30 
- Android 13 SDK 
- Kotlin 1.8.20
- Coin Paprika API:

  - Get coins: https://api.coinpaprika.com/v1/coins
  - Get a coin by id route: https://api.coinpaprika.com/v1/coins
  - Search coins by name: https://api.coinpaprika.com/v1/search/?q=btc&c=currencies&limit=250


## View 
![CryptoCoinsApp.gif](./crypto_coins_app_demo.gif)

## Reference 
Credit goes to the tutorial on [@PhilippLackner YouTube Channel](https://www.youtube.com/@PhilippLackner) by learning a Clean Architecture MVVM pattern in Kotlin 

- Difference Between tutorial and mine
  - Android 13 (API level 33)
  - features
    - adding cryptocurrency logos to the coin detail page
    - implementing an "Item Empty" section to display when there is no team member data available
    - [WIP] designing the search area to develop coin naming search
