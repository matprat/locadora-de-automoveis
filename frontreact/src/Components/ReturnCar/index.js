import React from "react";
import { useState } from "react";
import api from "../../services/api";
import { Link } from "react-router-dom";

function ReturnCar() {
  const [placa, setPlaca] = useState("");

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
    <div>
      <Link to="/">Voltar </Link>

      <span>Digite a placa que do carro que deseja devolver</span>
      <input value={placa} onChange={(event) => setPlaca(event.target.value)} />
      <button onClick={returnACar}>Devolver carro</button>
    </div>
  );
}

export default ReturnCar;
