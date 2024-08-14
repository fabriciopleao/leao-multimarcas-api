# Leão Center Multimarcas - API
Desenvolvimento de um projeto pessoal, com documentações e todas as camadas de uma aplicação real. Este repositório apresenta a API da concessionária digital fictícia.

## Tecnologias e materiais presentes
 - Spring Boot
 - Spring Data JPA
 - Java;
 - MySQL;
 - Documentação Swagger;
 - Documentação RFN - Requisitos Funcional de Negócios.

## Instruções para instalação
 - Clone este repositório
   
       git clone https://github.com/fabriciopleao/leao-multimarcas-api.git
 
 - Configurar variáveis de ambiente
   - **Java**: Certifique-se de que o JDK (Java Development Kit) esteja instalado em sua máquina e que a variável de ambiente `JAVA_HOME` esteja configurada corretamente.
   - **Maven**: Instale o Maven e configure a variável de ambiente `MAVEN_HOME`. Adicione o diretório `bin` do Maven ao `PATH`.
   - **MySQL**: Instale o MySQL Server e configure o acesso ao banco de dados. Defina as variáveis de ambiente `MYSQL_HOME` e adicione o diretório `bin` do MySQL ao `PATH`. Configure as credenciais de acesso ao banco de dados no arquivo `application.properties`.
 - Configurar banco de dados
   - Crie um banco de dados com o nome `leaocentermultimarcas`.

         mysql -u 'SEU USER' -p
         'SEU PASSWORD'
         CREATE DATABASE IF NOT EXISTS leaocentermultimarcas;
     
   - Configure as credenciais de acesso ao banco de dados no arquivo `application.properties`.
  - Execute a aplicação

        mvn clean install
        mvn spring-boot:run

## Documentação
  - Swagger: http://localhost:8087/swagger-ui/index.html#/
    
### PROJETO W.I.P
