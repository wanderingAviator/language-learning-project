import React, { useEffect } from 'react'

export const Matches = ({selected, setSelected ,matches, setCorrectMatches}) => {

    const handleClick = (e) => {
        try{
  
          const parsedValue = JSON.parse(e.target.value);
        //   console.log(e.target.value)
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
        let firstButton = document.getElementById(`${lastElement.id}-${lastElement.match}`);
        let secondButton = document.getElementById(`${secondToLastElement.id}-${secondToLastElement.match}`)
        if(isEqual){
            console.log("They are the same");

            firstButton.className = 'matched-card';
            secondButton.className = 'matched-card';

            setCorrectMatches((count) => count + 1);

        } else {
            console.log("They are different")

            firstButton.className = 'incorrect-card';
            secondButton.className = 'incorrect-card';

            setTimeout(() => {
                firstButton.className = 'match-card';
                secondButton.className = 'match-card';
            }, 500)
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
        {matches.map((match) => (
            
            <button key={`${match.id}-${match.match}`} id={`${match.id}-${match.match}`} className="match-card" value={JSON.stringify(match)} onClick={handleClick}>
                {match.match}
            </button>
            
        ))}
    </div>
    )
}
