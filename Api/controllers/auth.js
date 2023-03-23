/*import { db } from "../db.js";

export const auth = (req, res) => {
    const q = "SELECT * FROM usuarios WHERE username = ? AND password = ?";
    const { username, password } = req.body
    const values = [username, password]
    db.query(q, values, (err, result) => {
        if (err) {
            res.status(500).send(err)
        } else {
            if (result.length > 0) {
                return res.status(200).send({
                    "id": result[0].id,
                    "username": result[0].username,
                })
            } else {
                return res.status(400).send('Usuario no Registrado en la base de datos, Contacte al administrador')
            };
        }
    })
}

*/