FROM openjdk:26-oraclelinux9
LABEL authors="valkyrie"
ADD target/transaction-service.jar transaction-service.jar
ENTRYPOINT ["java", "-jar", "/transaction-service.jar"]