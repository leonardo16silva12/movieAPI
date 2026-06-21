# Movie API

API REST desenvolvida com Spring Boot para gerenciamento de filmes, gêneros e países.

## Tecnologias Utilizadas

* Java 8+
* Spring Boot 2.4
* Spring Data JPA
* Hibernate
* Banco de dados H2
* Maven

## Funcionalidades

* Cadastro de filmes
* Consulta de filmes
* Atualização de filmes
* Exclusão de filmes
* Cadastro de gêneros
* Cadastro de países
* Relacionamento entre filmes, gêneros e países

## Estrutura do Projeto

### Entidades

#### Filme

* ID
* Título
* Sinopse
* Duração
* Data de estreia
* País
* Gênero

#### Gênero

* ID
* Nome

#### País

* ID
* Nome

## Como Executar

### Pré-requisitos

* Java 8 ou superior
* Maven

### Clonar o projeto

```bash
git clone https://github.com/leonardo16silva12/movieAPI.git
cd movieAPI
```

### Executar a aplicação

```bash
mvn spring-boot:run
```

A aplicação será iniciada na porta:

```text
http://localhost:8080
```

## Console H2

Acesse:

```text
http://localhost:8080/h2-console
```

Configuração:

```text
JDBC URL: jdbc:h2:mem:movieapi
User Name: sa
Password:
```

## Endpoints

### Filmes

#### Listar todos os filmes

```http
GET /filmes/todos
```

#### Buscar filme por ID

```http
GET /filmes/{id}
```

#### Cadastrar filme

```http
POST /filmes
```

Exemplo:

```json
{
  "titulo": "Matrix",
  "sinopse": "Neo descobre a verdade sobre a Matrix",
  "duracao": 136,
  "dataestreia": "1999-03-31",
  "pais": {
    "id": 1
  },
  "genero": {
    "id": 1
  }
}
```

#### Atualizar filme

```http
PUT /filmes/{id}
```

#### Excluir filme

```http
DELETE /filmes/{id}
```

---

### Gêneros

#### Listar todos os gêneros

```http
GET /generos/todos
```

#### Buscar gênero por ID

```http
GET /generos/{id}
```

#### Cadastrar gênero

```http
POST /generos
```

Exemplo:

```json
{
  "nome": "Ação"
}
```

#### Atualizar gênero

```http
PUT /generos/{id}
```

#### Excluir gênero

```http
DELETE /generos/{id}
```

---

### Países

#### Listar todos os países

```http
GET /paises/todos
```

#### Buscar país por ID

```http
GET /paises/{id}
```

#### Cadastrar país

```http
POST /paises
```

Exemplo:

```json
{
  "nome": "Estados Unidos"
}
```

#### Atualizar país

```http
PUT /paises/{id}
```

#### Excluir país

```http
DELETE /paises/{id}
```

## Exemplo de Fluxo

1. Criar um gênero.
2. Criar um país.
3. Criar um filme utilizando os IDs do gênero e país cadastrados.
4. Consultar os filmes cadastrados.

## Autor

Leonardo Silva
