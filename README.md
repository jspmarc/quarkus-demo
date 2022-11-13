# code-with-quarkus Project

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
cd rest-web && mvn quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
mvn package
```
It produces the `quarkus-run.jar` file in the `rest-web/target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `rest-web/target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar rest-web/target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
mvn package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar rest-web/target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
mvn package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
mvn package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./rest-web/target/quarkus-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

### Creating a native executable for Linux x86 on M1 MacBook

1. First, create the builder image
```
docker build -f rest-web/docker/Dockerfile.graalbase -t graalbase .
```

2. Compile the executable
```
mvn package -Pnative -Dquarkus.native.container-build=true -Dquarkus.native-builder-image=graalbase
```

More info: https://github.com/quarkusio/quarkus/issues/16225#issuecomment-1004854142
