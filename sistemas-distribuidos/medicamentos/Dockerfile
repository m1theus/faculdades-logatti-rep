FROM adoptopenjdk/openjdk11:alpine-jre

ENV APP_HOME=/usr/app/

WORKDIR $APP_HOME

COPY ./build/libs/*.jar ./app.jar

EXPOSE 1337

CMD ["java","-jar", "app.jar"]