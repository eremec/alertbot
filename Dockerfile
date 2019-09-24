FROM openjdk:11-jre

ADD target/alertbot-1.0.0-SNAPSHOT-standalone.jar /app.jar

CMD java -jar /app.jar
