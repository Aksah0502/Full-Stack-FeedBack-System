document.getElementById('showPass').addEventListener('change', function () {
    let pass = document.getElementById('password');
    pass.type = this.checked ? 'text' : 'password';
});

function login() {
    const uname = document.getElementById('username').value;
    const pass = document.getElementById('password').value;

    fetch("http://localhost:8080/admin/login?username=" + uname + "&password=" + pass, {
        method: "POST"
    })
    .then(response => response.text())
    .then(result => {
        if (result === "true") {
            window.location.href = "admin-view.html";
        } else {
            document.getElementById("error").innerText = "Invalid credentials";
        }
    })
    .catch(err => {
        document.getElementById("error").innerText = "Server error. Try again.";
    });
}
