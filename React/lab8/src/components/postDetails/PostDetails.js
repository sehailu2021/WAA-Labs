
import axios from "axios";
import React, { useEffect, useState } from "react"
import Comment from "../comment/Comment";

const PostDetails = (props) => {

    const [postDetail, setPostDetail] = useState({});
    const [commentDetail, setCommentDetail] = useState({});


    useEffect(
        () => {
            axios.get('http://localhost:8080/api/v1/posts/' + props.id)
                .then(response => {
                    setPostDetail(response.data)

                })
                .catch(error => console.log(error.message))

        }, [props.id]
    )

    useEffect(
        () => {
            axios.get('http://localhost:8080/api/v1/posts/' + props.id + "/comments")
                .then(response => {
                    setCommentDetail(response.data)

                })
                .catch(error => console.log(error.message))

        }, [props.id]
    )
    const deleteButtonClicked = (id) => {
        axios.delete('http://localhost:8080/api/v1/posts/' + id)
            .then(response => {
                props.changeFetchFlag();
            })

    }

    let postDetailsDisplay = null;
    if (props.id != 0) {
        postDetailsDisplay = (

            <div>
                <div>
                    Post Detail
                </div>
                <h2> {postDetail.title}</h2>
                <h2> {postDetail.author}</h2>
                <div>
                    Comments
                </div>
                <div>
                    {commentDetail.comments != null ? commentDetail.comments.map(comment => {
                        return (
                            <div>
                                <Comment name={comment.name} />
                            </div>)
                    }) : null}
                </div>


                <button onClick={() => { deleteButtonClicked(props.id) }}> Delete</button>
            </div>
        );
    }

    return postDetailsDisplay;
}

export default PostDetails
