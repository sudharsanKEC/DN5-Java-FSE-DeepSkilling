import "./App.css";

import Counter from "./Counter.js";
import CurrencyConvertor from "./CurrencyConvertor.js";

function App() {
    return (
        <div className="App">
            <h1>React Event Examples</h1>
            <Counter />
            <hr />
            <CurrencyConvertor />
        </div>
    );
}

export default App;