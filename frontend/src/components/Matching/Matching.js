import React, { useEffect, useState } from 'react'
import "./Matching.css"
import { MatchUtil } from './MatchUtil';
import { MatchApi } from './MatchApi';
import { Matches } from './Matches';
import MatchModal from './MatchingModal/MatchModal';
import { useNavigate } from 'react-router';


const Matching = () => {

    const [questions, setQuestions] = useState([]);
    const [leftMatches, setLeftMatches] = useState([]);
    const [rightMatches, setRightMatches] = useState([]);
    const [canShow, setCanShow] = useState(false);
    const [selected, setSelected] = useState([]);
    const [correctMatches, setCorrectMatches] = useState(0);
    const [openModal, setOpenModal] = useState(false);
    const navigate = useNavigate();

    const handleOnClose = () => {
      setOpenModal(false);
    };
  
    const handleOnDontTryAgain = () => {
      setOpenModal(false);
      navigate("/main");
    };


    useEffect(() => {
      MatchApi.getQuestions(1,setQuestions,setLeftMatches,setRightMatches, setCanShow);
    }, []);

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

        {canShow ? (
          <>
             <MatchModal
               open={openModal}
               onClose={handleOnClose}
               handleOnClose={handleOnClose}
               handleOnDontTryAgain={handleOnDontTryAgain}
            />

            <div className = "matchingheader">
              <h1>Language Learning App idk if we picked a name</h1>
              <h2>ver 1.0</h2>
              <h3>Username</h3>
              <h3>{questions.topic.language.name}</h3>
            </div>

            <div class = "matching-container">

              <div className="match-row">
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
          </>

        ):(<>Loading</>)}

        <div className="matchingfooter">
          <a href="http://localhost:3000/main" style={{float:'right'}}><button>Back to Home</button></a>
        </div>


      </>
    )
  }
  
  export default Matching
  