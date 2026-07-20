import logo from './logo.svg';
import './App.css';
import { CalculateScore } from './Components/CalculatorScore';
function App() {
  return (
    <div>
      <CalculateScore Name={"Sudharsan"} 
      School={"Kongu National School"}
      total={284}
      goal={3}
      />
    </div>
  );
}

export default App;
