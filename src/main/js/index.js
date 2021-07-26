const WebSocket = require('ws');

const ws = new WebSocket('ws://localhost:8080/');

ws.on('open', function open() {
    ws.send('SESSION');
});

ws.on('message', function incoming(msg) {
    console.log(msg)
})

ws.on('error', function (err) {
    console.error(err)
})
