import Content from "../content/Content";

const Post = (props) => {


    return (
        <a  onClick={Content}>
        <div className="Content">
            <div> {props.id}</div>
            <div className="Field">
                {props.title}</div>
            <div className="Field">
                {props.author}
            </div>
        </div>
        </a>
        
    );
}

export default Post;