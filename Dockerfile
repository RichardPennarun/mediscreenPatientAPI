FROM openjdk:11
ARG JAR_FILE=build/libs/MediscreenPatientAPI-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} MediscreenPatientAPI-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/MediscreenPatientAPI-0.0.1-SNAPSHOT.jar"]
EXPOSE 8081