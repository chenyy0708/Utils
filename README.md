# Utils

[![](https://jitpack.io/v/chenyy0708/CyyUtils.svg)](https://jitpack.io/#chenyy0708/CyyUtils)
收集一些常用的工具类，方便快速开发

## 引入项目

 ```
    allprojects {
        repositories {
            jcenter()
            maven { url 'https://jitpack.io' }
        }
    }
```
```implementation 'com.github.chenyy0708:Utils:1.0.1'```

## APIs

* ### APP通用 -> [AppUtils.java][AppUtils .java] 
```
getString                      : 判断 Activity 是否存在
getVersionCode                 : 获取当前本地apk的版本Code
getVersionName                 : 获取当前本地apk的版本号
```

* ### 涟漪动画 -> [CircularAnim.java][CircularAnim.java]

