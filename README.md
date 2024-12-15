# Sample SpringBoot project


## Docs

https://spring.io/projects/spring-boot

https://docs.spring.io/spring-framework/reference/core/aop.html

https://www.baeldung.com/spring-boot-logging


## Requirements

1. Java11 or later
2. Maven3
3. SpringBoot 2.4 or later
4. (Recommended) IntelliJ IDEA Ultimate


## Run locally

### From IDE

Start `com.example.spring.Application`

### From CLI

Run `mvn clean package` to compile jar.

Run `java -Dspring.profiles.active=<profile> -jar <path-to-target-jar-from-previous-command>` to start. Check [reousrces](./src/main/resources) for available `profiles`.