import React from "react";

function BookDetails() {
    const books = [
        {
            id: 1,
            name: "Clean Code",
            author: "Robert C. Martin",
            price: 550
        },
        {
            id: 2,
            name: "Head First Java",
            author: "Kathy Sierra",
            price: 700
        },
        {
            id: 3,
            name: "Effective Java",
            author: "Joshua Bloch",
            price: 900
        }
    ];
    return (
        <div>
            <h2>Book Details</h2>
            <table border="1" cellPadding="8">
                <thead>
                    <tr>
                        <th>Name</th>
                       <th>Author</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        books.map(book => (
                            <tr key={book.id}>
                                <td>{book.name}</td>
                               <td>{book.author}</td>
                               <td>₹ {book.price}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}
export default BookDetails;