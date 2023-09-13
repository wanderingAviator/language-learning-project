import React from 'react'
import "./Login.css"
import { Link } from 'react-router-dom'

const Login = () => {
  return (
    <div classname="Login-container">
      <div className="text-container">
      <h1>test</h1>
        
      </div>
        
      <div className="footer">
        <Link to='/'>Back to Home</Link>
      </div>
    </div>
  )
}

export default Login
