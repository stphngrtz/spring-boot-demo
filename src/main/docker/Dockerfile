FROM eclipse-temurin:17-jre-jammy

RUN addgroup group; adduser --ingroup group --disabled-password user
USER user

WORKDIR /app

COPY target/demo-*.jar /app/demo.jar

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /app/demo.jar ${0} ${@}"]