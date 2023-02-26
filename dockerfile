FROM openjdk

WORKDIR /app
COPY target/finalProject-0.0.1-SNAPSHOT.war /app
EXPOSE 8080
CMD ["java","-jar","/app/finalProject-0.0.1-SNAPSHOT.war"]