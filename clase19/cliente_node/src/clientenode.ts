var fs = require('fs');
import {http} from 'follow-redirects'
const qs = require('querystring');

let obtenerAlumnos = ():Promise<any> => {
    return new Promise((resolve, reject) => {
        var options = {
          'method': 'GET',
          'hostname': 'localhost',
          'port': 8080,
          'path': '/inventar',
          'headers': {
            'Content-Type': 'application/html',
            'x-token': 'pepaPig'
          },
          'maxRedirects': 20
        };
        
        var req = http.request(options, (res) => {
          let chunks:Array<any> = [];
        
          res.on("data", (chunk) => {
            chunks.push(chunk);
          });
        
          res.on("end", function (chunk) {
            var body = Buffer.concat(chunks)
            resolve(body.toString())
          });
        
          res.on("error", function (error) {
            console.error(error);
            reject(error)
          });
        });
        
        req.end();
    })
}

obtenerAlumnos()
.then(z => JSON.parse(z))
.then(z => console.log(z))

