import Login from './components/Login/Login';
import Landing from './components/Landing/Landing';
import Signup from './components/Signup/Signup';
import './App.css';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Landing/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/signup' element={<Signup/>}/>

      </Routes>
    </div>
  );
}

export default App;
