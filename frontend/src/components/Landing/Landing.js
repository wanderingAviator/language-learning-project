import React from 'react'
import logo from './image.png';
import "./Landing.css"

console.log(logo);

const Landing = () => {
  return (
    <div className="landing-container">

      <div className="text-container">
        <h1>BIG OL TITLE</h1>
        <p>this is a catchy, super-fancy tagline</p>
        <button>Login</button>
        <button>Signup</button> 
      </div>
        
      <div className="image-container">
          <img src={logo} alt = "login img"/>
      </div>

    </div>
  )
}

export default Landing
