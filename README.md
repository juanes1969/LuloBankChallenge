# **Api automation challenge**

# Warning! ⚠️
```The api usually has problems of connection ```

## Introduction 🚀

Automation made for a business challenge, with transactions like call API for manage employe.

#### Scenarios


- Call an API, consume the POST method to create a employe, consume the GET method to view all employe, consume the GET BY ID method to view employe with id, consume the DELETE method to view employe deleted

## Pre requirements to execute 📋
- Java version 1.8, update 151 or higher and JDK (environment variables configured).
- Eclipse IDE or IntelliJ IDEA (version 2018.3 or higher).
- Gradle version 6.0 or higher (environment variables configured).
- Cucumber for Java Plugin (updated version).
- Gherkin Plugin (updated version).

## Installation 🔧
- To clone this repository locally, the following command must be run:
  ```git clone https://github.com/juanes1969/LuloBankChallenge```
- Import the project from Eclipse or IntelliJ IDE under the structure of an existing Gradle project.
- Configure JRE System Library with JavaSE-1.8.
- Configure the encoding to UTF-8 to the project once it is imported.

## Compile the project and generate Wrapper 🔨
- To build the project you must run the command:
  ```gradle clean build -x test```
- To generate the project wrapper files, you must run the command:
  ```gradle wrapper --gradle-distribution-url https://services.gradle.org/distributions/gradle-6.0-bin.zip```

## Command for execution 💻
The project can be executed from the console with the following command:
```gradle clean test aggregate```

## Project structure 🚧

* ```src/main/java/com/co/com/lulobank/certification/```
```    
+ exceptions
    Classes that catch custom exceptions when automation fails and cannot find an expected field.

+ interactions
    Classes that work to do specific custom actions when they are not found from serenity

+ models
    Classes with which the data models are built using the builder pattern.

+ questions
    Classes with which values are obtained and then verified in the stepdefinitions (asserts).

+ tasks
    Classes that perform high-level actions, such as login in the application, enter data into a form, etc.

+ utilities
    Classes that contain common functionalities.
```

* ```src/main/java/com/co/com/lulobank/certification/```
```
+ runners
    Classes to run automation with the scenarios indicated in the feature.

+ stepdefinitions
    Classes that are the entry point of the feature to translate from Gherkin language to machine language and thus allow the execution of automation.
 ```

* ```src/test/resources/```
```

+ features
    The project features are found.

```

## Built with 🛠
Automation was developed with:
- BDD - Development strategy
- Screenplay
- Gradle - Dependency manager
- Appium - Tool to automate actions in mobile devices
- Cucumber - Framework to automate BDD tests
- Serenity BDD - Open source library for report generation
- Gherkin - Business Readable DSL Language (Business-readable domain specific language)

## Versioning 📌
Git was used for version control, applying TBD 🔀

## Authors 👨

* **Juan Esteban Olaya** - [juanesolayalopez@gmail.com]()