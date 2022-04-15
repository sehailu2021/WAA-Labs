
import React, { useContext } from "react";
import { Selected } from "../../store/Selected";

import Content from "../content/Content";

const Post = (props) => {
    const setSelected = useContext(Selected)
    return (
        
        <div className="Content" onClick={()=>{setSelected(props.id)}}>
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