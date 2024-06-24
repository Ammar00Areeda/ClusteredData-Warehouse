FROM registry.access.redhat.com/ubi8/openjdk-21:1.18
RUN mkdir /opt/app
COPY ./target/*.jar /opt/app/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app/app.jar"]
