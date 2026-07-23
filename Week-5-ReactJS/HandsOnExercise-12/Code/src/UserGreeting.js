import React from "react";

function UserGreeting() {
    return (
        <div>
            <h1>Welcome back</h1>
            <h3>Available Flights</h3>
            <ul>
                <li>Chennai → Bangalore</li>
                <li>Delhi → Mumbai</li>
                <li>Kochi → Hyderabad</li>
            </ul>
            <button>
                Book Ticket
            </button>
        </div>
    );
}

export default UserGreeting;