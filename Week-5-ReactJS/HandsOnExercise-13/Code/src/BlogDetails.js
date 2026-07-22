import React from "react";

function BlogDetails() {
    const blogs = [
        {
            id: 1,
            title: "React Basics",
            author: "John"
        },
        {
            id: 2,
            title: "Understanding JSX",
            author: "Michael"
        },
        {
            id: 3,
            title: "Hooks Explained",
            author: "Sarah"
        }
    ];
    return (
        <div>
            <h2>Blog Details</h2>
            <ul>
                {
                    blogs.map(blog => (
                        <li key={blog.id}>
                            <b>{blog.title}</b>
                            {" - "}
                            {blog.author}
                       </li>
                    ))
                }
            </ul>
        </div>
    );
}

export default BlogDetails;