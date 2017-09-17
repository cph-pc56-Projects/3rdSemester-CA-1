

document.getElementById("PersonsRefresh").addEventListener("click", function ()
{
    PersonsRefresh();
});

document.getElementById("PersonAdd").addEventListener("click", function ()
{
    PersonAdd();
    
    document.getElementById("TablePersonsBody").innerHTML += "<tr><td>New</td><td>" + document.getElementById("PersonFirstName").value + "</td><td>" + document.getElementById("PersonLastName").value + "</td><td>" + document.getElementById("PersonPhoneNumber").value + "</td></tr>";
    PersonsRefresh();
});

document.getElementById("PersonEdit").addEventListener("click", function ()
{
    PersonEdit();
    PersonsRefresh();
});

document.getElementById("PersonDelete").addEventListener("click", function ()
{
    PersonDelete();
    PersonsRefresh();
});

function PersonsRefresh()
{
    fetch("api/person/all", {method: "get"})
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                document.getElementById("TablePersonsBody").innerHTML = "";

                var rows = "";

                for (var i in json)
                {
                    rows += '<tr>';
                    rows += '<td>' + json[i].id + '</td>';
                    rows += '<td>' + json[i].firstName + '</td>';
                    rows += '<td>' + json[i].lastName + '</td>';
                    rows += '<td>' + json[i].phoneNumber + '</td>';
                    rows += '<td><input type="button" onclick="PersonDeleteID(' + json[i].id + ')" value="Delete" /></td>';
                    rows += '<td></td>';
                    rows += '</tr>';
                }

                document.getElementById("TablePersonsBody").innerHTML = rows;
            })
            .catch(function (error) {
                alert("Unable to refresh!");
            });
}

function PersonAdd()
{
    var person = {
        firstName: document.getElementById("PersonFirstName").value,
        lastName: document.getElementById("PersonLastName").value,
        phoneNumber: Number(document.getElementById("PersonPhoneNumber").value)
    };

    fetch("api/person", {
        method: "post",
        body: JSON.stringify(person),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                alert("Person added!");
            })
            .catch(function (error) {
                alert("Person not added!");
            });
}

PersonsRefresh();
function PersonEdit()
{
   
    var person1 = {
        id: document.getElementById("PersonId").value,
        firstName: document.getElementById("PersonFirstName").value,
        lastName: document.getElementById("PersonLastName").value,
        phoneNumber: Number(document.getElementById("PersonPhoneNumber").value)
    };

    fetch("api/person/" + person1.id,{
        method: "put",
        body: JSON.stringify(person1),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                alert("Person edited!");
            })
            .catch(function (error) {
                alert("Person not edited!");
            });
}


function PersonDelete()
{
    var person2 = {
        id: document.getElementById("PersonId").value,
        firstName: document.getElementById("PersonFirstName").value,
        lastName: document.getElementById("PersonLastName").value,
        phoneNumber: Number(document.getElementById("PersonPhoneNumber").value)
    };

    fetch("api/person/" + person2.id, {
        method: "DELETE",
        body: JSON.stringify(person2),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                alert("Person deleted!");
            })
            .catch(function (error) {
                alert("Person not deleted!");
            });
}

document.getElementById("PersonsRefresh").addEventListener("click", function ()
{
    PersonsRefresh();
});

document.getElementById("PersonAdd").addEventListener("click", function ()
{
    PersonAdd();
    document.getElementById("TablePersonsBody").innerHTML += "<tr><td>New</td><td>" + document.getElementById("PersonFirstName").value + "</td><td>" + document.getElementById("PersonLastName").value + "</td><td>" + document.getElementById("PersonPhoneNumber").value + "</td></tr>";
    PersonsRefresh();
});

document.getElementById("PersonEdit").addEventListener("click", function ()
{
    PersonEdit();
    PersonsRefresh();
});

document.getElementById("PersonDelete").addEventListener("click", function ()
{
    PersonDelete();
    PersonsRefresh();
});

function PersonsRefresh()
{
    fetch("api/person/all", {method: "get"})
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                document.getElementById("TablePersonsBody").innerHTML = "";

                var rows = "";

                for (var i in json)
                {
                    rows += '<tr>';
                    rows += '<td>' + json[i].id + '</td>';
                    rows += '<td>' + json[i].firstName + '</td>';
                    rows += '<td>' + json[i].lastName + '</td>';
                    rows += '<td>' + json[i].phoneNumber + '</td>';
                    rows += '<td><input type="button" onclick="PersonDeleteID(' + json[i].id + ')" value="Delete" /></td>';
                    rows += '<td></td>';
                    rows += '</tr>';
                }

                document.getElementById("TablePersonsBody").innerHTML = rows;
            })
            .catch(function (error) {
                alert("Unable to refresh!");
            });
}

function PersonAdd()
{
    var person = {
        firstName: document.getElementById("PersonFirstName").value,
        lastName: document.getElementById("PersonLastName").value,
        phoneNumber: Number(document.getElementById("PersonPhoneNumber").value)
    };

    fetch("api/person", {
        method: "post",
        body: JSON.stringify(person),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                return response.json();
            })
//            .then(function (json) {
//                alert("Person added!");
//            })
//            .catch(function (error) {
//                alert("Person not added!");
//            });
}

PersonsRefresh();
function PersonEdit()
{
   
    var person1 = {
        id: document.getElementById("PersonId").value,
        firstName: document.getElementById("PersonFirstName").value,
        lastName: document.getElementById("PersonLastName").value,
        phoneNumber: Number(document.getElementById("PersonPhoneNumber").value)
    };

    fetch("api/person/" + person1.id,{
        method: "put",
        body: JSON.stringify(person1),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                alert("Person edited!");
            })
            .catch(function (error) {
                alert("Person not edited!");
            });
}


function PersonDelete()
{
    var person2 = {
        id: document.getElementById("PersonId").value,
        firstName: document.getElementById("PersonFirstName").value,
        lastName: document.getElementById("PersonLastName").value,
        phoneNumber: Number(document.getElementById("PersonPhoneNumber").value)
    };

    fetch("api/person/" + person2.id, {
        method: "DELETE",
        body: JSON.stringify(person2),
        headers: new Headers({'content-type': 'application/json'})
    })
            .then(function (response) {
                return response.json();
            })
            .then(function (json) {
                alert("Person deleted!");
            })
            .catch(function (error) {
                alert("Person not deleted!");
            });
}