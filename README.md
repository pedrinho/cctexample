# CCT Example

Simple example of Chrome Custom Tabs usage.

### About

In order to improve the security, the PayPal [security guidelines](https://developer.paypal.com/docs/classic/lifecycle/info-security-guidelines/?mark=chrome%20custom%20tab#secure-applications) demands the use of [Chrome Custom Tabs](https://developer.chrome.com/multidevice/android/customtabs) on Android. It is important that the PayPal page where the user input its login information is rendered by CCT.
This repository is a simple implementation example that can be used as a reference.

### Usage

After opening the app, there will be 2 buttons:

- The Get Approval URL consumes an [endpoint](https://runkit.io/pedrinho/approval-url/8.0.0) that generates an approval url and fill the text. You can generate an approval url using Postman for instance, but make sure that the return url parameter is set to the "cctexample://return" [schema](blob/7ebf6526d69377082de3332c174ffd97b47d1b14/app/src/main/AndroidManifest.xml#L29)

- Click on the Open CCT button. The URL provided in the textbox will be [launched](blob/7ebf6526d69377082de3332c174ffd97b47d1b14/app/src/main/java/com/example/cctexample/MainActivity.kt#L31).

- After login and sign the billing agreement, the PayPal will redirect to the return url (cctexample://return).

- The [object](7ebf6526d69377082de3332c174ffd97b47d1b14/app/src/main/java/com/example/cctexample/HandleReturn.kt#L12) assigned to the schema will be executed.
