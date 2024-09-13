# ParkAPI
Sistema de estacionamento desenvolvido na semana 6 do programa de bolsas Uol Compass, turma SpringBoot AWS AGO2024

## Requisitos:
- Java Development Kit (JDK) 17 ou superior
- Apache Maven
- SpringBoot 3
- MySQL
- Postman

## Configs:

### `pom.xml`
Configure as dependências necessárioas para o projeto
```
<properties>
		<java.version>17</java.version>
</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
	</dependencies>
```

### `application.properties`
Configure a conexão com o banco de dados no projeto Spring
```properties
spring.application.name=parkApi

# LOCALE  fixar o LOCALE como Brasileiro
spring.mvc.locale-resolver=fixed
spring.mvc.locale=pt_BR

# MySQL Database Connection Properties
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/park_api?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=America/Sao_Paulo
spring.datasource.username=dev
spring.datasource.password=963258

# JPA
# Mostrar todas as instruções SQL geradas
spring.jpa.show-sql=true
# Mostrar em log as instruções SQL em uma linha
spring.jpa.properties.hibernate.format_sql=false
# Montar as tabelas automaticamente pelo mapeamento do hibernate
spring.jpa.hibernate.ddl-auto=update
```

### `Endpoints REST:`
Com a aplicação rodando, testar os seguintes endpoints no `Postman`
```
- Inserir novo usuario
    Método http: POST
    URL de acesso: localhost:8080/api/v1/usuarios
    Body JSON:
    {
      "username": "teste@email.com",
      "password": "123456"
    }
    
- Alterar senha
    Método http: PATCH
    URL de acesso: localhost:8080/api/v1/usuarios/1
    Body JSON:
    {
      "senhaAtual": "teste123",
      "novaSenha": "teste123",
      "confirmaSenha": "teste123"
    }

```