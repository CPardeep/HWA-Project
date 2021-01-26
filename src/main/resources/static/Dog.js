"use strict";
const dogId = document.querySelector("#dogId");
const dogName = document.querySelector("#dogName");
const dogBreed = document.querySelector("#dogBreed");
const dogAge = document.querySelector("#dogAge");
const dogColour = document.querySelector("#dogColour");
const dogAvailable = document.querySelector("#dogAvailable");

const createDog = () => {

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

const updateDog = () => {

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
