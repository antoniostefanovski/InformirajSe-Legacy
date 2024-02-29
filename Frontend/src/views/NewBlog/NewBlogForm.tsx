import React from "react";
import '../NewBlog/NewBlog.scss';

export default function NewBlog(){
    return(
        <div className="new-blog-main-content">
            <h1 className="main-title">Споделете нов блог со нашата заедница!</h1>
            <div className="new-blog-form">
                <div className="tmp">
                    <h3 className="new-blog-label">Наслов*</h3><br></br>
                    <input type="text" className="new-blog-title-input"></input><br></br><br></br><br></br><br></br><br></br>
                </div>
                <div className="tmp">
                    <h3 className="new-blog-label">Краток опис*</h3><br></br>
                    <input type="text" className="new-blog-title-summary"></input><br></br><br></br><br></br><br></br><br></br>
                </div>
                <div className="tmp">
                  <h3 className="new-blog-label">Вашиот текст*</h3><br></br>
                    <textarea className="new-blog-content-input" id="blog-content" name="blog-content"></textarea><br></br><br></br>   <br></br><br></br>  
                </div>
                
                <button type="submit" className="new-blog-submit">Сподели!</button>
            </div>
        </div>
    )
}