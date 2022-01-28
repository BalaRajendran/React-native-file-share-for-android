import React, {Component} from 'react';
import {Tooltip, Text} from 'react-native-elements';
import ReactNativeFileShareForAndroid from 'react-native-file-share-for-android';
import {Header, ThemeProvider, SocialIcon} from 'react-native-elements';
import {View, Linking} from 'react-native';

export default class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      url: '',
    };
  }

  componentDidMount() {
    console.log('Hello Iinsdie App', ReactNativeFileShareForAndroid);
    if (ReactNativeFileShareForAndroid) {
      console.log('Isnide if');
      ReactNativeFileShareForAndroid.getFilepath(url => {
        console.log('Isnide if if', url);
        this.setState({url});
      });
    } else {
      console.log('Else ReactNativeFileShareForAndroid');
    }
  }

  callMedia = url => {
    Linking.openURL(url).catch(err => console.error("Couldn't load page", err));
  };

  render() {
    return (
      <ThemeProvider>
        <Header
          centerComponent={{text: 'File Share Indent', style: {color: '#fff'}}}
        />
        <View
          style={{
            flex: 1,
            justifyContent: 'center',
            alignItems: 'center',
          }}>
          <Text>File Url : </Text>
          <Tooltip popover={<Text>File Url with File Extension</Text>}>
            <Text>{this.state.url}</Text>
          </Tooltip>
        </View>
        <View
          style={{
            alignItems: 'center',
            flexDirection: 'row',
            justifyContent: 'center',
          }}>
          <SocialIcon
            type="github"
            onPress={this.callMedia.bind(
              this,
              'https://github.com/BalaRajendran',
            )}
          />
          <SocialIcon
            type="linkedin"
            onPress={this.callMedia.bind(
              this,
              'https://www.linkedin.com/in/balaji-rajendran-a6ab6513a/',
            )}
          />
          <SocialIcon
            type="weibo"
            onPress={this.callMedia.bind(
              this,
              'https://balajirajendran.herokuapp.com/',
            )}
          />
        </View>
      </ThemeProvider>
    );
  }
}
