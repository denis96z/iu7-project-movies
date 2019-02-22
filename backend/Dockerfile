FROM openjdk:11.0.2-jdk as base
WORKDIR /tmp
COPY . .
RUN ./gradlew build && mv $(./gradlew -q printArchivePath) ./app.jar

FROM openjdk:11.0.2-jre-slim
WORKDIR /tmp
COPY --from=base /tmp/app.jar ./app.jar
ENTRYPOINT java -jar -Dspring.profiles.active=prod ./app.jar
EXPOSE 80
