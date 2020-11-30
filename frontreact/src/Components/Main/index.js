import React from "react";
import { Container, Content, Card, Title } from "./styles";

function Main() {
  return (
    <Container>
      <Title>Escolha uma das opções abaixo:</Title>
      <Content>
        <Card to="/RentACar"> Alugar um Carro</Card>
        <Card to="/ListRentals"> Listar Aluguéis</Card>
        <Card to="/ReturnACar"> Devolver carro</Card>
      </Content>
    </Container>
  );
}

export default Main;
