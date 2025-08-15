# Books Management API

A simple Java + Spring Boot project for managing a list of books.  
Includes basic CRUD operations, validation, DTOs, and proper HTTP responses.

---

## Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA (H2 database)
- Jakarta Validation (`@Valid`, `@NotBlank`, `@NotNull`)
- REST API tested via Postman
- DTOs for request/response separation

---

## Features

| Method   | URL                               | Description                          |
|----------|-----------------------------------|--------------------------------------|
| `GET`    | `/books/`                         | List all books                       |
| `GET`    | `/books/{name}/{author}`          | Get book by name and author          |
| `POST`   | `/books/`                         | Add a new book (`RequestBook`)       |
| `DELETE` | `/books/{name}/{author}`          | Delete a book by name and author     |

---

## Example `RequestBook` (used for input)

```json
{
  "nameReqBook": "The Lord of the Rings",
  "authorReqBook": "J. R. R. Tolkien",
  "priceReqBook": 10.5,
  "codeReqBook": 4323
}
