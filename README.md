# GraphQL API

http://localhost:8080/graphql

query {
  findAllBooks {
    id
    title
    pages
    author
    reviews {
      id
      title
      comment
    }
  }
}

mutation AddBook {
  addBook(bookInput: { title: "My New Book", pages: 199, author: "Dan Vega" }) {
    id
    title
    pages
    author
  }
}

