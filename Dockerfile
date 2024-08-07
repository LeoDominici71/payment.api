# Imagem base com Java 17
FROM openjdk:17-jdk

# Copiar o arquivo JAR da aplicação para o container
COPY target/payment.api-0.0.1-SNAPSHOT.jar /app/payment.jar

# Comando para executar a aplicação
CMD ["java", "-jar", "/app/payment.jar"]