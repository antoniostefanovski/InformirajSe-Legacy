import React from "react";
import './BlogCart.scss';

interface BlogCart {
    naslov: string;
    slika: string;
    avtor: string;
    datum: string;
  }

const BlogCart: React.FC<BlogCart> = (props) =>{
    return(
        <div className="blogcart-main-content">
            <div className="blogcart-left-side">
                <img src={props.slika} className="blogcart-img"></img>
            </div>
            <div className="blogcart-right-side">
                <p className="cart-title">{props.naslov}</p>
                <p className="blog-cart-date">{props.datum}</p>
                <p className="blog-cart-author">Автор: {props.avtor}</p>
                <div className="blog-cart-div">
                    <button className="blog-cart-button">Прочитај повеќе</button>
                </div>
                
            </div>
            
        </div>
    )
}

export default BlogCart;