import React from "react";

class ComplaintRegister extends React.Component {

    constructor(props) {

        super(props);

        this.state = {

            employeeName: "",
            complaint: ""

        };

    }

    handleNameChange = (event) => {

        this.setState({

            employeeName: event.target.value

        });

    };

    handleComplaintChange = (event) => {

        this.setState({

            complaint: event.target.value

        });

    };

    handleSubmit = (event) => {

        event.preventDefault();

        const referenceNumber = Math.floor(
            100000 + Math.random() * 900000
        );

        alert(

            `Thanks ${this.state.employeeName}.\n\n` +
            `Your complaint has been submitted successfully.\n\n` +
            `Reference Number : ${referenceNumber}`

        );

        this.setState({

            employeeName: "",
            complaint: ""

        });

    };

    render() {

        return (

            <div className="container">

                <h1>Ticket Raising Application</h1>

                <form onSubmit={this.handleSubmit}>

                    <div>

                        <label>

                            Employee Name :

                        </label>

                        <br />

                        <input

                            type="text"

                            value={this.state.employeeName}

                            onChange={this.handleNameChange}

                            required

                        />

                    </div>

                    <br />

                    <div>

                        <label>

                            Complaint :

                        </label>

                        <br />

                        <textarea

                            rows="5"

                            cols="40"

                            value={this.state.complaint}

                            onChange={this.handleComplaintChange}

                            required

                        >

                        </textarea>

                    </div>

                    <br />

                    <button type="submit">

                        Submit

                    </button>

                </form>

            </div>

        );

    }

}

export default ComplaintRegister;