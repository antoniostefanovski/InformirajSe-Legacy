import React from "react";
import '../MostInterestingBlogs/MostInteresting.scss';
import BlogCart from "../BlogCart/BlogCart";


export default function MostInterestingBlogs(){
    return(
        <div className="most-interesting-blogs-main-content">
            <h1 className="most-interesting-blogs-title">Истражи</h1>
            <p className="most-interesting-blogs-main-text">
            Добредојдовте на страницата "Истражи" - вашиот пристап до најинтересните и најинтерактивни блогови во последниот период.
            Овде, вие ќе откриете бројни виртуелни приказни исцрпно истражувајќи ги најсовремените и највлијателни блогови од нашите писатели.
            Нашата заедница активно споделува идеи, статии и искуства, а на оваа страна, вие ќе најдете блогови кои го привлекле вниманието на
             голем дел од нашите корисници. Овде, ви обезбедуваме лесен преглед нa нај читаните блогови изминатиот период.
            </p>

            <div className="most-interesting-blogs-blog-section">
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
                 
                 <BlogCart 
                 slika="../../assets/action_icon.png"
                 naslov="BlogTitleBlogTitleBlogTitle BlogTitle BlogTitleBlogTitleBlogTitle BlogTitleBlogTitle BlogTitleBlogTitleBlogTitle"
                 avtor="Unknown Unknown"
                 datum="14.02.2024"/>
            </div>
        </div>
    )
}