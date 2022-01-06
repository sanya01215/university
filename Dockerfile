FROM gradle:7.1.1-jdk11 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:11-jdk-slim
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/
ENTRYPOINT ["java","-jar","app/*.jar"]
EXPOSE 5000