FROM fabric8/java-jboss-openjdk8-jdk:1.5.1

ENV JAVA_APP_JAR scaffold-1.0.0-SNAPSHOT-thorntail.jar
ENV AB_ENABLED off
ENV JAVA_OPTIONS "-Xms512m -Xmx512m"
ENV MAVEN_CLEAR_REPO true
ENV JAVA_DEBUG true
ENV JAVA_DEBUG_PORT 6666
ENV GC_MAX_METASPACE_SIZE 512


EXPOSE 8080



RUN chmod -R 777 /deployments/
ADD target/scaffold-1.0.0-SNAPSHOT-thorntail.jar /deployments/
