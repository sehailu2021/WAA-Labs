import React from "react";
import Headers from "../../containers/Header/Header";

import PageRoutes from "./PageRoutes";

const Dashboard = () => {
    return (

        <React.Fragment>
            <div>
                <Headers/>
            </div>

            <div>
                <PageRoutes />

            </div>
        </React.Fragment>
    )


}

export default Dashboard;