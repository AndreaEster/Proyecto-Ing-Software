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
          <a className="facebook" href>
            <FontAwesomeIcon icon={faFacebook} size="2x"/></a>
          <a className="instagram" href>
            <FontAwesomeIcon icon={faInstagram} size="2x"/>
          </a>
        </div>
      </footer>
    </div>
  );
}

export default Footer;