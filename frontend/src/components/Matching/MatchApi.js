import decodeJWT from "../jwtService/jwtService";
import { MatchUtil } from "./MatchUtil";

const URL = `http://localhost:8080/api/matching/`

export const MatchApi = {

    getLanguage: async (setLanguage) => {
      try {
        const jwtToken = decodeJWT(localStorage.getItem("jwtToken"));
        const response = await fetch(`http://localhost:8080/api/user/${jwtToken.userId}`);
        
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        const data = await response.json();
        setLanguage(data.language);
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
            setQuestions(data);
      
            data.answers.map((answer) => {
              const leftValue = {
                id: answer.id,
                match: answer.leftMatch
              }
              const rightValue = {
                id: answer.id,
                match: answer.rightMatch
              }
              MatchUtil.addMatches(leftValue, setLeftMatches);
              MatchUtil.addMatches(rightValue, setRightMatches);
            });
      
      
            setCanShow(true);
          } catch (error) {
            console.error('Error fetching questions:', error);
          }
    }
}
