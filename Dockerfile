FROM gradle:8-jdk21-jammy AS builder
WORKDIR /
COPY . ./
RUN gradle build

FROM openjdk:21-slim
LABEL authors="Dimitri"
COPY --from=builder build/libs
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
