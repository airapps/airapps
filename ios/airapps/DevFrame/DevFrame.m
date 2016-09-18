//
//  DevFrame.m
//  airapps
//
//  Created by guguyanhua on 16/9/16.
//  Copyright © 2016年 airapps. All rights reserved.
//

#import "DevFrame.h"
#import "RCTRootView.h"

@implementation DevFrame

- (instancetype)initWithEventDispatcher:(RCTEventDispatcher *)eventDispatcher {
    if ((self = [super init])) {
        _eventDispatcher = eventDispatcher;
    }
    
    return self;
}

-(void) setDevURL:(NSString*) devURL {
    
    NSURLComponents *components = [NSURLComponents componentsWithURL:[NSURL URLWithString:devURL] resolvingAgainstBaseURL:NO];
    components.path = [NSString stringWithFormat:@"/%@.bundle", @"index.ios"];
    // When we support only iOS 8 and above, use queryItems for a better API.
    components.query = [NSString stringWithFormat:@"platform=ios&dev=%@&minify=%@",
                        @"true" ,
                        @"false"];
    
    
    RCTRootView *rootView = [[RCTRootView alloc] initWithBundleURL:components.URL
                                                        moduleName:@"AirKit"
                                                 initialProperties:nil
                                                     launchOptions:nil]; //launchOptions TODO
    rootView.backgroundColor = [[UIColor alloc] initWithRed:1.0f green:1.0f blue:1.0f alpha:1];
    [self addSubview:rootView];
}
@end
