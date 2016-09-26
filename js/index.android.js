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

import AirDevFrame from './core/AirDevFrame';
import App from './App';

class pilipili extends Component {
  constructor() {
    super();
  }

  render() {
    return (
        <App />
    )
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
