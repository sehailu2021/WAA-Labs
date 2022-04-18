import logo from './logo.svg';
import './App.css';
import Dashboard from './pages/dashboard/Dashboard';
import { BrowserRouter } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
    <div className="App">
        <h1 className='h'> Waa Lab-10</h1>
        <Dashboard />
      
    </div>
    </BrowserRouter>
    
  );
}

export default App;
