# Java CLI project template

Probably the fastest way to bootstrap a **Java** Command Line Application (**CLI**) project!

Click the big green *Use This Template* button and start building your own CLI.

## 🤩 Highlights

- uses [Picocli](https://picocli.info/) for simple and elegant commands implementation
- builds to an **executable jar** and **GraalVM Native Image**
- preconfigured `help` and `version` commands
- uses **Maven** as a build tool
- **no frameworks** like Spring, Micronaut or Quarkus

## 🛠 Requirements

- GraalVM distribution of Java (easy to install with https://sdkman.io/)

## 🤔 How to use

Run tests & build an executable JAR:

```
$ ./mvnw package
```

Run tests as native image & build a native executable:

```
$ ./mvnw package -Pnative
```

Run application through Maven

```
$ ./mvnw -Dexec.args=help
```

Sounds good? Consider [❤️ Sponsoring](https://github.com/sponsors/maciejwalkowiak) the project! Thank you!
