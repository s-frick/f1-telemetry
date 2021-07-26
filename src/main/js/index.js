const WebSocket = require('ws');
const fs = require('fs');

const ws = new WebSocket('ws://localhost:8080/');


let file = undefined;
ws.on('open', function open() {
    ws.send('MOTION');
    file = fs.createWriteStream('motion-data-txt');
});

ws.on('message', function incoming(msg) {
    // console.log(msg);
    file.write('\n');
    file.write(msg);
})

ws.on('error', function (err) {
    console.error(err)
})

ws.on('close', function () {
    file.end()
})
