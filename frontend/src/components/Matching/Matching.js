import React from 'react'
import "./Matching.css"

const Matching = () => {
    return (

      <div classname="Matching-container">

        <div class = "matchingheader">
          <h1>Language Learning App idk if we picked a name</h1>
          <h2>ver 1.0</h2>
          <h3>Username</h3>
          <h3>Language</h3>
        </div>

        <div class = "matching">
          <a href=""><button>word1</button></a>
          <a href=""><button>word2</button></a>
          <a href=""><button>word3</button></a>
          <a href=""><button>word4</button></a>
          <a href=""><button>word5</button></a>
          <br></br>
          <a href=""><button>answer1</button></a>
          <a href=""><button>answer2</button></a>
          <a href=""><button>answer3</button></a>
          <a href=""><button>answer4</button></a>
          <a href=""><button>answer5</button></a>

        </div>

        <div class="matchingfooter">
          <a href="http://localhost:3000/main" style={{float:'right'}}><button>Back to Home</button></a>
        </div>
      </div>
    )
  }
  
  export default Matching
  