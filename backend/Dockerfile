FROM openjdk:11.0.2-jdk as base
WORKDIR /tmp
COPY . .
RUN ./gradlew build

FROM openjdk:11.0.2-jre-slim
WORKDIR /tmp
COPY --from=base /tmp/build/libs/*.jar .
ENTRYPOINT java -jar ./*.jar
EXPOSE 8080
