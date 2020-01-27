#  Modularization example project

Featuring module exclusion to achieve O(1) build time.  
Blog post: [https://medium.com/@nlg.tuan.kiet/o-1-android-build-time-at-tiki-1a27a804bb6a](https://medium.com/@nlg.tuan.kiet/o-1-android-build-time-at-tiki-1a27a804bb6a)  


<a href="https://androidweekly.net/issues/issue-398" title="Android Weekly Issue 398">
<img alt="Badge" src="https://androidweekly.net/issues/issue-398/badge" height="20px"/>
</a>  


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

### Special thank to
[![avatar](https://avatars0.githubusercontent.com/u/13332950?s=150&v=4)](https://github.com/Khang-NT)  
[@Khang-NT](https://github.com/Khang-NT)  
Who made a clever dagger 2 binds optional setup and **fake source**
