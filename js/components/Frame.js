/**
 * Created by buhe on 16/9/18.
 */

import React, {
    Component,
    PropTypes
} from 'react';
import {
    requireNativeComponent,
    View,
    Dimensions
} from 'react-native';

import {
    Screen
} from '@shoutem/ui';
var {height, width} = Dimensions.get('window');

import { connect } from 'react-redux';
import DevFrame from '../core/AirDevFrame';

class Frame extends Component {
  render(){
    return (
        <DevFrame style={{height:height,width:width}} devURL={this.props.devURL}/>
    )
  }
}

export default connect(({routes}) => ({routes}))(Frame);
