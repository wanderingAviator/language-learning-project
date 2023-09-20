import React, { useEffect,useState } from 'react'
import "./Fitb.css"


const Fitb = () => {
  const [questions, setQuestions] = useState([]);

  const getQuestions = async () => {
    try {
      // Replace 'language_id' with the actual language ID you want to request.
      const languageId = '1';
      const response = await fetch(`http://localhost:8080/api/fill_question/${languageId}`);
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      const data = await response.json();
      setQuestions(data);
    } catch (error) {
      console.error('Error fetching questions:', error);
    }
    
  };

  useEffect(() => {
    getQuestions();
  }, []);

  return (
    <div className="Fitb-container">
    
      <div className="fitbheader">
          <h1>Yet Another Language Learning App</h1>
          <h2>ver 1.0</h2>
          <h3>Username</h3>
          <h3>Language</h3>
      </div>
      
    <div className="fitbquestion">
    <p>{questions.prompt}</p>
        <input style={{height:'50px',width:'200px'}}></input>
    </div>
    

      <div className ="fitbfooter">
        <div className = "fitb">
          <a href="http://localhost:3000/main" style={{float:'right'}}><button>Back to Home</button></a>
        </div>
      </div>
      
    </div>
  )
}

export default Fitb
