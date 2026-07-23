import React from "react";

function ScoreBelow70({ players }) {
    const players70 = players.filter(player => player.score < 70);
    return (
        <div>
            {
                players70.map((item, index) => (
                    <li key={index}>
                        Mr. {item.name} <span>{item.score}</span>
                    </li>
                ))
            }
        </div>
    );
}

export default ScoreBelow70;