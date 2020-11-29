import React from "react";
import { useState } from "react";

function ReturnCar() {
  const [placa, setPlaca] = useState("");

  return (
    <div>
      <span>Digite a placa que do carro que deseja devolver</span>
      <input value={placa} onChange={(event) => setPlaca(event.target.value)} />
    </div>
  );
}

export default ReturnCar;
