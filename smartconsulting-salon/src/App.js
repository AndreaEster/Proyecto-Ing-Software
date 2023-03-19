import './App.css';
import Footer from './componentes/Footer';
import Header from './componentes/Header';
import React, { useState, useEffect } from 'react';
import ReservacionFormulario from './Andrea-/ReservacionFormulario';
import Carrusel from './componentes/Carrusel';


function App() {

  const [imagenes, setImagenes] = useState([]);

  useEffect(() => {
    fetch('http://localhost:3001/api/imagenes/imagenes')
      .then((response) => response.json())
      .then((data) => setImagenes(data))
      .catch((error) => console.log(error));
  }, []);
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
      
      <Carrusel imagenes />
      <Footer fixed="bottom"/>
    </div>
  );
}

export default App;
