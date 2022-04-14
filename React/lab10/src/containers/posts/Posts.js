
import { React, useEffect, useState } from "react";

import Post from "../../components/post/Post";

import axios from "axios";
import { Link } from "react-router-dom";
import PostDetails from "../../components/postDetails/PostDetails";

// props arry of post
const Posts = (props) => {

    const [posts, setPosts] = useState(
        [{}])

    const fetchPosts = () => {
        axios.get('http://localhost:8080/api/v1/posts')
            .then(response => {
                setPosts(response.data)

            })
            .catch(error => {
                console.log(error.message)
            })
    }
    useEffect(() => {
        fetchPosts();
    }, [])


    const postList = posts.map(post => {
        return (
            <Link to={`${post.id}`}  key={post.id} >
                <Post
                    id={post.id}
                    title={post.title}
                    author={post.author}
                  
                />
            </Link>
        )

    });
    return <div>{postList}
        <PostDetails />

    </div>
}

export default Posts;