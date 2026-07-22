import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard({ employee }) {

    const theme = useContext(ThemeContext);

    return (

        <div className="card">

            <h2>{employee.name}</h2>

            <h4>{employee.designation}</h4>

            <p>{employee.department}</p>

            <button className={theme}>

                View Profile

            </button>

        </div>

    );

}

export default EmployeeCard;