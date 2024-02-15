import React from "react";
import './Register.scss';
import logo from '../../assets/login_logo.png';

export default function Register() {
    return (
        <div className="register-form-main-content">
            <div className="register-main-content-second">
                <img src={logo} className="register-form-logo"></img>
                    <form className="register-form">
                        <div className="register-form-left">
                            <label className="register-name-label">Име*</label><br></br>
                            <input type="text" className="register-name-input"></input><br></br>
                            <label className="register-surname-label">Презиме*</label><br></br>
                            <input type="text" className="register-surname-input"></input><br></br>
                            <label className="register-date-label">Датум на раѓање*</label><br></br>
                            <input type="date" className="register-date-input"></input><br></br>
                            <label className="register-gender-label">Пол*</label><br></br>
                            <select className="register-gender-list">
                                <option value="">Изберете...</option>
                                <option value="male">Машки</option>
                                <option value="female">Женски</option>
                            </select>
                        </div>
                        <div className="register-form-right">
                            <label className="register-email-label">E-mail адреса*</label><br></br>
                            <input type="text" className="register-email-input"></input><br></br>
                            <label className="register-pw-label">Лозинка*</label><br></br>
                            <input type="text" className="register-pw-input"></input><br></br>
                            <label className="register-pw-repeat-label">Потврдете ја лозинката*</label><br></br>
                            <input type="text" className="register-pw-repeat-input"></input><br></br>
                            <button type="submit" className="register-submit-btn">Регистрирај ме</button> 
                        </div>
                    </form>
            </div>
        </div>
        
    )
}