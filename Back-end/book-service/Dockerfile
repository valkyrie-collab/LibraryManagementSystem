FROM openjdk:26-oraclelinux9
LABEL authors="valkyrie"
ADD target/book-service.jar book-service.jar
ENTRYPOINT ["java", "-jar", "/book-service.jar"]