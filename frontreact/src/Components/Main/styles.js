import styled from "styled-components";
import { Link } from "react-router-dom";

export const Container = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100vh;
`;

export const Content = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 50px;
`;

export const Card = styled(Link)`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 200px;
  height: 200px;
  background-color: #d3d3d3;
  color: #fff;
  margin: 5px;
  text-decoration: none;
`;

export const Title = styled.h1``;
