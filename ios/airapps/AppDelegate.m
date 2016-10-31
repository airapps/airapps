//
//  AppDelegate.m
//  airapps
//
//  Created by guguyanhua on 16/9/12.
//  Copyright © 2016年 airapps. All rights reserved.
//

#import "AppDelegate.h"

#import "RCTBundleURLProvider.h"
#import "RCTRootView.h"
//#import "RCTRongCloud.h"
//#import <AMapFoundationKit/AMapFoundationKit.h>

#import <ReactNativeConfig/ReactNativeConfig.h>
#import "RCTLinkingManager.h"

@interface AppDelegate ()

@end

@implementation AppDelegate


- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions {
    
    NSLog(@"--------------------");
    NSLog(@"ReactNativeConfig: %@", [[ReactNativeConfig env] description]);
    NSLog(@"--------------------");
    
    //Rong Cloud TODO
//    [RCTRongCloud registerAPI:@"c9kqb3rdkc8kj"];
//    [AMapServices sharedServices].apiKey = [ReactNativeConfig envFor:@"AMAP_IOS_KEY"];
    
    
    NSURL *jsCodeLocation;
    
    jsCodeLocation = [[RCTBundleURLProvider sharedSettings] jsBundleURLForBundleRoot:@"index.ios" fallbackResource:nil];
    
    RCTRootView *rootView = [[RCTRootView alloc] initWithBundleURL:jsCodeLocation
                                                        moduleName:@"AirKit"
                                                 initialProperties:nil
                                                     launchOptions:launchOptions];
    rootView.backgroundColor = [[UIColor alloc] initWithRed:1.0f green:1.0f blue:1.0f alpha:1];
    
    self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
    UIViewController *rootViewController = [UIViewController new];
    rootViewController.view = rootView;
    self.window.rootViewController = rootViewController;
    [self.window makeKeyAndVisible];
    return YES;
}

- (BOOL)application:(UIApplication *)application openURL:(NSURL *)url
  sourceApplication:(NSString *)sourceApplication annotation:(id)annotation
{
    return [RCTLinkingManager application:application openURL:url
                        sourceApplication:sourceApplication annotation:annotation];
}


@end
