import React from "react";

class Counter extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 0
        };
    }
    increment = () => {
        this.setState({
            count: this.state.count + 1
        });
    }
    decrement = () => {
        this.setState({
            count: this.state.count - 1
        });
    }
    sayHello = () => {
        alert("Hello! Have a Nice Day.");
    }
    handleIncrement = () => {
        this.increment();
        this.sayHello();
    }
    sayWelcome = (message) => {
        alert(message);
    }
    onPress = () => {
        alert("I was clicked");
    }
    render() {
        return (
            <div>
                <h2>Counter : {this.state.count}</h2>
                <button onClick={this.handleIncrement}>
                    Increment
                </button>
                &nbsp;
                <button onClick={this.decrement}>
                    Decrement
                </button>
                <br /><br />
                <button
                    onClick={() =>
                        this.sayWelcome("Welcome")
                    }
                >
                    Say Welcome
                </button>
                <br /><br />
                <button onClick={this.onPress}>
                    Synthetic Event
                </button>
            </div>
        );
    }
}

export default Counter;