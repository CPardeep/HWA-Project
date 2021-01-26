"use strict";
const shelterId = document.querySelector("#shelterId");
const shelterName = document.querySelector("#shelterName");
const addressLine = document.querySelector("#addressLine");
const postcode = document.querySelector("#postcode");

const createShelter = () => {

    fetch("http://localhost:8080/shelter/create", {
        method: 'POST',
        body: JSON.stringify({
            "name": shelterName.value,
            "addressLine": addressLine.value,
            "postcode": postcode.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then((response) => response.json())
        .then((json) => console.log(json))
        .catch((err => console.error("Error please stop what you're doing")))
}

const updateShelter = () => {

    fetch("http://localhost:8080/shelter/update/"+ shelterId.value, {
        method: 'PUT',
        body: JSON.stringify({
            "name": shelterName.value,
            "addressLine": addressLine.value,
            "postcode": postcode.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then((response) => response.json())
        .then((json) => console.log(json))
        .catch((err => console.error("Error please stop what you're doing")))

}