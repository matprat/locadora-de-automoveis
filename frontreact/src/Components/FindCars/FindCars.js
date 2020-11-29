import React, { useState, useEffect } from "react";
import "./styles.css";
import api from "../../services/api";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { registerLocale } from "react-datepicker";
import pt from "date-fns/locale/pt-BR";
registerLocale("pt", pt);

function FindCars() {
  const [initialDate, setInitialDate] = useState(new Date());
  const [finalDate, setFinalDate] = useState(new Date());
  const [containsAr, setContainsAr] = useState(false);
  const [containsCambio, setContainsCambio] = useState(false);
  const [containsDirecao, setContainsDirecao] = useState(false);
  const [cars, setCars] = useState([]);

  const searchAvailableCars = () => {
    const initalDay = initialDate.getDate();
    const initialMonth = initialDate.getMonth() + 1;
    const initialYear = initialDate.getFullYear();
    const finalDay = finalDate.getDate();
    const finalMonth = finalDate.getMonth() + 1;
    const finalYear = finalDate.getFullYear();

    api
      .get(
        `carros-disponiveis/?inicioLocacao.dia=${initalDay}&inicioLocacao.mes=${initialMonth}&inicioLocacao.ano=${initialYear}&fimLocacao.dia=${finalDay}&fimLocacao.mes=${finalMonth}&fimLocacao.ano=${finalYear}&arcondicionado=${containsAr}&direcao=${containsDirecao}&cambio=${containsCambio}`
      )
      .then((response) => {
        if (response.data) {
          setCars(response.data);
        } else {
          alert(
            "Ocorreu um erro ao tentar realizar o serviço, por favor contate o suporte."
          );
        }
      });
  };
  return (
    <div class="container">
      <div className="date">
        <label>Data Inicial:</label>
        <DatePicker
          selected={initialDate}
          locale="pt"
          dateFormat="dd/MM/yyyy"
          minDate={new Date()}
          onChange={(date) => setInitialDate(date)}
        />
      </div>

      <div className="date">
        <label>Data Final:</label>
        <DatePicker
          selected={finalDate}
          locale="pt"
          dateFormat="dd/MM/yyyy"
          minDate={new Date()}
          onChange={(date) => setFinalDate(date)}
        />
      </div>
      <div className="select">
        <label htmlFor="arCondicionado">Ar condicionado</label>
        <input
          id="arCondicionado"
          type="radio"
          checked={containsAr}
          onClick={() => setContainsAr(!containsAr)}
        />
      </div>
      <div className="select">
        <label htmlFor="cambio">Câmbio Automático</label>
        <input
          id="cambio"
          type="radio"
          checked={containsCambio}
          onClick={() => setContainsCambio(!containsCambio)}
        />
      </div>
      <div className="select">
        <label htmlFor="direcao">Direção Hidráulica</label>
        <input
          id="direcao"
          type="radio"
          checked={containsDirecao}
          onClick={() => setContainsDirecao(!containsDirecao)}
        />
      </div>
      <button onClick={searchAvailableCars}>Buscar carros</button>
      <div>
        {cars &&
          cars.map((car) => (
            <div className="card">
              <span>
                {car.arCondicionado && "Ar Condicionado;"}
                {car.direcao && " Direção Hidráulica;"}
                {car.cambio && " Câmio Automático"}
              </span>
              <span>Marca : {car.marca}</span>
              <span>Modelo : {car.modelo}</span>
              <span>Placa : {car.placa}</span>
              <span>
                Seguro :{" "}
                {car.seguro.toLocaleString("pt-BR", {
                  style: "currency",
                  currency: "BRL",
                })}
              </span>
              <span>
                Total :{" "}
                {car.totalPagar.toLocaleString("pt-BR", {
                  style: "currency",
                  currency: "BRL",
                })}
              </span>
            </div>
          ))}
      </div>
    </div>
  );
}

export default FindCars;
