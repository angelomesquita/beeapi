# Use a imagem base do Ubuntu 20
FROM ubuntu:20.04

# Instale o OpenJDK 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*

# Defina o diretório de trabalho no contêiner
WORKDIR /app

# Copie o arquivo JAR do seu projeto para o contêiner
COPY target/beer-api-0.0.1-SNAPSHOT.jar /app/beer-api.jar

# Expõe a porta 8083, que é a porta padrão do Spring Boot
EXPOSE 8083

# Comando para iniciar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "/app/beer-api.jar"]
