import React, { useEffect, useState } from 'react'
import { MatchUtil } from './MatchUtil';
import { MatchApi } from './MatchApi';
import { Matches } from './Matches';
import MatchModal from './MatchingModal/MatchModal';
import { useNavigate } from 'react-router';
import decodeJWT from '../jwtService/jwtService';
import  ReactCountdownClock  from 'react-countdown-clock';
import "./Matching.css"


const Matching = () => {

    const userInfo =  decodeJWT(localStorage.getItem("jwtToken"));
    const [questions, setQuestions] = useState([]);
    const [leftMatches, setLeftMatches] = useState([]);
    const [rightMatches, setRightMatches] = useState([]);
    const [selected, setSelected] = useState([]);
    const [correctMatches, setCorrectMatches] = useState(0);

    const [canShow, setCanShow] = useState(false);
    const [openModal, setOpenModal] = useState(false);
    const [pause, setPause] = useState(false);
    const [completions, setCompletions] = useState(0);

    
    const navigate = useNavigate();

    const resetGame = () => {

      setQuestions([]);
      setLeftMatches([]);
      setRightMatches([]);
      setCorrectMatches(0);
      setSelected([]);
    }

    const handleOnClose = () => {
      setOpenModal(false);
      restartTimer();
      setPause(false);
      resetGame();
    };
  
    const handleOnDontTryAgain = () => {
      setOpenModal(false);
      navigate("/main");
    };

    const timerEnded = () => {
      setOpenModal(true);
    };

    const restartTimer = () => {
      setCompletions((cur) => setCompletions(cur + 1));
    };

    // Ensures that the API for the language comes and finished first before getting the questions
    const fetchData = async () => {
      try{ 
        let languageId = await MatchApi.getLanguage();
        await MatchApi.getQuestions(languageId,setQuestions,setLeftMatches,setRightMatches, setCanShow);
      } catch(error){
        console.error('Error in useEffect:', error);
      }
    }


    useEffect(() => {
        console.log("fetchData() rerender");
        fetchData();
    }, [completions]);

    useEffect(() => {
     
      if(canShow){
        MatchUtil.shuffleArray(leftMatches, setLeftMatches);
        MatchUtil.shuffleArray(rightMatches, setRightMatches);
      }

    }, [canShow])

    useEffect(() => {

      if(correctMatches === 8){
        setOpenModal(true);
      }

    }, [correctMatches])


    return (

      <>
        
            <MatchModal
              open={openModal}
              onClose={handleOnClose}
              handleOnClose={handleOnClose}
              handleOnDontTryAgain={handleOnDontTryAgain}
           />

            <div className = "matchingheader">
              <h1>{questions?.prompt}</h1>
              <h2>{userInfo?.sub}</h2>
              <h3>{questions?.topic?.language.name}</h3>
            </div>


        {canShow ? (
          <>


            <div className="matching-container">

              <div className="matching-column">
                <div className="match-row">
                  <h1 style={{color: "white"}}>Correct Matches: <small>{correctMatches / 2}</small></h1>
                  <Matches 
                    selected={selected} 
                    setSelected={setSelected} 
                    matches={leftMatches} 
                    setCorrectMatches={setCorrectMatches}
                    setOpenModal={setOpenModal}
                    />
                </div>

                <div className="match-row">
                  <Matches 
                    selected={selected} 
                    setSelected={setSelected} 
                    matches={rightMatches} 
                    setCorrectMatches={setCorrectMatches}
                    setOpenModal={setOpenModal}
                    />
                </div>
              </div>

              <div className="matching-column">
                <ReactCountdownClock
                  key={completions}
                  seconds={15}
                  color="rgb(255, 0, 0, 0.7)"
                  alpha={0.9}
                  size={300}
                  paused={pause}
                  onComplete={timerEnded}
                />
              </div>
            </div>
          </>


        ):(
          <div className="loading-container">
            <div class="lds-ellipsis"><div></div><div></div><div></div><div></div></div>
          </div>
        )}

        <div className="matching-footer">
         <button onClick={handleOnDontTryAgain}>Back to Home</button>
        </div>
        
        

      </>
    )
  }
  
  export default Matching
  