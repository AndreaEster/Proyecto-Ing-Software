const express = require('express')
const app = express();
const mysql = require('mysql2');

const connection = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'smartconsultingbd',
})
app.get("/",(req,res)=>{
    res.send("Funciono? verdad");
});

app.listen(3001, () =>{
    console.log("running");
})