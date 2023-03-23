import './App.css';
import React from 'react';
import LandingPage from './componentes/LandingPage';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './componentes/Login';


function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/">
            <Route index element={<LandingPage />} />
            <Route path="/login" element={<Login />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
