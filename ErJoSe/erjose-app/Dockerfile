# FROM maven:3.8.5-openjdk-21
FROM maven:3.1.4-openjdk-17

WORKDIR /erjose
COPY .. .
RUN mvn clean install

CMD mvn spring-boot:run