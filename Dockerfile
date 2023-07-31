FROM openjdk:17-oracle
ADD target/product-service.jar product-service.jar
ENTRYPOINT ["java", "-jar","product-service.jar"]