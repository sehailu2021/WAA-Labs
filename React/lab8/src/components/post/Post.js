
import React from "react";

import Content from "../content/Content";

const Post = (props) => {

    return (
        
        <div className="Content" onClick={props.setSelected}>
            <div> {props.id}</div>
            <div className="Field">
                {props.title}</div>
            <div className="Field">
                {props.author}
            </div>
        </div>
    
        
    );
}

export default Post;