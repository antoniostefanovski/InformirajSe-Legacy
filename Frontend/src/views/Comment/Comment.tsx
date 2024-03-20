import React from "react";
import '../Comment/Comment.scss';
import { SlUserFemale } from "react-icons/sl";


{/* 
FOR MALE USERS THIS WILL BE USED WITH CONDITIONAL RENDERING

import { GrUserManager } from "react-icons/gr";
< GrUserManager/>
*/}


export default function Comment(){
    return(
        <div className="comment-main">
            <div className="comment-left">
                <SlUserFemale />
            </div>
            <div className="comment-right">
                <p className="comment-author-name">Auhtor1 Author1</p><br></br>
                <p className="comment-text">This is a test comment.</p>
            </div>
        </div>
    )
}