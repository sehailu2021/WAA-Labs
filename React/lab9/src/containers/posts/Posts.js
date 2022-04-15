
import {React, useEffect, useState  } from "react";

import Post from "../../components/post/Post";

import axios from "axios";

// props arry of post
const Posts= (props) => {
 
    const [posts,setPosts ] = useState(
        [ { }])

     const fetchPosts = ()=>{
       axios.get('http://localhost:8080/api/v1/posts')
       .then(response =>{
           setPosts(response.data)

       })
       .catch(error => {
           console.log(error.message)
       })
     }
     useEffect( ()=>{
        fetchPosts();
    }, [props.fetchFlag])
    

    const postList = posts.map(post => {
        return <Post
            id={post.id}
            title={post.title}
            author={post.author}
            key = {post.id}
        />
    });
    return postList;
}

export default Posts;