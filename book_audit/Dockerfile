FROM openjdk:21

ADD ./build/libs/book_audit-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/book_audit-0.0.1-SNAPSHOT.jar"]

EXPOSE 8686