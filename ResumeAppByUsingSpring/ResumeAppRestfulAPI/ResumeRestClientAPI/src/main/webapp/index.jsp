<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script>
        function getUsers(){
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState==4 && this.status==200){
                    var response = JSON.parse(this.responseText);
                    var list = response.obj;
                    printUser(list);
                }
            }
            xhttp.open("GET", "http://localhost:8080/ResumeRestAPI_war_exploded/users", true);
            xhttp.send();
        }

        function deleteUser(id){
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                getUsers()
            }
            xhttp.open("DELETE", "http://localhost:8080/ResumeRestAPI_war_exploded/user/" + id, true);
            xhttp.send();
        }

        function addUser(){
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                getUsers();
            }
            let nm = document.getElementById("name").value;
            let srnm = document.getElementById("surname").value;
            let pass = document.getElementById("password").value;

            let user = {name: nm, surname: srnm, password: pass}
            xhttp.open("POST", "http://localhost:8080/ResumeRestAPI_war_exploded/users", true);
            xhttp.setRequestHeader("Content-Type", "application/json");
            xhttp.send(JSON.stringify(user));
        }

        function printUser(list){
            let container = document.getElementById("container");
            container.innerHTML = '';
            for (var i=0; i<list.length; i++){
                var obj = list[i];
                let deleteBtn = "<button onclick='deleteUser("+obj.id+")'>Delete</button>"
                let str = obj.id + " " + obj.name + " " + obj.surname + deleteBtn + "<br>";
                container.innerHTML += str;
                console.log(str)
            }
        }
    </script>
</head>
    <body onload="getUsers()">
    <div id="container"></div>
    <br>
    <br>
    <br>
    <h1>Add User</h1>
    Name: <input type="text" id="name"><br>
    Surname: <input type="text" id="surname"><br>
    Password: <input type="text" id="password"><br>
    <button onclick="addUser()">Add</button>
    </body>
</html>
