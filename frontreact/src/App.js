import React, { useEffect, useState } from 'react';
import api from './services/api';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { registerLocale, setDefaultLocale } from  "react-datepicker";
import pt from 'date-fns/locale/pt-BR';
import FindCars from './Components/FindCars/FindCars';
registerLocale('pt', pt)

function App() {


   return (
    <div className="App">
      <FindCars/>
    </div>
  );
}

export default App;
