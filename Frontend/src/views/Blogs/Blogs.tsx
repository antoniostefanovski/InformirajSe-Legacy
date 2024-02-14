import React from "react";
import './Blogs.scss';
import { IoMdSearch } from "react-icons/io";
import BlogCart from "../BlogCart/BlogCart";
import slika from '../../assets/blog-img.jpg';


export default function Blogs(){
    return(
        <div className="blogs-main-content">
            <p className="blogs-first-text">Тука можете да ги пронејдете сите блогови напишани од страна на нашите корисници.
             Исто така можете да направите пребарување според клучен збор и подредување според датум на објава.</p>
            <form className="blogs-search-bar">
                <div className="blogs-search-bar-div">
                    <input type="text" placeholder="Што би сакале да читате?" name="search" className="blogs-searchbar"></input>
                    <button type="submit" className="blogs-search-button"><IoMdSearch /></button>
                </div>
                <select className="blogs-datelist">
                    <option>Датум...</option>
                    <option>Растечки</option>
                    <option>Опаѓачки</option>
                </select>
            </form>

            <div className="blogs-blog-section">
                <BlogCart 
                 slika="../../assets/action_icon.png"
                 naslov="BlogTitleBlogTitleBlogTitle BlogTitle BlogTitleBlogTitleBlogTitle BlogTitleBlogTitle BlogTitleBlogTitleBlogTitle"
                 avtor="Unknown Unknown"
                 datum="14.02.2024"/>

                <BlogCart 
                 slika="../../assets/action_icon.png"
                 naslov="BlogTitleBlogTitleBlogTitle BlogTitle BlogTitleBlogTitleBlogTitle BlogTitleBlogTitle BlogTitleBlogTitleBlogTitle"
                 avtor="Unknown Unknown"
                 datum="14.02.2024"/>


                <BlogCart 
                 slika="../../assets/action_icon.png"
                 naslov="BlogTitleBlogTitleBlogTitle BlogTitle BlogTitleBlogTitleBlogTitle BlogTitleBlogTitle BlogTitleBlogTitleBlogTitle"
                 avtor="Unknown Unknown"
                 datum="14.02.2024"/>

                <BlogCart 
                 slika="../../assets/action_icon.png"
                 naslov="BlogTitleBlogTitleBlogTitle BlogTitle BlogTitleBlogTitleBlogTitle BlogTitleBlogTitle BlogTitleBlogTitleBlogTitle"
                 avtor="Unknown Unknown"
                 datum="14.02.2024"/>
                 
            </div>
        </div>
    )
}