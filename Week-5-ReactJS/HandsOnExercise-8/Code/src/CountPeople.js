import React from "react";

class CountPeople extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            entrycount: 0,
            exitcount: 0
        };
    }
    updateEntry = () => {
        this.setState((prevState) => ({
            entrycount: prevState.entrycount + 1
        }));
    };
    updateExit = () => {
        this.setState((prevState) => ({
            exitcount: prevState.exitcount + 1
        }));
    };
    render() {
        return (
            <div className="container">
                <div className="box">
                    <button onClick={this.updateEntry}>
                       Login
                   </button>
                    <span>
                       {" "}
                        {this.state.entrycount} People Entered!!
                    </span>
                </div>
                <div className="box">
                    <button onClick={this.updateExit}>
                        Exit
                    </button>
                    <span>
                        {" "}
                        {this.state.exitcount} People Left!!
                    </span>
                </div>
            </div>
        );
    }
}

export default CountPeople;