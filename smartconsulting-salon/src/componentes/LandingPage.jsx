import React, { useState } from 'react';
import { Container, Navbar, Nav, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './LandingPage.css';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faFacebook, faInstagram } from "@fortawesome/free-brands-svg-icons";
import Carrusel from './Carrusel';
import Formulario from './Formulario';


function LandingPage() {
    const [show, setShow] = useState(false);

    return (
        <>
            <Navbar bg="light" expand="lg">
                <Container>
                    <Navbar.Brand href="#home">Salón Smart</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="ml-auto">
                            <Nav.Link href="#conectarse">Conectarse</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            <Container className="jumbotron" fluid>
                <Container>
                    <h1>Bienvenidos a nuestro Salón de Belleza</h1>
                    <p className='p-subt'>
                        Ofrecemos una amplia variedad de servicios para que te veas y te sientas mejor.
                    </p>
                </Container>
                <Container className='boton'>
                    <p>
                        <Button className='bot-boton' variant="primary" onClick={() => setShow(true)}>Haga su reservación AQUÍ</Button>
                    </p>
                    <Formulario
                        estado={show}
                        cambiar={() => setShow(false)}
                    />
                </Container>

            </Container>
            <Container fluid>
                <Carrusel />
            </Container>
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

export default LandingPage;
