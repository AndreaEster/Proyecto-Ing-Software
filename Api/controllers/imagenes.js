import { db } from "../db.js";

export const obtenerImagenes = (req,res)=>{
    const q ="SELECT * FROM imagenes"
    db.query(q, (err, rows) => {
        if (err) {
            console.error('Error al obtener las imágenes: ', err);
            return res.status(500).json({ error: 'Error al obtener las imágenes' });
        }
                
        return res.json(rows);
    });

}