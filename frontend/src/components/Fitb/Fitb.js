import React from 'react'
import "./Fitb.css"

const MainPage = () => {
  return (
    <div className="Fitb-container">
    
      <div class="fitbheader">
          <h1>Language Learning App idk if we picked a name</h1>
          <h2>ver 1.0</h2>
          <h3>Username</h3>
          <h3>Language</h3>
      </div>
      
    <div class="fitbquestion">
        <p>This is a test question. This is a test question. This is a test question. This is a test question. This is a test question. This is a test question. This is a test question. </p>
    </div>

    <div class="fitbanswer">
        <button>answer1</button>
        <button>answer2</button>
        <button>answer3</button>
        <button>answer4</button>
        <button>answer5</button>
    </div>
    

      <div class ="fitbfooter">
        <div class = "fitb">
          <a href="http://localhost:3000/" style={{float:'right'}}><button>Back to Home</button></a>
        </div>
      </div>
      
    </div>
  )
}

export default MainPage
