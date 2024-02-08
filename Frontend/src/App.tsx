import React from 'react';
import './App.scss';
import { Route, Routes } from 'react-router-dom';
import Home from './views/Home/Home';
import Footer from './components/Footer/Footer';
import Navbar from './components/Navbar/Navbar';
import ProfilePreview from './views/ProfilePreview/ProfilePreview';

function App() {
  return (
    <div className="App">
      <Navbar/>
      <Routes>
        <Route path="/" element={ <Home/> }/>
        <Route path="/profile" element={ <ProfilePreview/> }/>
      </Routes>
      <Footer/>
    </div>
  );
}

export default App;
