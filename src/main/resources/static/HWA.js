"use strict";
let readDog = () => {
  fetch(`http://localhost:8080/dog/readAll`)
    .then((response) => response.json())
    .then((json) => {
      console.log(json);
      removeChild();
      for (let i = 0; i < json.length; i++) {
        let p = document.createElement("p");
        let info = document.createTextNode(
          json[i].id + json[i].name + json[i].breed
        );
        p.appendChild(info);
        results.appendChild(p);
      }
    })
    .catch((err) => console.error(`Stop! ${err}`));
};

let readShelter = () => {
  fetch(`http://localhost:8080/shelter/readAll`)
    .then((response) => response.json())
    .then((json) => {
      console.log(json);
      removeChild();
      for (let i = 0; i < json.length; i++) {
        let p = document.createElement("p");
        let info = document.createTextNode(
          json[i].id + json[i].name + json[i].addressLine + json[i].postcode
        );
        p.appendChild(info);
        results.appendChild(p);
      }
    })
    .catch((err) => console.error(`Stop! ${err}`));
};

let removeChild = () => {
  let results = document.getElementById("results");
  while (results.hasChildNodes()) {
    results.removeChild(results.firstChild);
  }
};
