# UI Tests

This is a small project based on Jmix. This application is designed to show features of the [masquerade](https://github.com/Haulmont/jmix-masquerade) library for the Jmix apps automation UI tests.

The project covers the following aspects:

- Simple login test
    - Example of LoginScreen class as an abstraction of the Login screen
- Create a new user in the system
    - Example of UserBrowse and UserEdit classes as an abstractions of the User Browse and User Edit screens

Run the following tasks in the terminal to start application with Gradle:

```
    gradlew bootRun
```

In order to run all tests from the command line, use the `test` Gradle task:

```
    gradlew test
```

Based on Jmix 1.0.1

## Issues
Please use https://forum.jmix.io/ for discussion, support, and reporting problems corresponding to this sample.