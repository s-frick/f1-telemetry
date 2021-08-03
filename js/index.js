const WebSocket = require('ws');
const fs = require('fs');

const types = ["motion", "session", "lap", "event", "participants", "car_setup", "car_telemetry", "car_status", "final_classification", "lobby_info", "car_damage", "session_history"]
const webSockets = Object.fromEntries(types.map(type => [type, new WebSocket(`ws://localhost:8080/${type}`)]))

const files = Object.fromEntries(Object.entries(webSockets).map(([key, val]) => [key, fs.createWriteStream(`./data/${key}`)]))

function incoming(file, msg) {
    console.log(msg);
    file.write(',\n');
    file.write(msg);
}

Object.entries(webSockets).forEach(([key, webSocket]) => {
    webSocket.on('open', () => console.log(`open websocket ${key}`))
    webSocket.on('message', msg => incoming(files[key], msg));
    webSocket.on('error', err => console.error(err));
    webSocket.on('close', () => files[key].end());
})
