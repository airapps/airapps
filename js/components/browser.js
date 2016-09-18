/**
 * Created by buhe on 16/9/16.
 */
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

export default class Browser extends Component{
  constructor() {
    super();
  }

  render(){
    return (
        <Screen>
          <NavigationBar
              centerComponent={<Title>AirApps</Title>}
              />
          <View style={{marginTop:70}} styleName="horizontal">
            <TextInput
                style={{flex:5}}
                placeholder={'Dev Server URL'}
                />
            <Button styleName="dark full-width"><Icon name="play"/></Button>
          </View>
          <Divider styleName="section-header">
            <Caption>History</Caption>
          </Divider>
          <ScrollView>
            <ListView
                data={['App1','App2','App3','App4','App5','App6','App1','App2','App3','App4','App5','App6']}
                //loading={false}
                //onLoadMore={...}
                //onRefresh={...}
                //renderFooter={()=>{return <Divider styleName="line" />}}
                //renderHeader={...}
                renderRow={item => { return (
                                      <View styleName="vertical" >
                                        <Row styleName="small">
                                              <Icon name="play"/>
                                              <View styleName="content">
                                                <Subtitle numberOfLines={2}>{item}</Subtitle>
                                                <Caption>20 hours ago</Caption>
                                              </View>
                                        </Row>
                                        <Divider styleName="line"/>
                                      </View>
                                  )}}
                //renderSectionHeader={()=>{return <Divider styleName="line" />}}
                //style={...}
                />
          </ScrollView>
        </Screen>
    )
  }
}
