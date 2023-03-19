import React from 'react';
import Slider from 'react-slick';
import './Carrusel.css';


const Carrusel = ({ imagenes }) => {
  const settings = {
    dots: false,
    infinite: false,
    speed: 500,
    initialSlide: 0,
    slidesToShow: 1,
    slidesToScroll: 2,
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 3,
          infinite: true,
          dots: true
        }
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 2,
          initialSlide: 2
        }
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1
        }
      }
    ]
  };

  return (
    <div className="Carrusel">
      <Slider {...settings}>
        {imagenes.map((item) => (
            <div className="contenedor-imagenes" key={item.id}>
              <img src={item.url} alt={item.titulo} />
              <h1>{item.titulo}</h1>
            </div>
        ))}
      </Slider>
    </div>   
  );
};

export default Carrusel;
