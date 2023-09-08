FROM openjdk:17-jdk-alpine
WORKDIR /opt/app
COPY target/emp-1.jar emp.jar
ENTRYPOINT ["java","-jar","emp.jar"]