import React, { useState, useEffect } from "react";
import "./Carrusel.css";
import { Card, Carousel } from "react-bootstrap"
import 'bootstrap/dist/css/bootstrap.min.css';

const Carrusel = () => {
  const [imagenes, setImagenes] = useState([]);

  useEffect(() => {
    const fetchImagenes = async () => {
      const res = await fetch('http://localhost:3001/api/imagenes/imagenes');
      const data = await res.json();
      setImagenes(data);
    };

    fetchImagenes();
  }, []);

  return (
    <Carousel>
      {imagenes.map((imagen) => (
        <Carousel.Item key={imagen.id}>
          <Card.Body className='card-body'>
            <img className="d-row w-10" src={imagen.url} alt={imagen.titulo} />
            <Card.Title className='carrusel-container-Title w-10' >{imagen.titulo}</Card.Title>
            <Card.Text className="d-row w-10">Bienvenidos a nuestro salón de belleza. Ofrecemos servicios de calidad a precios accesibles.</Card.Text>
          </Card.Body>
        </Carousel.Item>
      ))}
    </Carousel>
  );
}



export default Carrusel;
