# Atividade 6
API em Spring Boot que recebe um corpo (JSON) contendo o nome e a idade de uma pessoa. A API verifica se a idade é maior ou igual a 18 anos e, em caso positivo, retorna o nome da pessoa e uma mensagem de que a entrada é permitida.

## Requisitos:
- Java Development Kit (JDK) 17 ou superior
- Apache Maven
- SpringBoot 3

## Configs:

### `pom.xml`
Configure as dependências necessárioas para o projeto:
```
        <properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>
	</dependencies>
```

## Endpoints REST:
Com a aplicação rodando, teste o endpoint no `Postman`
```
- Verificar entrada
    Método http: POST
    URL de acesso: localhost:8080/api/v1/verify
    Body JSON:
    {
      "name": "Hefrayn",
      "age": "59"
    }
```

## Exceções:
Foi criado um controlador de exceções `GlobalExceptionHandler` e a classe `ErrorMessage` para tratar as exceções lançadas pela controller. <br>
Foi gerada validação dos dados de entrada através das constraints do jakarta validation.<br>
`@Valid` `@NotBlank` `@Pattern` `@NotNull` `@Min`<br>
As exceções lançadas pelas constraints são tratadas pelo método `methodArgumentNotValidException` da classe `GlobalExceptionHandler`. <br>
Também foi tratada exceção `HttpMessageNotReadableException` que é lançada quando a idade é passada como uma string. Ocorre esso ao tentar desserializar a entrada do tipo string para integer. 
