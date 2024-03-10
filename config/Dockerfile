FROM openjdk:21

ADD ./build/libs/config-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config-0.0.1-SNAPSHOT.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8888/actuator/health || exit 1

EXPOSE 8888

#docker pull consul:1.15.4
#docker run -d --name=consul -p 8500:8500 consul:1.15.4
#docker build -t application:tag .
#docker run -p 8585:6000 config:tag