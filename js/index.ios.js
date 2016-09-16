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


var {height, width} = Dimensions.get('window');
class pilipili extends Component {
  constructor() {
    super();
  }

  render() {
    return <View style={styles.container}>
      <Text>Browser</Text>
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

AppRegistry.registerComponent('AirApps', () => pilipili);
