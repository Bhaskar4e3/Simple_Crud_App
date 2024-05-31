FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 1234
EXPOSE 1234
COPY target/Simple_crud.exe.jar /opt/Simple_crud.exe.jar
ENTRYPOINT exec java $JAVA_OPTS -jar Simple_crud.exe.jar