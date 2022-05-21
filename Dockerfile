FROM openjdk:8-jdk-alpine
EXPOSE 9090
ARG JAR_FILE=target/autocomplete-application-0.0.1.jar
ARG INPUT_FILE=src/main/resources/BoyNames.txt
COPY ${JAR_FILE} app.jar
COPY ${INPUT_FILE} /resources/BoyNames.txt
ENTRYPOINT ["java","-DfilePath=/resources/BoyNames.txt","-jar","/app.jar"]