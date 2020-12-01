import styled from "styled-components";
import { Link } from "react-router-dom";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 100vh;

  background-color: #f1f1f1;
`;

export const Content = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 50px;
  z-index: 1;
  border-radius: 10px;
`;

export const Card = styled(Link)`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 200px;
  height: 200px;
  background-color: #505780;
  border-radius: 5px;
  color: #fff;
  margin: 10px;
  text-decoration: none;
  font-weight: bold;
`;

export const Image = styled.img`
  z-index: 0;
  position: absolute;
  width: 600px;
  top: 55vh;
  right: 1vw;
  align-self: flex-end;
`;

export const Title = styled.h1`
  margin-top: 10vh;
  color: #505780;
`;
