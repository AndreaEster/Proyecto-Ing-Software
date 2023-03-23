import React, { useState } from 'react';
import { Container, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './LandingPage.css';
import Carrusel from './Carrusel';
import Formulario from './Formulario';
import Header from './Header';
import Footer from './Footer';



function LandingPage() {
    const [show, setShow] = useState(false);
    return (
        <>
            <Header />
            <Container className="jumbotron" fluid>
                <Container>
                    <h1>Bienvenidos a nuestro Salón de Belleza</h1>
                    <p className='p-subt'>
                        Ofrecemos una amplia variedad de servicios para que te veas y te sientas mejor.
                    </p>
                </Container>
                <Container className='boton'>
                    <p>
                        <Button className='bot-boton' variant="primary" onClick={() => setShow(true)}> AQUÍ</Button>
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
            <Footer/>
        </>
    );
}

export default LandingPage;
