# react-native-file-share-for-android

## Getting started

`$ npm install react-native-file-share-for-android --save`

### Mostly automatic installation

`$ react-native link react-native-file-share-for-android`

### Manual installation

#### iOS

Package not supported in IOS

#### Android

clone this example folder https://github.com/BalaRajendran/React-native-file-share-for-android and run in your local system

1. Open up `android/app/src/main/java/[...]/MainActivity.java`

- Add `import com.ReactNativeFileShareForAndroid.ReactNativeFileShareForAndroidPackage;` to the imports at the top of the file
- Add `new ReactNativeFileShareForAndroidPackage()` to the list returned by the `getPackages()` method

2. Append the following lines to `android/settings.gradle`:
   ```
   include ':react-native-file-share-for-android'
   project(':react-native-file-share-for-android').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-file-share-for-android/android')
   ```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
   ```
     compile project(':react-native-file-share-for-android')
   ```

## Issues

If you are facing any issues, create Issues in Repository

## preview

click to play preview

[![Watch the video](public/preview.jpeg)](https://youtu.be/fjPl_MtaaYo)

## Usage

```javascript
import React, { Component } from "react";
import { View, Text } from "react-native";
import ReactNativeFileShareForAndroid from "react-native-file-share-for-android";

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      url: ""
    };
  }

  componentDidMount() {
    if (ReactNativeFileShareForAndroid) {
      ReactNativeFileShareForAndroid.getFilepath(url => {
        this.setState({ url });
      });
    }
  }

  render() {
    return (
      <View>
        <Text>File Url : </Text>
        <Text>{this.state.url}</Text>
      </View>
    );
  }
}

RNReactNativeFileShareForAndroid;
```
