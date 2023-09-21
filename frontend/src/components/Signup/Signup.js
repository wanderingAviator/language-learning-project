import React from 'react'
import { useState } from 'react'
import "./Signup.css"
import logo from './image.png';

const Signup = () => {

  const [email,setEmail] = useState("");
  const [username,setUsername] = useState("");
  const [password,setPassword] = useState("");
  const [language,setLanguage] = useState("");
  const [successMessage, setSuccessMessage] = useState("");
  const [errorMessage, setErrorMessage] = useState("");

  const handleSubmit = async () => {
    let languageObject = {};
    if(language == "Spanish") {
      languageObject= {
        "id": 1,  
        "name": "Spanish"  
      }
    } else {
      languageObject = {
        "id": 2,  
        "name": "French"  
      } 
    }

    const requestObject =
    {
      "username": username,
      "password": password,
      "email": email,
      "language": languageObject 
    }

    try {
      const response = await fetch("http://localhost:8080/api/user", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(requestObject),
      });

      if (response.ok) {
        setSuccessMessage("Sign up successful. You can now log in.");
        setErrorMessage("");
      } else {
        setSuccessMessage("");
        setErrorMessage("Sign up failed. Please check your information.");
      }
    } catch (error) {
      setSuccessMessage("");
      setErrorMessage("An error occurred. Please try again later.");
    }

  }

  return (
    <div className="signup-container">

      <div className="left-bar">

        <h1>Create an Account</h1>

        <div className="labelbox">
          <label for="email">E-mail</label><br/>
          <input type="text" id="email" name="email" onChange={(e) => setEmail(e.target.value)}/>
        </div>

        <div className="labelbox">
          <label for="username">Username</label><br/>
          <input type="text" id="username" name="username" onChange={(e) => setUsername(e.target.value)}/>
        </div>

        <div className="labelbox">
          <label for="password" >Password</label><br/>
          <input type="password" id="password" name="password" onChange={(e) => setPassword(e.target.value)}/>
        </div>

        <div className="language">
          <select id="languageSelect" value={language} onChange={(e) => setLanguage(e.target.value)}>
            <option value="">Select Language</option>
            <option value="French">French</option>
            <option value="Spanish">Spanish</option>
          </select>
        </div>

        {successMessage && <p style={{ color: "green" }}>{successMessage}</p>}
        {errorMessage && <p style={{ color: "red" }}>{errorMessage}</p>}

        <div className="buttonsection">
          <button onClick={handleSubmit}>Sign Up</button>
          <a href="http://localhost:3000/" ><button style={{}}> Back to Home</button></a>  
        </div>     

      </div>

      <div className="signup-image">
        <img src={logo} alt = "signup img"/>
      </div>

    </div>
  )
}

export default Signup
