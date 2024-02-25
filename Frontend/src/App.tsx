import React from 'react';
import './App.scss';
import { Route, Routes, useLocation } from 'react-router-dom';
import Home from './views/Home/Home';
import Footer from './components/Footer/Footer';
import Navbar from './components/Navbar/Navbar';
import ProfilePreview from './views/ProfilePreview/ProfilePreview';
import NotAuthorized from './views/NotAuthorized/NotAuthorized';
import LoginForm from './views/LoginForm/LoginForm';
import Register from './views/RegisterForm/Register';
import Blogs from './views/Blogs/Blogs';
import MostInterestingBlogs from './views/MostInterestingBlogs/MostInteresting';
import News from './views/News/News';
import RegistrationSuccess from './views/RegistrationSuccess/RegistrationSuccess';
import Login from './views/Login/Login';
import RegisterPage from './views/RegisterPage/RegisterPage';
{/*  
*
*  THE NAVBAR AND FOOTER WERE COMMENTED DURING THE PHASE OF MAKING THE LOGIN AND REGISTER FORMS.
*
*/}
function App() {
  const location = useLocation();
  return (
    <div className="App">
      { (location.pathname === "/login" || location.pathname === "/register" || location.pathname === "/successful-registration") ? "" : <Navbar/>}
      <Routes>
        <Route path="/" element={ <Home/> }/>
        <Route path="/profile" element={ <ProfilePreview/> }/>
        <Route path="/notAuthorized" element={ <NotAuthorized/> }/>
        <Route path="/login-page-old" element={ <LoginForm/> }/>
        <Route path="/login" element={ <Login/> }/>
        <Route path="/register-page-old" element={ <Register/> }/>
        <Route path="/register" element={ <RegisterPage/> }/>
        <Route path="/allblogs" element={ <Blogs/> }/>
        <Route path="/allblogs" element={ <Blogs/> }/>
        <Route path="/most-interesting" element={ <MostInterestingBlogs/> }/>
        <Route path="/news" element={ <News/> }/>
        <Route path="/successful-registration" element={ <RegistrationSuccess/> }/>
      </Routes>
      { (location.pathname === "/login" || location.pathname === "/register" || location.pathname === "/successful-registration") ? "" : <Footer/>}
    </div>
  );
}

export default App;
