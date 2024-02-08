import React from 'react';
import './App.scss';
import { Route, Routes } from 'react-router-dom';
import Home from './views/Home';
import Footer from './components/Footer/Footer';
import Navbar from './components/Navbar/Navbar';

function App() {
  return (
    <div className="App">
      <Navbar/>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <h1>Hello world</h1>
      <Routes>
        {/* <Route path="/" element={ <Home/> }/> */}
        {/* <Route path="/" element={ <Footer/> }/> */}
      </Routes>
      <Footer/>
    </div>
  );
}

export default App;
