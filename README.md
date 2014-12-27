Selenide examples: Gmail
========================

This is a sample project demonstrating how to test GMail UI with Selenide (Selenium webdriver).

**You can checkout and run it locally with a few minutes.**

### How to run

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

_Feel free to share your feedback!_

### Video

It's a short video demonstrating how it works:

<iframe src="//player.vimeo.com/video/115448433" width="800" height="526" frameborder="0" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe> <p><a href="http://vimeo.com/115448433">GMail test</a> from <a href="http://vimeo.com/user20427140">Selenide</a> on <a href="https://vimeo.com">Vimeo</a>.</p> <p>A sample project demonstrating how to test GMail UI with Selenide (Selenium webdriver).<br /> <br /> You can checkout and run it locally with a few minutes!<br /> <br /> https://github.com/selenide-examples/gmail</p>
