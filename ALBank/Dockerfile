FROM openjdk:8

COPY . /app
COPY WEB-INF/lib lib
WORKDIR /app
RUN javac src/main/main.java

CMD ["java", "-jar", "app.jar"]