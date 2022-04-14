import { Navigate, Route, Routes } from "react-router-dom";
import AddPost from "../../components/addPost/AddPost";
import PostDetails from "../../components/postDetails/PostDetails";
import Posts from "../../containers/posts/Posts";

const PageRoutes = () => {
    return (

        <Routes>
            <Route path="/" element = {<Navigate replace to = "posts"/>}/>
            <Route path="posts" element={<Posts />}>
                <Route path=":id" element={<PostDetails />}/>
            </Route>

            <Route path="create-post" element={<AddPost />}/>

        </Routes>
    )

}


export default PageRoutes; 