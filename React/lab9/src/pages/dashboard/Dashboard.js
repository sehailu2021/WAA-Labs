
import React, { useEffect, useState } from "react";
import AddPost from "../../components/addPost/AddPost";
import PostDetails from "../../components/postDetails/PostDetails";
import Posts from "../../containers/posts/Posts";
import { Selected } from "../../store/Selected";
import { ThemeColor } from "../../store/ThemeColor";

const Dashboard = () => {
    const [themeColorState, setThemeColorState] = useState({ color: "red" })
    const [selectedState, setSelectedState] = useState(0);

    const [fetchFlag, setFetchflag] = useState(true);

    const changeFetchFlag = () => {
        setFetchflag(!fetchFlag);
    }
    const setSelected = (id) => {
        setSelectedState(id);

    }

    const setThemeColor = () => {
        if (themeColorState.color === "red") {
            setThemeColorState({ color: "blue" });
        }
        else {
            setThemeColorState({ color: "red" });
        }
    }

    useEffect(() => {
        return () => {
            console.log("Something was unmounted");
        };
    }, [fetchFlag]);

    return (


        <div>

            <ThemeColor.Provider value={setThemeColor}>
                <Selected.Provider value={setSelected}>
                    <div className="dashboard">
                        <Posts
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
                </Selected.Provider>
            </ThemeColor.Provider>


        </div>
    );
}

export default Dashboard;