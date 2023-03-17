import React from 'react';
import Slider from 'react-slick';
import './Carrusel.css';
const Carrusel = ({ imagenes }) => {
  const settings = {
    dots: false,
    infinite: true,
    speed: 500,
    slidesToShow: 3,
    slidesToScroll: 1,
    autoplay: true,
    autoplaySpeed: 3000,
  };

  return (
    <Slider className='Carro'{...settings}>
      {imagenes.map((imagen) => (
        <div key={imagen.id}>
          <img src={imagen.url} alt={imagen.titulo} />
        </div>
      ))}
    </Slider>
  );
};

export default Carrusel;
