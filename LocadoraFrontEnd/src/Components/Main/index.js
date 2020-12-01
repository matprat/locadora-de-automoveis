import React from "react";
import { Container, Content, Card, Title, Image, Image2 } from "./styles";
import car from "../../assets/car.svg";
function Main() {
  return (
    <Container>
      <Title>Escolha uma das opções abaixo:</Title>
      <Content>
        <Card to="/RentACar"> Alugar um Carro</Card>
        <Card to="/ListRentals"> Listar Aluguéis</Card>
        <Card to="/ReturnACar"> Devolver carro</Card>
      </Content>
      <Image src={car} alt="Ilustração de um carro" />
    </Container>
  );
}

export default Main;
