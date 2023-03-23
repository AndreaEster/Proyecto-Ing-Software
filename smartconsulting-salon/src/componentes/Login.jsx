import React, { useState } from 'react';
import Header from './Header';
import Footer from './Footer';

const Login = (props) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');


  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  const handleSubmit = (event) => {
    fetch('http://localhost:3001/api/login', {
      method: 'POST',
      body: JSON.stringify({ username, password }),
      headers: {
        'Content-Type': 'application/json'
      }
    })
      .then(response => {
        if (response.status === 200) {
          // Redirigir al usuario a la página principal
          window.location.href = '/';
        } else {
          setError('Nombre de usuario o contraseña incorrectos');
        }
      })
      .catch(error => {
        console.error('Error al iniciar sesión:', error);
        setError('Se produjo un error al intentar iniciar sesión. Por favor, inténtelo de nuevo más tarde.');
      });
  };

  return (
    <>
    <Header />
    <div show={props.estado}>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="username">Nombre de usuario:</label>
          <input type="text" id="username" value={username} onChange={handleUsernameChange} required />
        </div>
        <div>
          <label htmlFor="password">Contraseña:</label>
          <input type="password" id="password" value={password} onChange={handlePasswordChange} required />
        </div>
        <div>
          <button type="submit">Iniciar sesión</button>
        </div>
        {error && (
          <div>
            {error}
          </div>
        )}
      </form>
    </div>
    <Footer/>
    </>
  );
};

export default Login;
