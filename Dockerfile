FROM openjdk
WORKDIR /app/src
COPY ./target/student_list-0.0.1-SNAPSHOT.jar /app/src/student_list-0.0.1-SNAPSHOT.jar
EXPOSE 3001
ENTRYPOINT ["java", "-jar", "student_list-0.0.1-SNAPSHOT.jar"]