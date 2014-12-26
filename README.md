Selenide examples: Gmail
========================

This is a sample project demonstrating how to test GMail UI with Selenide (Selenium webdriver).

To run Gmail tests, just type from command line:

```
./gradle -Dgmail.username=your_email@gmail.com -Dgmail.password=your_gmail_password
```


Alternatively, you can add these lines to file `<USER_HOME>/.gradle/gradle.properties`

```
systemProp.gmail.username=your_email@gmail.com
systemProp.gmail.password=your_gmail_password
```

And just run `./gradle` from command line.