import React from 'react';
import './App.scss';
import { Route, Routes } from 'react-router-dom';
import Home from './views/Home/Home';
import Footer from './components/Footer/Footer';
import Navbar from './components/Navbar/Navbar';
import ProfilePreview from './views/ProfilePreview/ProfilePreview';
import NotAuthorized from './views/NotAuthorized/NotAuthorized';
import LoginForm from './views/LoginForm/LoginForm';
import Register from './views/RegisterForm/Register';
{/*  
*
*  THE NAVBAR AND FOOTER WERE COMMENTED DURING THE PHASE OF MAKING THE LOGIN AND REGISTER FORMS.
*
*/}
function App() {
  return (
    <div className="App">
      <Navbar/>
      <Routes>
        <Route path="/" element={ <Home/> }/>
        <Route path="/profile" element={ <ProfilePreview/> }/>
        <Route path="/notAuthorized" element={ <NotAuthorized/> }/>
        <Route path="/login" element={ <LoginForm/> }/>
        <Route path="/register" element={ <Register/> }/>
      </Routes>
      <Footer/>
    </div>
  );
}

export default App;
