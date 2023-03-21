import React from 'react';
import {Button,Form, Modal} from 'react-bootstrap';
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

export default Formulario;