FROM openjdk:11.0-jdk-slim-stretch

RUN apt-get install -y tzdata

ENV TZ America/Buenos Aires
VOLUME ["/home"]
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=release","/home/proxy.jar"]
