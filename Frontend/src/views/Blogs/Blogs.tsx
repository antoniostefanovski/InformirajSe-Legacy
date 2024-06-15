import React from "react";
import './Blogs.scss';
import { IoMdSearch } from "react-icons/io";
import BlogCart from "../BlogCart/BlogCart";
import slika from '../../assets/blog-img.jpg';
import { useState } from 'react';



export default function Blogs(){

    {/**
    *
    *
    * TREBA DA SE NAPRAVI NAPISHE KOD KOJ KE GI ISPRAKJA PODATOCITE NA BACKEND NA KLASATA BlogSearchClass
    * 
    */}

    return(
        <div className="blogs-main-content">
            <p className="blogs-first-text">Тука можете да ги пронејдете сите блогови напишани од страна на нашите корисници.
             Исто така можете да направите пребарување според клучен збор и подредување според датум на објава.</p>
            {/*<form className="blogs-search-bar">
                <div className="container">
                    <div className="blogs-search-bar-div">
                        <input type="text" placeholder="Што би сакале да читате?" name="search" className="blogs-searchbar"></input>
                        <button type="submit" className="blogs-search-button"><IoMdSearch /></button>
                    </div>
                    <select className="blogs-datelist">
                        <option>Датум...</option>
                        <option value="rastecki">Растечки</option>
                        <option value="opagacki">Опаѓачки</option>
                    </select>
                </div>
                <div className="container d-flex justify-content-between">
                    <input type="date" placeholder="Датум од"></input>
                    <input type="date" placeholder="Датум до"></input>
                    <input type="text" placeholder="Автор"></input>
                </div>
                
            </form>*/}
            <form>
                <div className="container border mt-4" style={{marginLeft:'auto', marginRight:'auto', width: '75%', height: '150px', marginTop:'75px', border:'solid', borderColor:'#6633FF', borderWidth:'4px', borderRadius:'25px'}}>
                    <div className="d-flex justify-content-between align-items-center" style={{ padding: '10px'}}>
                        <input type="text" placeholder="Што би сакале да читате?" name="search" className="blogs-searchbar" style={{flex: 1, marginRight: '10px'}} />
                        <input type="text" placeholder="Автор" className="blogs-searchbar" style={{flex: 1, marginRight: '10px'}} />
                        <select className="blogs-datelist" style={{flex: 1}}>
                            <option>Датум...</option>
                            <option value="rastecki">Растечки</option>
                            <option value="opagacki">Опаѓачки</option>
                        </select>
                    </div>
                    <div className="d-inline-flex justify-content-between align-items-center" style={{width:'100%', marginTop:'25px'}}>
                            <input type="date" placeholder="Датум од" className="blogs-searchbar" style={{marginRight:'5%'}}/>
                            <input type="date" placeholder="Датум до" className="blogs-searchbar" style={{marginRight:'12%'}}/>
                            <button type="submit" className="btn blogs-search-button " style={{}}>Пребарај</button>
                    </div>
                </div>
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