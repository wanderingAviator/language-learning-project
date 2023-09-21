import React from 'react'
import logo from './image.png';
import "./Landing.css"

const Landing = () => {
  return (
    <div className="landing-container">

      <div className="text-container">
        <h1>Yet Another Language Learning App</h1>
        <p>Multi-Lingual Coding: now in more ways than one!</p>

        <div className="landing-buttons">
          <a href="http://localhost:3000/login"><button >Login</button></a>
          <a href="http://localhost:3000/signup"><button>Signup</button></a>
        </div>
      </div>
        
      <div className="image-container">
          <img src={logo} alt = "login img"/>
      </div>

    </div>
  )
}

export default Landing
