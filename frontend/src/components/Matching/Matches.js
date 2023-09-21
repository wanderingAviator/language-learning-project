import React, { useEffect } from 'react'

export const Matches = ({selected, setSelected ,matches}) => {

    const handleClick = (e) => {
        try{
  
          const parsedValue = JSON.parse(e.target.value);
          console.log(e.target.value)
          setSelected(selected => [...selected, parsedValue]);
        }
        catch (error) {
          console.error('Error parsing JSON:', error);
        }
      }

    const checkMatch = () => {
        
        let lastElement = selected[selected.length - 1];
        let secondToLastElement = selected[selected.length - 2];        
        
        let isEqual = lastElement.id === secondToLastElement.id && lastElement.match !== secondToLastElement.match;
        if(isEqual){
            console.log("They are the same");

        } else {
            console.log("They are different")
        }
  
    }

    useEffect(()=> {

        console.log(selected);
        let isTimeToCheck = selected.length % 2 === 0 && selected.length !== 0;
        if(isTimeToCheck){
            checkMatch();
        }

    }, [selected])

    return (
    <div className="match-row">
        {matches.map((match) => {
            
            // const isMatch = selected.includes(match.id) && selected[selected.length - 1] === match.id;
            // console.log("Left Match " + isMatch)
            // const buttonClass = isMatch ? 'matched-card' : 'match-card';
            
            
            return (
            <button className="match-card" value={JSON.stringify(match)} onClick={handleClick}>
                {match.match}
            </button>
            )
        })}
    </div>
    )
}
