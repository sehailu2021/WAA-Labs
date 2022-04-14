import axios from "axios";
import React, { useRef } from "react";

const AddPost = (props)=>{
    const newPostForm = useRef();

    const addButtonClicked = ()=>{
        const form = newPostForm.current;
        const data = {
            title: form['title'].value,
            author: form['author'].value,
            content: form['content'].value
        }
        axios.post('http://localhost:8080/api/v1/posts', data)
        .then(response =>{
            props.changeFetchFlag();
        })
        .catch()
    }
    return(
        <div>
            <form ref={newPostForm}>
                <h2> Add post</h2>

                <label>title</label>
                <input type="text" label={'title'}  name={'title'} />

                <label>author</label>
                <input type="text" label={'author'} name={'author'} />

                <label>content</label>
                <input type="text" label={'content'} name={'content'} />
            </form>

            <button onClick={addButtonClicked} > Add Post</button>
        </div>
    );

}

export default AddPost;