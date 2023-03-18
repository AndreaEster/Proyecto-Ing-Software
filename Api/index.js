import express from 'express';
import imagenesRoute from "./routes/imagenes.js";
import cors from "cors"

const app = express();
app.use(cors());
app.use(express.json())
app.use("/api/imagenes",imagenesRoute)

app.listen(3001, () => {
  console.log('Servidor escuchando en el puerto 3001');
});
