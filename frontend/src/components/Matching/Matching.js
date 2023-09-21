import React, { useEffect, useState } from 'react'
import "./Matching.css"
import { MatchUtil } from './MatchUtil';
import { MatchApi } from './MatchApi';


const Matching = () => {

    const [questions, setQuestions] = useState([]);
    const [leftMatches, setLeftMatches] = useState([]);
    const [rightMatches, setRightMatches] = useState([]);
    const [canShow, setCanShow] = useState(false);
    const [selected, setSelected] = useState([]);
   


    const handleClick = (e) => {
      try{

        const parsedValue = JSON.parse(e.target.value);
        setSelected(selected => [...selected, parsedValue]);
      }
      catch (error) {
        console.error('Error parsing JSON:', error);
      }
    }


    const checkMatch = () => {
      let lastElement = selected[selected.length - 1];
      let secondToLastElement = selected[selected.length - 2];
      // let isInLeftMatches = leftMatches.some(match => match.id === lastElement.id) && leftMatches.some(match => match.id === secondToLastElement.id);
      // console.log("Is in left: " + isInLeftMatches)
      
      
      let isEqual = lastElement.id === secondToLastElement.id && lastElement.match !== secondToLastElement.match;
      if(isEqual){
        console.log("They are the same");

      } else {
        console.log("They are different")
      }

    }

    useEffect(() => {
      MatchApi.getQuestions(1,setQuestions,setLeftMatches,setRightMatches, setCanShow);
    }, []);

    useEffect(() => {

      if(canShow){
        MatchUtil.shuffleArray(leftMatches, setLeftMatches);
        MatchUtil.shuffleArray(rightMatches, setRightMatches);
      }

      console.log(selected);
      let isTimeToCheck = selected.length % 2 === 0 && selected.length !== 0;
      if(isTimeToCheck){
        checkMatch();
      }


    }, [canShow, selected])

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
                {leftMatches.map((match) => {
                  
                  // const isMatch = selected.includes(match.id) && selected[selected.length - 1] === match.id;
                  // console.log("Left Match " + isMatch)
                  // const buttonClass = isMatch ? 'matched-card' : 'match-card';
                  
                  return (
                    <button className="match-card" value={match} onClick={handleClick}>
                    {match.match}
                    </button>
                  )
              })}
              </div>

              <div className="match-row">
                {rightMatches.map((match) => {
                  
                  // const isMatch = selected.includes(match.id);
                  // console.log("Right Match " + isMatch)
                  // const buttonClass = isMatch ? 'matched-card' : 'match-card';

                  return (
                   <button className="match-card" value={match} onClick={handleClick} >
                    {match.match}
                   </button>

                  )
                })}
              </div>

            </div>
          </>

        ):(
          <>Loading</>
        )}


        <div className="matchingfooter">
          <a href="http://localhost:3000/main" style={{float:'right'}}><button>Back to Home</button></a>
        </div>
      </div>
    )
  }
  
  export default Matching
  