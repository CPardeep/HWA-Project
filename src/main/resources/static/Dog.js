"use strict";
let dogId = document.querySelector("#dogId");
let dogName = document.querySelector("#dogName");
let dogBreed = document.querySelector("#dogBreed");
let dogAge = document.querySelector("#dogAge");
let dogColour = document.querySelector("#dogColour");
let dogAvailable = document.querySelector("#dogAvailable");

let createDog = () => {

    fetch("http://localhost:8080/dog/create", {
        method: 'POST',
        body: JSON.stringify({
            "name": dogName.value,
            "breed": dogBreed.value,
            "age": dogAge.value,
            "colour": dogColour.value,
            "available": dogAvailable.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then((response) => response.json())
        .then((json) => console.log(json))
        .catch((err => console.error("Error please stop what you're doing")))
}

let updateDog = () => {

    fetch("http://localhost:8080/dog/update/"+ dogId.value, {
        method: 'PUT',
        body: JSON.stringify({
            "name": dogName.value,
            "breed": dogBreed.value,
            "age": dogAge.value,
            "colour": dogColour.value,
            "available": dogAvailable.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then((response) => response.json())
        .then((json) => console.log(json))
        .catch((err => console.error("Error please stop what you're doing")))

}

let delDog = () => {
    fetch("http://localhost:8080/dog/delete/" + dogId.value, {
        method: `DELETE`})
        .then((response) => response.json())
        .then((json) => console.log(json))
        .catch((err) => console.error(`Stop! ${err}`));
};
