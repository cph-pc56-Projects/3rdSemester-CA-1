/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

getPersons();
function makeRow(data) {
    return "<tr><td>" + data.fName + "</td>" + "<td>" + data.lName + "</td>" + "<td>" + data.email + "</td>";

}

function getPersons() {
    var promise = fetch('api/person/all');
    promise.then(function (response) {
        return response.json();
    }).then(function (persons) {
        var list = persons.map(makeRow).join("");
        document.getElementById("tbody").innerHTML = list;
    });
}

document.getElementById("reload").onclick = getPersons;