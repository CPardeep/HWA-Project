"use strict";
const dogId = document.querySelector("#dogName");
const shelterName = document.querySelector("#shelterName");
const addressLine = document.querySelector("#addressLine");
const postcode = document.querySelector("#postcode");

const createShelter = () => {

    fetch("http://localhost:8080/shelter/create", {
        method: 'POST',
        body: JSON.stringify({
            "name": shelterName.value,
            "addressLine": addressLine.value,
            "postcode": postcode.value,
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then((response) => response.json())
        .then((json) => console.log(json))
        .catch((err => console.error("Error please stop what you're doing")))
}