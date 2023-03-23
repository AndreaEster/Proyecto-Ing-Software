import './Header.css';
import React from 'react';

import { Container, Navbar, Nav } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

function Header(props) {
  let navigate = useNavigate();
  const routeLogin = () => {
    let login = '/login';
    navigate(login);
  }

  const routeHome = () => {
    let home = '/'
    navigate(home);
  }

  return (
    <Navbar bg="light" expand="lg">
      <Container>
        <Navbar.Brand onClick={routeHome}>Salón Smart</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ml-auto">
            <Nav.Link onClick={routeLogin}>Conectarse</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default Header;