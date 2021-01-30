"use strict";
let shelterId = document.querySelector("#shelterId");
let shelterName = document.querySelector("#shelterName");
let addressLine = document.querySelector("#addressLine");
let postcode = document.querySelector("#postcode");

let createShelter = () => {
  fetch("http://localhost:8080/shelter/create", {
    method: "POST",
    body: JSON.stringify({
      name: shelterName.value,
      addressLine: addressLine.value,
      postcode: postcode.value,
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

let updateShelter = () => {
  fetch("http://localhost:8080/shelter/update/" + shelterId.value, {
    method: "PUT",
    body: JSON.stringify({
      name: shelterName.value,
      addressLine: addressLine.value,
      postcode: postcode.value,
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

let delShelter = () => {
  fetch("http://localhost:8080/shelter/delete/" + shelterId.value, {
    method: `DELETE`,
  })
    .then((response) => {
      response.json()
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
  document.myform.output.value = "Shelter Name: "+json.name+", "+"Address: "+json.addressLine+", "+"Postcode: "+json.postcode;
  document.myform.setAttribute("id", "done");
};
