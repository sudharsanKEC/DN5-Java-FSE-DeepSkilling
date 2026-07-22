import React, { useState } from "react";

import "./App.css";

import EmployeesList from "./EmployeesList";

import ThemeContext from "./ThemeContext";

function App() {

    const [theme, setTheme] = useState("light");

    const employees = [

        {
            id: 1,
            name: "John Smith",
            designation: "Software Engineer",
            department: "Development"
        },

        {
            id: 2,
            name: "Sarah Johnson",
            designation: "QA Engineer",
            department: "Testing"
        },

        {
            id: 3,
            name: "Michael Brown",
            designation: "Project Manager",
            department: "Management"
        }

    ];

    function toggleTheme() {

        setTheme(

            theme === "light"

                ? "dark"

                : "light"

        );

    }

    return (

        <ThemeContext.Provider value={theme}>

            <div className="App">

                <h1>

                    Employee Management

                </h1>

                <button onClick={toggleTheme}>

                    Toggle Theme

                </button>

                <EmployeesList

                    employees={employees}

                />

            </div>

        </ThemeContext.Provider>

    );

}

export default App;