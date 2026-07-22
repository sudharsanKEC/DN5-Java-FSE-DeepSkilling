import "./App.css";

import ListOfPlayers from "./ListOfPlayers";
import ScoreBelow70 from "./ScoreBelow70";

import {
    OddPlayers,
    EvenPlayers,
    IndianPlayers,
    ListOfIndianPlayers
} from "./IndianPlayers";

function App() {
    const players = [
        { name: "Jack", score: 50 },
        { name: "Michael", score: 70 },
        { name: "John", score: 40 },
        { name: "Ann", score: 61 },
        { name: "Elizabeth", score: 61 },
        { name: "Sachin", score: 95 },
        { name: "Dhoni", score: 100 },
        { name: "Virat", score: 84 },
        { name: "Jadeja", score: 64 },
        { name: "Raina", score: 75 },
        { name: "Rohit", score: 80 }
    ];
    const IndianTeam = [
        "Sachin",
        "Dhoni",
        "Virat",
        "Rohit",
        "Yuvraj",
        "Raina"
    ];
    const flag = false;
    if (flag === true) {
        return (
            <div className="App">
                <h1>List of Players</h1>
                <ListOfPlayers players={players} />
                <hr />
                <h1>List of Players having Scores Less than 70</h1>
                <ScoreBelow70 players={players} />
            </div>
        );
    }
    else {
        return (
            <div className="App">
                <h1>Odd Players</h1>
                <OddPlayers players={IndianTeam} />
                <hr />
                <h1>Even Players</h1>
                <EvenPlayers players={IndianTeam} />
                <hr />
                <h1>List of Indian Players Merged</h1>
                <ListOfIndianPlayers
                    IndianPlayers={IndianPlayers}
                />
            </div>
        );
    }
}

export default App;