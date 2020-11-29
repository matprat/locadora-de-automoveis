import React, { useState } from "react";
import api from "../../services/api";

function ListRentals() {
  const [rentals, setRentals] = useState([]);

  const loadRentals = () => {
    api.get("todas-locacoes").then(
      (response) => {
        if (response.data) {
          setRentals(response.data);
        } else {
          alert("Ocorreu um erro ao tentar realizar o serviço");
        }
      },
      (error) => {
        alert("Ocorreu um erro ao tentar realizar o serviço");
      }
    );
  };

  return (
    <div>
      <button onClick={loadRentals}>Buscar Locações</button>
      {rentals &&
        rentals.map((rental) => (
          <div className="card">
            <span>
              {rental.arCondicionado && "Ar Condicionado;"}
              {rental.direcao && " Direção Hidráulica;"}
              {rental.cambio && " Câmbio Automático"}
            </span>
            <span>Marca : {rental.marca}</span>
            <span>Modelo : {rental.modelo}</span>
            <span>Placa : {rental.placa}</span>
            <span>
              Seguro :{" "}
              {rental.seguro.toLocaleString("pt-BR", {
                style: "currency",
                currency: "BRL",
              })}
            </span>
            <span>
              Total :{" "}
              {rental.totalPagar.toLocaleString("pt-BR", {
                style: "currency",
                currency: "BRL",
              })}
            </span>
            <span>
              Início da Locação:
              {rental.inicioLocacao.dia}/{rental.inicioLocacao.mes}/
              {rental.inicioLocacao.ano}
            </span>
            <span>
              Fim da Locação:
              {rental.fimLocacao.dia}/{rental.fimLocacao.mes}/
              {rental.fimLocacao.ano}
            </span>
          </div>
        ))}
    </div>
  );
}

export default ListRentals;
