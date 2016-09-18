'use strict';
import React, {
    Component,
} from 'react';
import {
    StyleSheet,
    AppRegistry,
    Dimensions,
    ScrollView
} from 'react-native';

import {
    Heading,
    View,
    Tile,
    Text,
    Title,
    Subtitle,
    Caption,
    Icon,
    Overlay,
    Button,
    TextInput,
    NavigationBar,
    Screen,
    ListView,
    Row,
    Divider
} from '@shoutem/ui';

import AirDevFrame from './core/AirDevFrame';

class pilipili extends Component {
  constructor() {
    super();
  }

  render() {
    return (
        <Screen>
          <AirDevFrame devURL={"http://localhost:8081"}/>
        </Screen>
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

AppRegistry.registerComponent('AirApps', () => pilipili);
