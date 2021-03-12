# you_radio
The new version of the you_radio web app.It supports the new spring reference.

## Linux
You build it with maven.
```
mvn package
```
in the root directory.
All the dependencies will be automatically downloaded,from the mvnw and mvnw.cmd files.
To run after you've build type
```
java -cp java -cp target/you_radio_0.0.1-SNAPSHOT.jar com.pgiank.you_radio.init
```
You must have java 1.8 installed.After that,just navigate with your favorite browser to localhost:8080 and enjoy music

