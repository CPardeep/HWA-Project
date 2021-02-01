"use strict";
let dogId = document.querySelector("#dogId");
let dogName = document.querySelector("#dogName");
let dogBreed = document.querySelector("#dogBreed");
let dogAge = document.querySelector("#dogAge");
let dogColour = document.querySelector("#dogColour");
let dogAvailable = document.querySelector("#dogAvailable");
let shelterID = document.querySelector("#shelterID");

let createDog = () => {
  fetch(`http://localhost:8080/dog/create`, {
    method: "POST",
    body: JSON.stringify({
      name: dogName.value,
      breed: dogBreed.value,
      age: dogAge.value,
      colour: dogColour.value,
      available: dogAvailable.value,
      shelter: { id: shelterID.value },
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((json) => {
      console.log(json);
      clearForm();
      printOutput(json, { json });
    })
    .catch((err) => {
      console.error(`Stop! ${err}`);
      printOutputFalse(err, { err });
    });
};

let updateDog = () => {
  fetch("http://localhost:8080/dog/update/" + dogId.value, {
    method: "PUT",
    body: JSON.stringify({
      name: dogName.value,
      breed: dogBreed.value,
      age: dogAge.value,
      colour: dogColour.value,
      available: dogAvailable.value,
      shelter: { id: shelterID.value },
    }),
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((json) => {
      console.log(json);
      clearForm();
      printOutput(json, { json });
    })
    .catch((err) => console.error("Error please stop what you're doing"));
};

let delDog = () => {
  fetch("http://localhost:8080/dog/delete/" + dogId.value, {
    method: `DELETE`,
  })
    .then((response) => {
      response.json();
      //let reply = (response.status == "204" ? document.myform.output.value ="Successfull" : document.myform.output.value ="Failed");
      if(response.status == "204"){
        document.myform.output.value ="Successfull";
        document.myform.setAttribute("id", "done");
      } else{
        document.myform.output.value ="Failed";
      }
    })
    .then((json) => console.log(json))
    .catch((err) => console.error(`Stop! ${err}`));
};

let clearForm = () => {
  document.getElementById("xForm").reset();
};

let printOutput = (element, { json }) => {
  document.myform.output.value = "Name: "+json.name+", "+"Breed: "+json.breed+", "+"Age: "+json.age +", "+"Colour: "+json.colour+", "+"Available: "+json.available;
  document.myform.setAttribute("id", "done");
};
