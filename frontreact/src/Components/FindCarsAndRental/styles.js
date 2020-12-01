import styled from "styled-components";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  width: 100vw;
  min-height: 100vh;
  background-color: #505780;
  overflow: hidden;

  .react-datepicker-wrapper,
  input[type="text"] {
    margin-top: 2.5px;
    width: 100%;
    height: 25px;
    border-radius: 5px;
  }

  .date {
    margin: 5px;
  }

  .date label {
    margin-right: 5px;
    font-weight: bold;
  }
  .select {
    margin-top: 5px;
  }

  .select label {
    margin-left: 5px;
    font-weight: bold;
  }
`;

export const Card = styled.div`
  display: flex;
  flex-direction: column;
  border-radius: 10px;
  margin: 5px;
  padding: 10px;
  max-width: 20vw;
  background-color: #fff;
  opacity: 90%;
  -webkit-box-shadow: 10px -2px 24px -14px rgba(0, 0, 0, 0.66);
  -moz-box-shadow: 10px -2px 24px -14px rgba(0, 0, 0, 0.66);
  box-shadow: 10px -2px 24px -14px rgba(0, 0, 0, 0.66);
`;

export const SearchCar = styled.div`
  width: 100%;
  display: flex;
  /* justify-content: center; */
  flex-direction: column;
  align-self: center;
  max-width: 300px;
  background-color: #fff;

  border-radius: 10px;
  padding: 5vh 10vw;
  -webkit-box-shadow: 10px -2px 24px -14px rgba(0, 0, 0, 0.66);
  -moz-box-shadow: 10px -2px 24px -14px rgba(0, 0, 0, 0.66);
  box-shadow: 10px -2px 24px -14px rgba(0, 0, 0, 0.66);
`;

export const Content = styled.div`
  display: grid;
  grid-auto-columns: 30vw;
  margin-top: 20px;
  padding: 20px;
  grid-template-columns: minmax(200px, 1fr) 1fr 1fr 1fr;
`;

export const Buttons = styled.div`
  display: flex;
  justify-content: center;
  button {
    margin: 10px;
    min-width: 100px;
    height: 40px;
    border: 0;
    color: #fff;
    background-color: #505780;
    border-radius: 5px;
    align-self: center;
    cursor: pointer;
  }

  button:hover {
    background-color: #807099;
  }
`;

export const Title = styled.h1`
  margin: 0;
  margin-bottom: 10px;
  margin-top: 20px;
  align-self: center;
  color: #fff;
`;

export const Text = styled.p`
  margin: 15px;
  align-self: center;
  font-weight: bold;
  font-size: 18px;
  width: 100vw;
  text-align: center;
  color: #505780;
`;
