# cordova-plugin-phonecaller

Call phone numbers from your app

## Methods

- window.PhoneCaller.call(phoneNumber: string, success: Function, [error: Function]) - starts a call to `phoneNumber`

### Supported Platforms

- Android
- iOS

### Installation

- Android: Requires `CALL_PHONE` permission.
- Both: Requires `tel` intent whitelisted. (e.g. `<allow-intent href="tel:*" />`)
