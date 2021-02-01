# HWA-Project

## Getting Started

- JIRA Board Link - https://team-1606236407721.atlassian.net/jira/software/projects/HWAP/boards/7

### Prerequisites
What things you need to install the software and how to install them
Git Bash --> https://gitforwindows.org/
Java jdk-14.0.1 --> https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
Maven --> https://maven.apache.org/download.cgi
Springboot --> https://spring.io/guides/gs/spring-boot/

### Installing

A step by step series of examples that tell you how to get a development env running

1. Open git Bash.

2. cd to the directory where your file is stored, in my case its in Desktop and go into the documentation folder.

```
$ cd "   your file directory    "/HWA-Project
```

3. Unwrap the war file 

```
$  java -jar HWA-Project-0.0.1-SNAPSHOT.war

```

## Running the tests

To run tests please use git bash and use the following file directory structure to cd too. Make sure in the IMS-Starter folder there should be a pom file like below. To see the contents of a folder please use the command ls.

```
$ cd "   your file directory    "/HWA-Project
```

### Unit Tests 
Unit testing tests each invdiual method of the program. 

Run all the unit test classes.

```
$ mvn test
```

Run a single unit test classe.

```
$ mvn -Dtest= "Test name" test
```

Run a set of unit test classes.

```
$ mvn -Dtest= "Test name", "Test name" test
```


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors
* **Chetan Pardeep** - *Rest of the work* - [chetanpardeep](https://github.com/QAcpardeep)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc

