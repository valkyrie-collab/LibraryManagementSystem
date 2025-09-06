FROM openjdk:26-oraclelinux9
LABEL authors="valkyrie"
ADD target/entity-service.jar entity-service.jar
ENTRYPOINT ["java", "-jar", "/entity-service.jar"]