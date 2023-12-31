import decodeJWT from "../jwtService/jwtService";
import { MatchUtil } from "./MatchUtil";

const URL = `http://localhost:8080/api/matching/`

export const MatchApi = {

    getLanguage: async () => {
      try {
        const jwtToken = decodeJWT(localStorage.getItem("jwtToken"));
        const response = await fetch(`http://localhost:8080/api/user/${jwtToken.userId}`);
        
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        return data.language.id;
      } catch (error) {
        console.error('Error fetching questions:', error);
      }
    },

    getQuestions: async (languageId, setQuestions, setLeftMatches, setRightMatches, setCanShow) =>{
      
        try {
            // Replace 'language_id' with the actual language ID you want to request.
            console.log(languageId)
            const response = await fetch(`${URL}${languageId}`);
            if (!response.ok) {
              throw new Error('Network response was not ok');
            }
            const data = await response.json();
            console.log(data);
            setQuestions(data);

            const leftMatchesArray = data.answers.map((answer) => ({
              id: answer.id,
              match: answer.leftMatch,
            }));
            
            const rightMatchesArray = data.answers.map((answer) => ({
              id: answer.id,
              match: answer.rightMatch,
            }));
            
            setLeftMatches(leftMatchesArray);
            setRightMatches(rightMatchesArray);
      
      
            setCanShow(true);
          } catch (error) {
            console.error('Error fetching questions:', error);
          }
    }
}
