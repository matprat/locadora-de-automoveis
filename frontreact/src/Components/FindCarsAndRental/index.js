import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import api from "../../services/api";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { registerLocale } from "react-datepicker";
import pt from "date-fns/locale/pt-BR";
import {
  Container,
  Card,
  SearchCar,
  Content,
  Buttons,
  Title,
  Text,
} from "./styles";
registerLocale("pt", pt);

function FindCars() {
  const [initialDate, setInitialDate] = useState(new Date());
  const [finalDate, setFinalDate] = useState(new Date());
  const [containsAr, setContainsAr] = useState(false);
  const [containsCambio, setContainsCambio] = useState(false);
  const [containsDirecao, setContainsDirecao] = useState(false);
  const [cars, setCars] = useState([]);
  const history = useHistory();

  const searchAvailableCars = () => {
    const initalDay = initialDate.getDate();
    const initialMonth = initialDate.getMonth() + 1;
    const initialYear = initialDate.getFullYear();
    const finalDay = finalDate.getDate();
    const finalMonth = finalDate.getMonth() + 1;
    const finalYear = finalDate.getFullYear();

    api
      .get(
        `carros-disponiveis?inicioLocacao.dia=${initalDay}&inicioLocacao.mes=${initialMonth}&inicioLocacao.ano=${initialYear}&fimLocacao.dia=${finalDay}&fimLocacao.mes=${finalMonth}&fimLocacao.ano=${finalYear}&arcondicionado=${containsAr}&direcao=${containsDirecao}&cambio=${containsCambio}`
      )
      .then((response) => {
        if (response.data) {
          let aux = response.data;
          aux.hasCars = true;
          setCars(response.data);
        } else {
          setCars([{ hasCars: false }]);
          alert(
            "Ocorreu um erro ao tentar realizar o serviço, por favor contate o suporte."
          );
        }
      });
  };

  const rentalCar = (car) => {
    api
      .post("/confirma-locacao", {
        arcondicionado: car.arCondicionado,
        cambio: car.cambio,
        custoLocacao: car.custoLocacao,
        desconto: car.desconto,
        direcao: car.direcao,
        fimLocacao: {
          dia: car.fimLocacao.dia,
          mes: car.fimLocacao.mes,
          ano: car.fimLocacao.ano,
        },
        inicioLocacao: {
          dia: car.inicioLocacao.dia,
          mes: car.inicioLocacao.mes,
          ano: car.inicioLocacao.ano,
        },
        marca: car.marca,
        modelo: car.modelo,
        placa: car.placa,
        seguro: car.seguro,
        totalPagar: car.totalPagar,
      })
      .then(
        (response) => {
          if (response.data) {
            alert(
              `Locação do carro marca: ${car.marca}, modelo: ${car.modelo}, placa: ${car.placa} realizada com sucesso`
            );
            searchAvailableCars();
          } else {
            alert("Não foi possível locar este carro.");
          }
        },
        (error) => {
          alert("Ocorreu um erro na requisição");
        }
      );
  };
  return (
    <Container>
      <Title>Escolha a data da locação</Title>
      <SearchCar>
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
          <input
            id="arCondicionado"
            type="radio"
            checked={containsAr}
            onClick={() => setContainsAr(!containsAr)}
          />
          <label htmlFor="arCondicionado">Ar condicionado</label>
        </div>
        <div className="select">
          <input
            id="cambio"
            type="radio"
            checked={containsCambio}
            onClick={() => setContainsCambio(!containsCambio)}
          />
          <label htmlFor="cambio">Câmbio Automático</label>
        </div>
        <div className="select">
          <input
            id="direcao"
            type="radio"
            checked={containsDirecao}
            onClick={() => setContainsDirecao(!containsDirecao)}
          />
          <label htmlFor="direcao">Direção Hidráulica</label>
        </div>
        <Buttons>
          <button onClick={() => history.push("/")}>Voltar</button>
          <button onClick={searchAvailableCars}>Buscar carros</button>
        </Buttons>
      </SearchCar>
      <Content>
        {cars.length > 0 ? (
          cars.map((car) => (
            <Card>
              <span>
                <strong>Diferencial:</strong>
                {car.arCondicionado && "Ar Condicionado;"}
                {car.direcao && " Direção Hidráulica;"}
                {car.cambio && " Câmbio Automático"}
                {!car.arCondicionado &&
                  !car.direcao &&
                  !car.cambio &&
                  " Nenhum"}
              </span>
              <span>
                <strong>Marca:</strong> {car.marca}
              </span>
              <span>
                <strong>Modelo:</strong> {car.modelo}
              </span>
              <span>
                <strong>Placa:</strong> {car.placa}
              </span>
              <span>
                <strong>Custo da Locação:</strong>{" "}
                {car.custoLocacao.toLocaleString("pt-BR", {
                  style: "currency",
                  currency: "BRL",
                })}
              </span>
              <span>
                <strong>Desconto:</strong>{" "}
                {car.desconto.toLocaleString("pt-BR", {
                  style: "currency",
                  currency: "BRL",
                })}
              </span>
              <span>
                <strong>Seguro:</strong>{" "}
                {car.seguro.toLocaleString("pt-BR", {
                  style: "currency",
                  currency: "BRL",
                })}
              </span>
              <span>
                <strong>Total: </strong>{" "}
                {car.totalPagar.toLocaleString("pt-BR", {
                  style: "currency",
                  currency: "BRL",
                })}
              </span>
              <Buttons>
                <button onClick={() => rentalCar(car)}>Locar carro</button>
              </Buttons>
            </Card>
          ))
        ) : (
          <Text>
            Nenhum carro selecionado ou não há carros com as características
            escolhidas disponíveis.
          </Text>
        )}
      </Content>
    </Container>
  );
}

export default FindCars;
