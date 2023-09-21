import React from "react";
import "./FitbModal.css";

const FitbModal = ({ open, onClose, handleOnClose, handleOnDontTryAgain }) => {
  if (!open) {
    return null;
  }
  return (
    <div className="overlay">
      <div className="modalContainer">
        <div className="modalRight">
          <p className="closeBtn" onClick={onClose}>
            X
          </p>
          <div className="content">
            <p className="tryAgain">TRY AGAIN?</p>
          </div>
          <div className="btnContainer">
            <button className="btnYes" onClick={handleOnClose}>
              <span className="bold">Yes</span>
            </button>
            <button className="btnNo" onClick={handleOnDontTryAgain}>
              <span className="bold">No</span>, thanks
            </button>
          </div>
        </div>
      </div>
    </div>
  );
};

export default FitbModal;
