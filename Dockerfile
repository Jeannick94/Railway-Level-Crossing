FROM openjdk:22-oracle
LABEL authors="jeann"

COPY target/*.jar levelCrossingApp-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "levelCrossingApp-0.0.1-SNAPSHOT"]