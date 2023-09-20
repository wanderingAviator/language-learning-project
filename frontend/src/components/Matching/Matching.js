import React, { useEffect, useState } from 'react'
import "./Matching.css"

const Matching = () => {

    const [questions, setQuestions] = useState([]);
    const [answers, setAnswers] = useState([]);
    const [leftMatches, setLeftMatches] = useState([]);
    const [rightMatches, setRightMatches] = useState([]);
    const [canShow, setCanShow] = useState(false);

    const getQuestions = async () => {
      try {
        // Replace 'language_id' with the actual language ID you want to request.
        const languageId = '1';
        const response = await fetch(`http://localhost:8080/api/matching/${languageId}`);
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        setQuestions(data);
        setAnswers(data.answers);
        setCanShow(true);
      } catch (error) {
        console.error('Error fetching questions:', error);
      }
      
    };

    useEffect(() => {
      getQuestions();
    }, []);

    return (

      <div>

        {canShow ? (
          <>
            <div className = "matchingheader">
              <h1>Language Learning App idk if we picked a name</h1>
              <h2>ver 1.0</h2>
              <h3>Username</h3>
              <h3>{questions.topic.language.name}</h3>
            </div>

            <div class = "matching-container">
              <div className="match-row">
                {answers.map((answer) => (
                  <div className="match-card">
                    <p>{answer.leftMatch}</p>
                  </div>
                ))}
              </div>

              <div className="match-row">
                {answers.map((answer) => (
                  <div className="match-card">
                    <p>{answer.rightMatch}</p>
                  </div>
                ))}
              </div>

            </div>
          </>

        ):(
          <></>
        )}


        <div className="matchingfooter">
          <a href="http://localhost:3000/main" style={{float:'right'}}><button>Back to Home</button></a>
        </div>
      </div>
    )
  }
  
  export default Matching
  