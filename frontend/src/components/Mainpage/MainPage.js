import React from 'react'
import "./MainPage.css"
import color from './color.png';
import numbers from './numbers.png';
import ph3 from './ph3.png';
import ph4 from './ph4.png';
import ph5 from './ph5.png';
import { Link } from 'react-router-dom'

console.log(color);
console.log(numbers);
console.log(ph3);
console.log(ph4);
console.log(ph5);

const MainPage = () => {
  return (
    <div className="MainPage-container">
    
      <div class="header">
        <h1>Language Learning App idk if we picked a name</h1>
        <h2>ver 1.0</h2>
        <h3>Username</h3>
        <h3>Language</h3>
      </div>

      <div className="image-container">
        <img src={color} alt = "color img" style={{float:'left',marginLeft:100,marginTop:200,width:250,height:250}}/>
        <img src={numbers} alt = "number img" style={{float:'left',marginLeft:100,marginTop:200,width:250,height:250}}/>
        <img src={ph3} alt = "ph3 img" style={{float:'left',marginLeft:100,marginTop:200,width:250,height:250}}/>
        <img src={ph4} alt = "ph4 img" style={{float:'left',marginLeft:100,marginTop:200,width:250,height:250}}/>
        <img src={ph5} alt = "ph5 img" style={{float:'left',marginLeft:100,marginTop:200,width:250,height:250}}/>
      </div>
      
      <div class ="footer">
        <Link to='/' style={{float:'right',marginRight:10}}>Logout</Link>
      </div>
      
    </div>
  )
}

export default MainPage
