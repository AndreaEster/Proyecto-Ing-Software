import React, { useState, useEffect } from 'react';
import mysql from 'mysql2';
/*En Construccion */
function Carrusel() {
  const [images, setImages] = useState([]);

  useEffect(() => {
    const connection = mysql.createConnection({
      host: 'localhost',
      user: 'root',
      password: '',
      database: 'smartconsultingbd',
    });

    connection.connect();
    
    connection.query('SELECT * FROM imagenes', (error, results) => {
      if (error) {
        throw error;
      }

      setImages(results);
    });

    connection.end();
  }, []);

  return (
    <div className="carrusel">
      {images.map((imagenes) => (
        <img key={imagenes.id} src={imagenes.url} alt={imagenes.titulo} />
      ))}
    </div>
  );
}

export default Carrusel;