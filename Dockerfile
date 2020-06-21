FROM maven:3.6.0-jdk-11-slim AS build
COPY src /Users/dharanianimireddy/latest/src
COPY pom.xml /Users/dharanianimireddy/latest
RUN mvn -f /Users/dharanianimireddy/latest/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /Users/dharanianimireddy/latest/target/gs-spring-boot-docker-0.1.0.jar /usr/local/lib/demolatest.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/demolatest.jar"]
