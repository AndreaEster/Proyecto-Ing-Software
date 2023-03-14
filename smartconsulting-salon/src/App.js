import './App.css';
import Footer from './componentes/Footer';
import Header from './componentes/Header';
import React, { useState } from 'react';
import ReservacionFormulario from './Andrea-/ReservacionFormulario';


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
      <div>
      <button onClick={handleOpenPopup}>Reservar cita</button>
      {showPopup && (
        <div className="popup">
          <div className="popup-content">
            <button className="close" onClick={handleClosePopup}>X</button>
            <ReservacionFormulario />
          </div>
        </div>
      )}
      </div>      
        <Footer />
      </div>
  );
}

export default App;
