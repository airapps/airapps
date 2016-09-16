'use strict';
import React, {
    Component,
} from 'react';
import {
    StyleSheet,
    Text,
    View,
    AppRegistry,
    Dimensions
} from 'react-native';

import Pili, {
    Streaming,
    Player,
    StreamingConst
} from 'react-native-pili';

var {height, width} = Dimensions.get('window');
import Umeng from 'air-umeng';
class pilipili extends Component {
  constructor() {
    super();
    Umeng.startWithAppkey('55894b6d67e58e66c5000d6d');
  }

  render() {
    return <View style={styles.container}>
      <Player
          source={{
                uri:"rtmp://live.hkstv.hk.lxdns.com/live/hks",
                //uri:"rtmp://pili-live-rtmp.pilitest.qiniucdn.com/pilitest/buhe",
                //controller: true,
                timeout: 10 * 1000,
                live:true,
                hardCodec:false,
              }}
          started={true}
          style={{
                height:height,
                width:width,
                flex:1
              }}
          aspectRatio={2}
          />
      <View style={{position:'absolute',left:50,top:50,width:200,height:200}}>

      </View>
    </View>
  }
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
});

AppRegistry.registerComponent('Example', () => pilipili);
