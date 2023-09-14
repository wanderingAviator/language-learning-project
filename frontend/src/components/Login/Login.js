import React from 'react'
import "./Login.css"
import logo from './image.png';
import { Link } from 'react-router-dom'

console.log(logo);

const Login = () => {
  return (
    <div classname="Login-container">
     
     <div className="sidebar">
        <h1>Login</h1>
        <p>Username</p>
        <input type="text" id="Username"/>
        <br></br>
        <br></br>
        <p>Password</p>
        <input type="password" id="Password"/>
        <br></br>
        <button>Login</button>   
      </div>
      
      <div className="space">
        <img src={logo} alt = "logo img"/>
      </div>
      
      <div className="loginfooter">
        <Link to='/'>Back to Home</Link>
      </div>
    </div>
  )
}

export default Login
