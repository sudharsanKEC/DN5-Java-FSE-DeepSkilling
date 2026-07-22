import React from 'react';
import Post from './Post';
class Posts extends React.Component{
    constructor(props){
        
        super(props);

        this.state = {
            posts: []
        };
    }
    
    loadPosts(){
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(response => response.json())
            .then(data => {
                console.log(data);
                const posts = data.map(post => new Post(post.id, post.title, post.body));
                console.log(posts);
                this.setState({
                    posts: posts
                });                
            })
            .catch(error => {
                console.log(error);
            });
    }
    
    componentDidMount(){
        this.loadPosts();
    }

    componentDidCatch(error, info){
        
        alert("An Error Occured");

        console.error(error);
        console.error(info);
    }

    render(){
        console.log(this.state.posts);
        return (
            <div>
                <h1>Blog Posts</h1>
                {
                    this.state.posts.map(post => (

                        <div key={post.id}>

                            <h2>{post.title}</h2>

                            <p>{post.body}</p>

                            <hr />

                        </div>

                    ))
                }
            </div>
        )
    }
}

export default Posts;