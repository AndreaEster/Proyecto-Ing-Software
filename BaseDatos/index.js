const express = require('express');
const mysql = require('mysql2');
const cors = require('cors');
const app = express();

app.use(express.json())
app.use(cors());

const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '123Qweasd',
  database: 'smartconsultingbd'
});

app.get('/imagenes', (req, res) => {
  connection.query('SELECT * FROM imagenes', (err, rows) => {
    if (err) {
      console.error('Error al obtener las imágenes: ', err);
      res.status(500).json({ error: 'Error al obtener las imágenes' });
      return;
    }

    res.json(rows);
  });
});

app.listen(3001, () => {
  console.log('Servidor escuchando en el puerto 3001');
});
