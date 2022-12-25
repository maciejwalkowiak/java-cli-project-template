# Java CLI project template

Probably the fastest way to bootstrap a Java Command Line Application (CLI) project!

## 🤩 Highlights

- uses [Picocli](https://picocli.info/) for simple and elegant commands implementation
- builds to an **executable jar** and **GraalVM Native Image**
- preconfigured `help` and `version` commands
- uses **Maven** as a build tool
- **no frameworks** like Spring, Micronaut or Quarkus

## 🛠 Requirements

- GraalVM distribution of Java (easy to install with https://sdkman.io/)

## 🤔 How to use

Build an executable JAR:

```
$ ./mvnw package
```

Build a native image:

```
$ ./mvnw package -Pnative
```

Run application through Maven

```
$ ./mvnw -Dexec.args=help
```
