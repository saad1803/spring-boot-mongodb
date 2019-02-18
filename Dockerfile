# From java image
FROM openjdk:8-jre-alpine

#Maintainer
MAINTAINER saad ahmed<saad.ahmed@teradata.com>

VOLUME /temp

VOLUME /log

COPY target/*.jar /mongo.jar

EXPOSE 8080
# RUN bash -c ‘touch /mongodb.jar’
CMD ["java","-Dspring.data.mongodb.uri=mongodb://mongo/test", "-Djava.security.egd=file:/dev/./urandom","-jar","/mongo.jar"]
