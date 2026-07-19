import logo from './logo.svg';
import './App.css';
import { Home } from './component/Home';
import { Contact } from './component/Contact';
import { About } from './component/About';

function App() {
  return (
    <div className="container">
      <Home />
      <Contact />
      <About />
    </div>
  );
}

export default App;
