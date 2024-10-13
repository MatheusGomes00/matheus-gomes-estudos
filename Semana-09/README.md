## Clientes Microservice
```
1.  Salvar Cliente:
    POST
    input-JSON: {cpf: string, nome: string, idade: int}
    output: Header Location

2.  Obter dados Cliente por CPF:
    GET
    input-Request Param: {cpf}
    output: {id: int, cpf: string, nome: string, idade: int}
```