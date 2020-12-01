import React from "react";
import { useState } from "react";
import api from "../../services/api";
import { useHistory } from "react-router-dom";
import {
  Container,
  Title,
  Buttons,
  SearchCar,
} from "../FindCarsAndRental/styles";

function ReturnCar() {
  const [placa, setPlaca] = useState("");
  const history = useHistory();
  const returnACar = () => {
    api.post(`/devolve-carro`, { placa }).then(
      (response) => {
        if (response.data) {
          alert(`O carro de placa ${placa} foi devolvido.`);
        } else {
          alert("Carro não existe ou ocorreu um erro com o serviço.");
        }
      },
      (error) => {
        alert("Ocorreu um erro ao tentar realizar o serviço.");
      }
    );
  };

  return (
    <Container>
      <Buttons>
        <button onClick={() => history.push("/")}>Voltar </button>
      </Buttons>

      <Title>Digite a placa que do carro que deseja devolver</Title>
      <SearchCar>
        <input
          value={placa}
          placeholder="placa"
          onChange={(event) => setPlaca(event.target.value)}
        />
        <Buttons>
          <button onClick={returnACar}>Devolver carro</button>
        </Buttons>
      </SearchCar>
    </Container>
  );
}

export default ReturnCar;
