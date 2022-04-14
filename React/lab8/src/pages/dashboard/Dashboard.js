
import React, { useEffect, useState } from "react";
import AddPost from "../../components/addPost/AddPost";
import Comment from "../../components/comment/Comment";
import PostDetails from "../../components/postDetails/PostDetails";
import Posts from "../../containers/posts/Posts";

const Dashboard = () => {
   
    const [selectedState, setSelectedState] = useState(0);

    const [fetchFlag, setFetchflag] = useState(true);

    const changeFetchFlag = () => {
        setFetchflag(!fetchFlag);
    }
    const setSelected = (id) => {
        setSelectedState(id);

    }

    useEffect(() => {
        return () => {
            console.log("Something was unmounted");
        };
    }, [fetchFlag]);

    return (
        <div>
            <div className="dashboard">
                <Posts setSelected={setSelected}
                    fetchFlag={fetchFlag}   
                />
            </div>

            <div>
                <PostDetails id={selectedState}
                    changeFetchFlag={changeFetchFlag} 
                    />
            </div>

            <div>
                <AddPost changeFetchFlag={changeFetchFlag} />

            </div>

        </div>
    );
} 

export default Dashboard;