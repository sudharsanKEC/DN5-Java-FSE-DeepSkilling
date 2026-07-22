import React from "react";
import EmployeeCard from "./EmployeeCard";

function EmployeesList({ employees }) {

    return (

        <div>

            {

                employees.map(employee => (

                    <EmployeeCard

                        key={employee.id}

                        employee={employee}

                    />

                ))

            }

        </div>

    );

}

export default EmployeesList;