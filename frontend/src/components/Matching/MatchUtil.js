
export const MatchUtil =  {

    addMatches: (newValue, setMatches) => {
        setMatches(matchesArray => [...matchesArray, newValue]);
    },

    shuffleArray: (array, setArray) => {
        const newArray = [...array];
        for(let i = newArray.length - 1; i > 0; i--){
          const j = Math.floor(Math.random() * (i+1));
          [newArray[i], newArray[j]] = [newArray[j], newArray[i]]
        }
        console.log("New Array: " + newArray)
        setArray(newArray);
    }

   
    



}
