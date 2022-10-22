FROM openjdk:8
ADD /target/projectmanagementmicroservice.jar projectmanagementmicroservice.jar
ENTRYPOINT ["java", "-jar", "projectmanagementmicroservice.jar"]