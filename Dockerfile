FROM gradle:9.2.1-jdk21 AS builder

WORKDIR /home/gradle/project

COPY build.gradle settings.gradle ./
COPY src ./src

RUN gradle war -x test --no-daemon

FROM tomcat:10.1-jdk21

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=builder /home/gradle/project/build/libs/AcoesExtensao-*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080