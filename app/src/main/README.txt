
技术选型
1.butterknife 专注于Android系统的View注入框架，能够简化代码
  配置步骤
  Step1: preferences->Plugins->搜索Android ButterKnife Zelezny  点击安装   重启AS生效
  Step2: Project gradle
         "dependencies { classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8' }"
  Step3: Module gradle
         apply plugin: 'android-apt'
         dependencies {
                        compile 'com.jakewharton:butterknife:8.2.1'
                        apt 'com.jakewharton:butterknife-compiler:8.2.1'}

 2.base-adapter-helper 快速创建自定义Adapter,减少代码量(避免创建Adapter文件)
   使用介绍地址:http://www.lcode.org/baseadapterhelper的基本使用介绍让你摆脱狂写一堆adapter烦恼一/
   配置步骤
   Step1:Module gradle
         dependencies {
                     compile 'com.joanzapata.android:base-adapter-helper:1.1.11'}