#  Modularization example project

Featuring module exclusion to achieve O(1) build time

![background](./.github/background.jpg)

### Install

- Install debug apk including all feature:  
`./gradlew :app:installDebug` 

- Install debug apk with only `:home` module:  
`./gradlew :app:installDebug -Ponly="home"`

- Install debug apk with only `:home` module and `:detail` module:  
`./gradlew :app:installDebug -Ponly="home,detail"`

### Navigation
Use deep link via adb command:  
`adb shell am start -a android.intent.action.VIEW -d {deep link}`  
Ex: `adb shell am start -a android.intent.action.VIEW -d module://home`


- Home screen: `module://home`

- Detail screen: `module://detail/{productId}`  
Ex: `module://detail/abc`

- Search screen: `module://search/{keyword}`  
Ex: `module://search/android`


