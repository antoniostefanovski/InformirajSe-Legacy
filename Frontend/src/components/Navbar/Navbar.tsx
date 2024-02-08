import React, { useState } from 'react'
import '../Navbar/Navbar.scss';
import { NavLink } from 'react-router-dom';
import logo from '../../assets/logo_2.png';
import search_icon from '../../assets/search_icon.png';
import menu_icon from '../../assets/menu_icon2.png';
import closed_menu from '../../assets/closed_menu.png';
import { Fade } from "react-awesome-reveal";

function Navbar() {

  const [menuIcon, setMenuIcon] = useState(false);
  const [searchIcon, setSearchIcon] = useState(false);

  const isMenuClicked = () => {
    setMenuIcon(!Boolean(menuIcon));
  }

  const isSearchIconClicked = () => {
    setSearchIcon(!Boolean(searchIcon));
  }

  return (
    <div>
        <div className="navbar-container">
            <div className="navbar-container-links">
              <div className='navbar-container-links-list'>
                <NavLink to="/" className={'navbar-container-links-list-item'}>Дома</NavLink>
                <NavLink to="/" className={'navbar-container-links-list-item'}>Блогови</NavLink>
                <NavLink to="/" className={'navbar-container-links-list-item'}>За нас</NavLink>
              </div>
            </div>
            <div className="navbar-container-logo">
              <img src={logo} alt="logo_informirajse" className="navbar-container-logo-img"/>
            </div>
            <div className="navbar-container-links2">
              <div className="navbar-container-links2-list">
                <NavLink to="/" className={'navbar-container-links2-list-item'}>Најава</NavLink>
                <NavLink to="/" className={'navbar-container-links2-list-item'}>Регистрација</NavLink>
                <p className={'navbar-container-links2-list-item'} onClick={isSearchIconClicked}><img src={search_icon} alt='search-icon'/></p>
              </div>
            </div>
            <div className="navbar-container-menu" onClick={isMenuClicked}>
              { !menuIcon ? <img src={menu_icon} alt='menu_icon'/> : <img src={closed_menu} alt='menu_icon'/>}
            </div>
        </div>
        { menuIcon && <div className="responsive-main">
          <div className='responsive-main-links-list'>
            <NavLink to="/" className={'responsive-main-links-list-item'}>Дома</NavLink>
            <NavLink to="/" className={'responsive-main-links-list-item'}>Блогови</NavLink>
            <NavLink to="/" className={'responsive-main-links-list-item'}>За нас</NavLink>
            <NavLink to="/" className={'responsive-main-links-list-item'}>Најава</NavLink>
            <NavLink to="/" className={'responsive-main-links-list-item'}>Регистрација</NavLink>
            <NavLink to="/" className={'responsive-main-links-list-item'}><img src={search_icon} alt='search-icon' onClick={isSearchIconClicked}/></NavLink>
          </div>
        </div> }
        { searchIcon && <div className="search-component">
          <div className="search-component-close" onClick={isSearchIconClicked}>
            <img src={closed_menu} alt='menu_icon'/>
          </div>
          <div className="search-component-searchbar">
            <p className="search-component-searchbar-title">Внесете клучен збор за пребарувањето</p>
            <input type="text" placeholder='Што ве интересира ?' className="search-component-searchbar-input"/>
          </div>
        </div> }
    </div>
  )
}

export default Navbar;