# Utils

[![](https://jitpack.io/v/chenyy0708/CyyUtils.svg)](https://jitpack.io/#chenyy0708/Utils)
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

* ### APP通用 -> [AppUtils.java](https://github.com/chenyy0708/Utils/blob/4df16c39292c621b9ff949c96c9f9350ee0a3d8a/library/src/main/java/com/cyy/utils/AppUtils.java) 
```
getString                      : 判断 Activity 是否存在
getVersionCode                 : 获取当前本地apk的版本Code
getVersionName                 : 获取当前本地apk的版本号
```
* ### 涟漪动画 -> [CircularAnim.java](https://github.com/chenyy0708/Utils/blob/4df16c39292c621b9ff949c96c9f9350ee0a3d8a/library/src/main/java/com/cyy/utils/CircularAnim.java) 

```
show                            : 伸展并显示
hide                            : 收缩并隐藏
fullActivity                    : 涟漪动画铺满整个activity
```
* ### 集合 -> [CollectionUtils.java](https://github.com/chenyy0708/Utils/blob/4df16c39292c621b9ff949c96c9f9350ee0a3d8a/library/src/main/java/com/cyy/utils/CollectionUtils.java) 
```
isEmpty                          : 判断集合是否为null或者0个元素
```

* ### EditText -> [EditTextUtils.java](https://github.com/chenyy0708/Utils/blob/4df16c39292c621b9ff949c96c9f9350ee0a3d8a/library/src/main/java/com/cyy/utils/EditTextUtils.java) 
```
addEditTexts                          : 添加需要监听EditText，任意个
addInputLimit                         : 添加每个EditText对应的输入字符触发条件，可以为空
addOnInputListener                    : 所有EditText全部输入完成

```


* ### 正则判断 -> [FormatUtil.java](https://github.com/chenyy0708/Utils/blob/4df16c39292c621b9ff949c96c9f9350ee0a3d8a/library/src/main/java/com/cyy/utils/FormatUtil.java) 
```
isMobile                               : 判断手机格式是否正确
isEmail                                : 判断email格式是否正确
isNumeric                              : 判断是否全是数字
isIdCardNo                             : 判断身份证格式
checkNameChese                         : 检测String是否全是中文
phoneSetMiddleGone                     : 将手机号变成 151****7788 格式
phoneSetMiddleEmpty                    : 将手机号变成 151 2233 7788 格式
isIdCardNo                             : 判断身份证格式
```


* ### 键盘 -> [KeybordUtils.java](https://github.com/chenyy0708/Utils/blob/4df16c39292c621b9ff949c96c9f9350ee0a3d8a/library/src/main/java/com/cyy/utils/KeybordUtils.java) 

```
openKeybord                               : 打开软键盘
closeKeybord                              : 关闭软键盘
closeAllKeybord                           : 关闭所有View软键盘
isSoftInputShow                           : 判断当前软键盘是否打开
```

