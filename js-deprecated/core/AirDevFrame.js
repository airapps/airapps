/**
 * Created by buhe on 16/9/16.
 *
 */
import React, {
    Component,
    PropTypes
} from 'react';
import {
    requireNativeComponent,
    View,
} from 'react-native';

export default class AirDevFrame extends Component {

  constructor(props, context) {
    super(props, context);
  }

  render() {
    const nativeProps = Object.assign({}, this.props);

    return (
          <DevFrame
              {...nativeProps}
              />
    )
  }

}

AirDevFrame.propTypes = {
  devURL: PropTypes.string,
  ...View.propTypes
}

const DevFrame = requireNativeComponent('DevFrame', AirDevFrame);