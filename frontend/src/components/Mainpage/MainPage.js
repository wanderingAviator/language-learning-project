import React, { useState,useEffect } from 'react'
import "./MainPage.css"
import fitb from './fitb.png';
import matching from './matching.png';
import decodeJWT from '../jwtService/jwtService';

const MainPage = () => {
  
  const [language, setLanguage] = useState([]);

  const getLanguage = async () => {
    try {
      const jwtToken = decodeJWT(localStorage.getItem("jwtToken"));
      const response = await fetch(`http://localhost:8080/api/user/${jwtToken.userId}`);
      
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setLanguage(data);
    } catch (error) {
      console.error('Error fetching questions:', error);
    }
    
  };

  useEffect(() => {
    getLanguage();
  }, []);

  return (
    <div className="MainPage-container">
    
      <div className="mainheader">
        <h1>Yet Another Language Learning App</h1>
        <h3>{JSON.parse(localStorage.getItem("user")).username}</h3>
        <h3>{language.language?.name}</h3>
      </div>

      <div className="main-image-container">
        <a href='language/matching'><img src={matching} alt = "matching img" style={{marginLeft:'150px'}}/></a>
        <a href='language/fitb'><img src={fitb} alt = "fitb img"/></a>
      </div>
      
      <div className ="mainfooter">
        <div className = "main">
          <a href="http://localhost:3000/" style={{float:'right'}}><button>Logout</button></a>
        </div>
      </div>
      
    </div>
  )
}

export default MainPage
