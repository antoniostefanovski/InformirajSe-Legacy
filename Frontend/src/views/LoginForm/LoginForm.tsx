import React from "react";
import "./LoginForm.scss";
import logo from '../../assets/login_logo.png';

export default function LoginForm(){
    return(
        <div className="login-background">
            <div className="main-content1">
                <img src={logo} className="login-logo"></img>
                {/* <h3 className="text">Внесете ги вашите податоци за пристап до вашиот профил.</h3> */}
                <form className="login-form">
                    <label className="username-label">Корисинчко име</label><br></br>
                    <input type="text" className="username-input"></input><br></br>
                    <label className="password-label">Лозинка</label><br></br>
                    <input type="text" className="password-input"></input><br></br>
                    <button type="submit" className="login-button">Најави се</button>
                </form>
            </div>
        </div>
        
    )
}