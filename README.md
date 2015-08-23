# PwndChecker
A simple command line application, it loads your google contacts and queries haveibeenpwned.com with all your contacts.

## How to run
Dependencies:
* Java JDK 8
* Maven 3

```
cd repo-checkout
mvn clean compile
java -jar target/pwnedchecker-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```
The application will then try to open Googles OAuth2 page, you just have to click accept in the browser and can close the page. The application itself does not save any credential information, it will use the OAuth2 token to load all contacts in your Google account and then query haveibeenpwned.com with every email address found and print the results to the console.

## Open project in Eclipse 

You'll need the Ecplise Maven plugin installed.

1. Checkout repository
2. In Ecplise go to File -> Import
3. Choose Maven -> Existing Maven Project, Next
4. Browse to repository root
5. Finish
