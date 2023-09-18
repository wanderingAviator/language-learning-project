import React from 'react'
import { Link } from 'react-router-dom'
import "./Signup.css"
import logo from './image.png';

console.log(logo);

const Signup = () => {
  return (
    <div className="signup-container">

      <div className="left-bar">

        <h1>SIGNUP</h1>

        <div className="labelbox">
          <label for="email">E-mail</label><br/>
          <input type="text" id="email" name="email"/>
        </div>

        <div className="labelbox">
          <label for="fname">First name</label><br/>
          <input type="text" id="fname" name="fname"/>
        </div>

        <div className="labelbox">
          <label for="lname">Last name</label><br/>
          <input type="text" id="lname" name="lname"/>
        </div>

        <div className="labelbox">
          <label for="username">Username</label><br/>
          <input type="text" id="username" name="username"/>
        </div>

        <div className="labelbox">
          <label for="password">Password</label><br/>
          <input type="text" id="password" name="password"/>
        </div>

        <div className="buttonsection">
          <button>Sign Up</button>
          <a href="http://localhost:3000/"><button>Back to Home</button></a>  
        </div>


      </div>

      <div className="signup-image">
        <img src={logo} alt = "signup img"/>
      </div>

    </div>
  )
}

export default Signup
