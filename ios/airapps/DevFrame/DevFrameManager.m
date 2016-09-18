//
//  DevFrameManager.m
//  airapps
//
//  Created by guguyanhua on 16/9/16.
//  Copyright © 2016年 airapps. All rights reserved.
//

#import "DevFrameManager.h"
#import "DevFrame.h"

@implementation DevFrameManager
RCT_EXPORT_MODULE();

- (UIView *)view
{
    return [[DevFrame alloc] initWithEventDispatcher:self.bridge.eventDispatcher];
}


- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}

RCT_EXPORT_VIEW_PROPERTY(devURL, NSString);
@end
