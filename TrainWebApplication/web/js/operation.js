function usersignin() {
    var email = document.getElementById("email").value;
    var pw = document.getElementById("pw").value;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status === 200) {
                var response = request.responseText;
                if (response === "OK") {
                    alert(response);
                    window.location.href = 'traindetails.jsp';
                } else {
                    alert("Unsuccessful");
                }
            }
        }
    };
    var parameter = "email=" + email + "&" + "password=" + pw;
    request.open("Post", "Login", true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send(parameter);
}
function loadTrainDetails() {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status === 200) {
                var response = request.responseText;
                document.getElementById("main").innerHTML = response;
            }
        }
    };
    request.open("GET", "LoadTrainDetails", true);
    request.send();
}


