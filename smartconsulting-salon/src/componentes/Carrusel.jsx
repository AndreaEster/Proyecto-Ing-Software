import React, { useState, useEffect } from 'react';
import mysql from 'mysql2';
/*En Construccion */
function Carrusel() {
  const [images, setImages] = useState([]);

  useEffect(() => {
    const connection = mysql.createConnection({
      host: 'localhost',
      user: 'root',
      password: 'mypassword',
      database: 'mydatabase',
    });

    connection.query('SELECT * FROM images', (error, results) => {
      if (error) {
        throw error;
      }

      setImages(results);
    });

    connection.end();
  }, []);

  return (
    <div className="carrusel">
      {images.map((image) => (
        <img key={image.id} src={image.url} alt={image.alt} />
      ))}
    </div>
  );
}

export default Carrusel;