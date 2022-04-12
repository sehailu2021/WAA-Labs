
import React, { useEffect, useState } from "react";
import Content from "../../components/content/Content";
import Posts from "../../containers/posts/Posts";

function Dashboard(){

      const [selectedState, setSelectedState] = useState(0)
    const [posts,setPosts ] = useState(
       [ { id: 111, title: "Happiness", author: "jhon" },
        { id: 112, title: "MIU ", author: "dean" },
        { id: 113, title: "Enjoy", author: "jasmine" }
    ])
   const setSelectedState ={id}=> {
       setSelectedState=id;
   }

    return (
     <>
       <div className="Post">
          <Posts posts={posts} />
       </div> 

       
       <div>
           <label></label>
       <button>Change Name</button>
       <div>
           {/* <Content /> */}
       </div>
       </div>
       
    
    </>
    );
    
}

export default Dashboard;