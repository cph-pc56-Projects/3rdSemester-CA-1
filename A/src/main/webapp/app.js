/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

getPersons();
function makeRow(data) {
    return "<tr><td>" + data.fName + "</td>" + "<td>" + data.lName + "</td>" + "<td>" + data.email + "</td></tr>";

}

function getPersons() {
    var promise = fetch('api/person/all');
    promise.then(function (response) {
        return response.json();
    }).then(function (persons) {
        var raw = persons.persons;
        var list = persons.persons;
        var pepl = list.map(makeRow).join("");                
        document.getElementById("tbody").innerHTML = pepl;
        console.log(persons);
    });
}

function addPerson(){
    var person = {
        fName: document.getElementById("fName").value,
        lName: document.getElementById("lName").value,
        email: document.getElementById("email").value
    };
    
    fetch("api/person", {
        method: "post",
        body: JSON.stringify(person),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                alert("Person added");
                return response.json();
            })
            .catch(function (error) {
                alert("Person not added!");
            });
    getPersons();
}

document.getElementById("reload").onclick = getPersons;
document.getElementById("add").onclick = addPerson;