import React from 'react';
import Slider from 'react-slick';
import './Carrusel.css';


const Carrusel = ({ imagenes }) => {
  const settings = {
    dots: false,
    infinite: false,
    speed: 500,
    slidesToShow: 1,
    slidesToScroll: 1,

  };

  return (
    <div className="Carrusel">
    <Slider className='Carro'{...settings}>
      {imagenes.map((imagen) => (
          <div key={imagen.id}>
            <img src={imagen.url} alt={imagen.titulo} />
            <h1>{imagen.titulo}</h1>
          </div>
      ))}
    </Slider>
    </div>   
  );
};

export default Carrusel;
