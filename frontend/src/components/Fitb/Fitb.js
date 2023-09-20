import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import "./Fitb.css";

const Fitb = () => {
  const [question, setQuestion] = useState("");
  const [guess, setGuess] = useState("");
  const [message, setMessage] = useState(""); // State to store success or error message

  const getQuestion = async () => {
    try {
      // Replace 'language_id' with the actual language ID you want to request.
      const languageId = "1";
      const response = await fetch(
        `http://localhost:8080/api/fill_question/${languageId}`
      );
      if (!response.ok) {
        throw new Error("Network response was not ok");
      }
      const data = await response.json();
      console.log(data);
      setQuestion(data);
    } catch (error) {
      console.error("Error fetching questions:", error);
    }
  };

  const handleGuess = () => {
    // Perform a case-insensitive comparison
    if (guess.toLowerCase() === question.answers[0].answer.toLowerCase()) {
      // Correct guess
      setMessage("Correct! "); // Set success message
    } else {
      // Incorrect guess
      setMessage("Incorrect. Try again."); // Set error message
    }
  };

  useEffect(() => {
    getQuestion();
  }, []);

  return (
    <div className="fitb-container">
      <div className="fitbheader">
        <h1>Yet Another Language Learning App</h1>
      </div>
      <div className="question-wrap">
        <div className="fitbquestion">
          <p>{question.prompt}</p>
          <div className="answer-wrap">
            <input onChange={(e) => setGuess(e.target.value)} />
          </div>
          <button className="fitbanswer-button" onClick={handleGuess}>
            Check Answer
          </button>
          {/* Display the success or error message */}
          <div className={message === "Correct! " ? "correct" : "error"}>
            {message}
          </div>
          {/* Display Link button on success */}
          {message === "Correct! " && (
            <Link className="next-question" to="/language/matching">Next Question -></Link>
          )}
        </div>
      </div>

      <div className="fitbfooter">
        <div className="fitb">
          <a href="http://localhost:3000/main">
            <button>Back to Home</button>
          </a>
        </div>
      </div>
    </div>
  );
};

export default Fitb;
