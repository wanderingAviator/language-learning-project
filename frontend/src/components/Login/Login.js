import React from 'react'
import "./Login.css"
import logo from './image.png';

console.log(logo);

const Login = () => {
  return (
    <div classname="Login-container">
     
     <div class="sidebar">
     <h1>Login to your Account</h1>
        <p>Username</p>
        <input type="text" id="Username" style={{height:'20px',width:'200px'}}/>

        <br></br>

        <p>Password</p>
        <input type="password" id="Password" style={{height:'20px',width:'200px'}}/>

        <br></br>

        <div class="login">
          <button style={{marginRight:'15px'}}>Login</button>
          <a href="http://localhost:3000/"><button>Back to Home</button></a>
        </div>

      </div>
      
      <div class="space">
        <img src={logo} alt = "logo img"/>
      </div>

    </div>
  )
}

export default Login
