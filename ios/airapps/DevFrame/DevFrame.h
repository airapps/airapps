//
//  DevFrame.h
//  airapps
//
//  Created by guguyanhua on 16/9/16.
//  Copyright © 2016年 airapps. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "RCTBridgeModule.h"
#import "RCTEventDispatcher.h"
#import "UIView+React.h"

@interface DevFrame : UIView

@property (nonatomic, assign) RCTEventDispatcher* eventDispatcher;

- (instancetype)initWithEventDispatcher:(RCTEventDispatcher *)eventDispatcher;

-(void) setDevURL:(NSString*) devURL;
@end
