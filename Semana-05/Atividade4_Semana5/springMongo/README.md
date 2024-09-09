**Atividade 4 Semana 5**

Config:
- pom.xml:
    

- application.properties:
    spring.data.mongodb.uri=mongodb://localhost:27017/library

- MongoDB.
    DatabaseName: library
    Collection: books

Endpoints REST: 
- Inserir registro de mais de um livro
    Método http: POST
    URL de acesso: localhost:8080/books/insertMult
    Body JSON: 
    [
      {
          "title": "Animal Farm",
          "author": "George Orwell",
          "pubYear": "1945",
          "type": "Fábula"
      },
      {
          "title": "Dom Casmurro",
          "author": "Machado de Assis",
          "pubYear": "1899",
          "type": "Romance"
      },
      {
          "title": "1984",
          "author": "George Orwell",
          "pubYear": "1949",
          "type": "Ficção Científica"
      },
      {
          "title": "The Lord of the Rings",
          "author": "J.R.R. Tolkien",
          "pubYear": "1954",
          "type": "Fantasia"
      }
    ]

- Inserir registro de apenas um livro
    Método http: POST
    URL de acesso: localhost:8080/books
    Body JSON:
    {
      "title": "The Lord of the Rings",
      "author": "J.R.R. Tolkien",
      "pubYear": "1954",
      "type": "Fantasia"
    }

- Apagar registro por titulo
    Método http: DELETE
    URL de acesso: localhost:8080/books/Dom Casmurro

- Atualizar registro
    Método http: PUT: 
    URL de acesso: localhost:8080/books/up/{id}
    JSON: 
    {
      "title": "1984",
      "author": "George Orwell",
      "pubYear": "1950",
      "type": "Ficção Científica"
    }

- Buscar registros por Autor
      GET: localhost:8080/findAuthor?text=George%20Orwell

- Buscar registros por Ano de Publicação
      GET: localhost:8080/books/findYear?text=1945