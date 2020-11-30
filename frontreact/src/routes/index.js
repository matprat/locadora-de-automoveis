import React from "react";
import { Switch, Route } from "react-router-dom";
import FindCarsAndRental from "../Components/FindCarsAndRental";
import ListRentals from "../Components/ListRentals";
import Main from "../Components/Main";
import ReturnCar from "../Components/ReturnCar";
function Routes() {
  return (
    <Switch>
      <Route path={"/"} exact component={Main} />
      <Route path={"/RentACar"} component={FindCarsAndRental} />
      <Route path={"/ListRentals"} component={ListRentals} />
      <Route path={"/ReturnACar"} component={ReturnCar} />
    </Switch>
  );
}

export default Routes;
