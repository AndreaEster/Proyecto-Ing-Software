import React, { useState } from 'react';
import ReservacionFormulario from './ReservacionFormulario';

function App() {
  const [showPopup, setShowPopup] = useState(false);

  const handleOpenPopup = () => {
    setShowPopup(true);
  }

  const handleClosePopup = () => {
    setShowPopup(false);
  }

  return (
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
  );
}
