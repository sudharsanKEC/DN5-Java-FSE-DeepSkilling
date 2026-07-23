import "./App.css";
import officeImage from "./office.jpeg";

function App() {
    const officeSpaces = [
        {
            Name: "DBS",
            Rent: 50000,
            Address: "Chennai",
            Image: officeImage
        },
        {
            Name: "Regus",
            Rent: 65000,
            Address: "Bangalore",
            Image: officeImage
        },
        {
            Name: "WeWork",
            Rent: 80000,
            Address: "Hyderabad",
            Image: officeImage
        }
    ];
    return (
        <div className="App">
            <h1>Office Space, at Affordable Range</h1>
            {
                officeSpaces.map((office, index) => (
                    <div key={index} className="office-card">
                        <img
                            src={office.Image}
                            alt="Office Space"
                            width="250"
                            height="200"
                        />
                        <h2>Name: {office.Name}</h2>
                        <h3
                            style={{
                                color:
                                    office.Rent <= 60000
                                        ? "red"
                                        : "green"
                            }}
                        >
                            Rent Rs. {office.Rent}
                        </h3>
                        <h3>
                            Address: {office.Address}
                        </h3>
                    </div>
                ))
            }
        </div>
    );
}
export default App;