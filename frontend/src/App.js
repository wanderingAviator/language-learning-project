import Login from './components/Login/Login';
import Landing from './components/Landing/Landing';
import Signup from './components/Signup/Signup';
import Main from './components/Mainpage/MainPage';
import Matching from './components/Matching/Matching';
import Fitb from './components/Fitb/Fitb';
import './App.css';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Landing/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/signup' element={<Signup/>}/>
        <Route path='/main' element={<Main/>}/>
        <Route path='/language/matching' element={<Matching/>}/>
        <Route path='/language/fitb' element={<Fitb/>}/>

      </Routes>
    </div>
  );
}

export default App;
