/**
 * Created by buhe on 16/9/18.
 */

import React, {
    Component,
} from 'react';

import {
    View
} from 'react-native';

import { createStore, applyMiddleware, combineReducers, compose } from 'redux';
import { Provider, connect } from 'react-redux';
import thunk from 'redux-thunk';
import createLogger from 'redux-logger';
import { Scene, Router } from 'react-native-router-flux'

import reducers from './reducers';

const logger = createLogger();

const middleware = [thunk, logger];
const store = compose(
    applyMiddleware(...middleware)
)(createStore)(reducers);

const RouterWithRedux = connect()(Router);


import {
    NavigationBar,
    Title
} from '@shoutem/ui';

import Browser from './components/browser'
import Frame from './components/frame'

class App extends Component {
  render () {
    return (
        <Provider store={store}>
          <RouterWithRedux>
            <Scene key="root" navBar={()=>{return  <NavigationBar centerComponent={<Title>AirApps</Title>}/>}}>
              <Scene key="browser" component={Browser} initial/>
              <Scene key="devFrame" component={Frame} hideNavBar />
            </Scene>
          </RouterWithRedux>
        </Provider>
    );
  }
}

export default App;
