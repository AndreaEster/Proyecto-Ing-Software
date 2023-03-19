import React from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFacebook, faInstagram } from "@fortawesome/free-brands-svg-icons";

function Footer() {
  return (
    <div className='footer'>
      <footer>
        <p className='Spamming'>Derechos reservados 2023</p>
        <h3 className='Sociales-titulo'>@SalonSmart</h3>
        <div className='Sociales'>
          <a className="facebook" href="https://www.facebook.com/Sal%C3%B3n-Gen%C3%A9rico-N28-117332477950345">
            <FontAwesomeIcon icon={faFacebook} size="2x"/></a>
          <a className="instagram" href="https://www.instagram.com/salon_generico_n_28/">
            <FontAwesomeIcon icon={faInstagram} size="2x"/>
          </a>
        </div>
      </footer>
    </div>
  );
}

export default Footer;