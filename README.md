# you_radio
Listen to music from you_tube in a friendly interface.Type your mood,favorite artists or anything you like in the search bar and the app will automatically create a playlist of 10-50 songs from Youtube for you.Enjoy!

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

## Out of order-March 2021
This app won't work because of the limit that the You-tube API has set to the quotas per day
![Screenshot from 2021-03-13 22-46-19](https://user-images.githubusercontent.com/17511966/111043998-99591600-844e-11eb-9118-5872897786f1.png)
