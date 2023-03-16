import './App.css';
import Footer from './componentes/Footer';
import Header from './componentes/Header';
import React, { useState } from 'react';
import ReservacionFormulario from './Andrea-/ReservacionFormulario';
import Carrusel from './componentes/Carrusel';


function App() {
  const [showPopup, setShowPopup] = useState(false);

  const handleOpenPopup = () => {
    setShowPopup(true);
  }

  const handleClosePopup = () => {
    setShowPopup(false);
  }
  
  return (
    <div className="App">
      <h1>
        Aqui se desarrollara el proceso de ensamblado
      </h1>
      <Header />
      <Carrusel />
      {showPopup ? (
        <div className="popup">
          <div className="popup-content">
            <button className="close" onClick={handleClosePopup}>X</button>
            <ReservacionFormulario />
          </div>
        </div>
      ) : (
        <div>
          <button onClick={handleOpenPopup}>Reservar cita</button>
        </div>
      )}
      <Footer />
    </div>
  );
}

export default App;
