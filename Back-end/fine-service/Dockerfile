FROM openjdk:26-oraclelinux9
LABEL authors="valkyrie"
ADD target/fine-service.jar fine-service.jar
ENTRYPOINT ["java", "-jar", "/fine-service.jar"]