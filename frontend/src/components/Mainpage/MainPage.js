import React from 'react'
import "./MainPage.css"
import color from './color.png';
import numbers from './numbers.png';

console.log(color);
console.log(numbers);

const MainPage = () => {
  return (
    <div className="MainPage-container">
    
      <div class="mainheader">
        <h1>Language Learning App idk if we picked a name</h1>
        <h2>ver 1.0</h2>
        <h3>Username</h3>
        <h3>Language</h3>
      </div>

      <div className="image-container">
        <img src={color} alt = "color img" style={{float:'left',marginLeft:100,marginTop:200,width:400,height:400}}/>
        <img src={numbers} alt = "number img" style={{float:'left',marginLeft:100,marginTop:200,width:400,height:400}}/>
      </div>
      
      <div class ="mainfooter">
        <div class = "main">
          <a href="http://localhost:3000/" style={{float:'right'}}><button>Logout</button></a>
        </div>
      </div>
      
    </div>
  )
}

export default MainPage
