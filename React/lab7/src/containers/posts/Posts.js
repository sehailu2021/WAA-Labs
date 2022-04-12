import Post from "../../components/post/Post";


// props arry of post
const Posts= (props) => {
//  loop over every post and render it.
    const postList = props.posts.map(post => {
        return <Post
            id={post.id}
            title={post.title}
            author={post.author}
            // key = {post.id}

        />
    });
    // return all the post
    return postList;
}

export default Posts;