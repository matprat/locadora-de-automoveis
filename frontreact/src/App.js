import React, { useEffect, useState } from "react";
import "react-datepicker/dist/react-datepicker.css";
import { registerLocale, setDefaultLocale } from "react-datepicker";
import pt from "date-fns/locale/pt-BR";
import FindCars from "./Components/FindCars";
import ListRentals from "./Components/ListRentals";
registerLocale("pt", pt);

function App() {
  return (
    <div className="App">
      <FindCars />
      <ListRentals />
    </div>
  );
}

export default App;
