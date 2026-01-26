Selenide examples: Gmail
========================

This is a sample project demonstrating how to test GMail UI with Selenide (Selenium webdriver).

**You can checkout and run it locally with a few minutes.**

### How to run

To run Gmail tests, just type from command line:

```
./gradlew -Dgmail.username=your_email@gmail.com -Dgmail.password=your_gmail_password
```


Alternatively, you can add these lines to file `<USER_HOME>/.gradle/gradle.properties`

```
systemProp.gmail.username=your_email@gmail.com
systemProp.gmail.password=your_gmail_password
```

And just run `./gradlew` from command line.

_Feel free to share your feedback!_

### Video

It's a short video demonstrating how it works:

https://vimeo.com/115448433
