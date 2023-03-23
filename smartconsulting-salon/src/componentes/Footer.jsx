import React from 'react';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFacebook, faInstagram } from "@fortawesome/free-brands-svg-icons";
import { Container } from 'react-bootstrap';

function Footer() {
  return (
    <>
    <Container className="footer" fluid>
      <div>
        <footer>
          <h3>@SalonSmart</h3>
          <div className='Sociales'>
            <p>Tambien puede visitar nuestras redes sociales</p>
            <a className="facebook" href="https://www.facebook.com/Sal%C3%B3n-Gen%C3%A9rico-N28-117332477950345">
              <FontAwesomeIcon icon={faFacebook} size="2x" /></a>
            <a className="instagram" href="https://www.instagram.com/salon_generico_n_28/">
              <FontAwesomeIcon icon={faInstagram} size="2x" />
            </a>
            <p>Derechos reservados 2023</p>
          </div>
        </footer>
      </div>
    </Container>
    </>
  );
}

export default Footer;