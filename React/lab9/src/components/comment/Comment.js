import React, {useContext} from 'react';

const Comment =(props) => {
    const colorContext = useContext(ThemeColorContext);
    return (
       
        <div style={{color:colorContext.color}}className='Comment'>
            {props.name}
        
        </div>

    );
}

export default Comment;