/*
import React from 'react';
import { Button, Form, Modal } from 'react-bootstrap';
import "./Formulario.css"
const Formulario = (props) => {

    return (
        <>
            <Modal show={props.estado}>
                <Modal.Header closeButton>
                    <Modal.Title>Registre su reservación</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                            <Form.Label className='Labeled-mod'>Email address</Form.Label>
                            <Form.Control
                                type="email"
                                placeholder="name@example.com"
                                autoFocus
                            />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={props.cambiar}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={props.cambiar}>
                        Save Changes
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}

*/

import React, { useState } from 'react';
import { Button, Form, Modal } from 'react-bootstrap';
import './Formulario.css';

const Formulario = (props) => {
    const [email, setEmail] = useState('');
    const [firstName, setFirstName] = useState('');
    const [lastName, setLastName] = useState('');
    const [date, setDate] = useState('');
    const [time, setTime] = useState('');

    const handleEmailChange = (e) => setEmail(e.target.value);
    const handleFirstNameChange = (e) => setFirstName(e.target.value);
    const handleLastNameChange = (e) => setLastName(e.target.value);
    const handleDateChange = (e) => setDate(e.target.value);
    const handleTimeChange = (e) => setTime(e.target.value);

    const handleSubmit = (e) => {
        e.preventDefault();
        // TODO: validate the form fields and submit the form data to the backend
    };

    return (
        <>
            <Modal show={props.estado}>
                <Modal.Header onClick={props.cambiar}>
                    <Modal.Title>Registre su reservación</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form onSubmit={handleSubmit}>
                        <Form.Group className="mb-3" controlId="formFirstName">
                            <Form.Label className='Labeled-mod'>Nombre</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese su nombre"
                                value={firstName}
                                onChange={handleFirstNameChange}
                                required
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formLastName">
                            <Form.Label className='Labeled-mod'>Apellido</Form.Label>
                            <Form.Control
                                type="text"
                                placeholder="Ingrese su apellido"
                                value={lastName}
                                onChange={handleLastNameChange}
                                required
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formEmail">
                            <Form.Label className='Labeled-mod'>Email</Form.Label>
                            <Form.Control
                                type="email"
                                placeholder="Ingrese su correo electrónico"
                                value={email}
                                onChange={handleEmailChange}
                                required
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formDate">
                            <Form.Label className='Labeled-mod'>Fecha de reserva</Form.Label>
                            <Form.Control
                                type="date"
                                placeholder="Seleccione la fecha de reserva"
                                value={date}
                                onChange={handleDateChange}
                                required
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="formTime">
                            <Form.Label className='Labeled-mod'>Hora de reserva</Form.Label>
                            <Form.Control
                                type="time"
                                placeholder="Seleccione la hora de reserva"
                                value={time}
                                onChange={handleTimeChange}
                                required
                            />
                        </Form.Group>
                        <Modal.Footer>
                            <Button variant="primary" type="submit">
                                Guardar cambios
                            </Button>
                        </Modal.Footer>
                    </Form>
                </Modal.Body>
            </Modal>
        </>
    );
}

export default Formulario;