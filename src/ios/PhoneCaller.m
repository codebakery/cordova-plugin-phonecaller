#import "PhoneCaller.h"
#import <Cordova/CDV.h>

@implementation PhoneCaller

- (void)call:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult *pluginResult = nil;
    NSString *phoneNumber = [command.arguments objectAtIndex:0];

    if (phoneNumber != nil && [phoneNumber length] > 0) {
        NSString *cleanedPhoneNumber = [[phoneNumber componentsSeparatedByCharactersInSet:[[NSCharacterSet characterSetWithCharactersInString:@"0123456789,-+()"] invertedSet]] componentsJoinedByString:@""];
        NSURL *telURL = [NSURL URLWithString:[NSString stringWithFormat:@"tel:%@", cleanedPhoneNumber]];
        [[UIApplication sharedApplication] openURL:telURL];
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
