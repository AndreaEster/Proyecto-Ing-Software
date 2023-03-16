import React, { useState } from 'react';

function ReservacionFormulario(props) {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [date, setDate] = useState('');
  const [time, setTime] = useState('');
  const [services, setServices] = useState('');

  const handleSubmit = (event) => {
    event.preventDefault();
    // Aquí puedes enviar los datos del formulario a través de una API o correo electrónico.
    // También puedes resetear los valores de los estados de los inputs.
  }

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="name">Nombre completo:</label>
      <input type="text" id="name" value={name} onChange={(e) => setName(e.target.value)} />

      <label htmlFor="email">Correo electrónico:</label>
      <input type="email" id="email" value={email} onChange={(e) => setEmail(e.target.value)} />

      <label htmlFor="phone">Teléfono:</label>
      <input type="tel" id="phone" value={phone} onChange={(e) => setPhone(e.target.value)} />

      <label htmlFor="date">Fecha deseada de la cita:</label>
      <input type="date" id="date" value={date} onChange={(e) => setDate(e.target.value)} />

      <label htmlFor="time">Hora deseada de la cita:</label>
      <input type="time" id="time" value={time} onChange={(e) => setTime(e.target.value)} />

      <label htmlFor="services">Servicios solicitados:</label>
      <input type="text" id="services" value={services} onChange={(e) => setServices(e.target.value)} />

      <button className="Submiting" type="submit">Reservar cita</button>
    </form>
  );
}

export default ReservacionFormulario;