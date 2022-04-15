let loginBtn = document.getElementById('loginButton');
loginBtn.addEventListener('click', logIn);
async function logIn() {
    const credentials = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
    console.log("im in Login");
    console.log(credentials.username);
    console.log("Im here!");
    console.log(credentials.password);
    let credentialJSON = JSON.stringify(credentials);
    try {
        let httpResp = await fetch('http://localhost:8085/auth',
            { method: 'POST', body: credentialJSON, headers: { 'Content-Type': 'application/json' } });
        console.log(httpResp);

        if (httpResp && httpResp.status === 200) {
            loggedInUser = await httpResp.json();
            sessionStorage.setItem('Auth-Token', loggedInUser.id);
            sessionStorage.setItem('FullName', loggedInUser.lastName + " " + loggedInUser.firstName);
            console.log("I won!!!");
            await checkLogin();

            loggedInNavBar();
            location.replace('main.html');
            console.log("Status" + httpResp.status + "finisged");
        } else {
            //let inputUsername = document.getElementById('username');
            // inputUsername.setAttribute('style', 'border-color: bold; border:2px;');
            // console.log(username);
            alert("Your password or username is wrong`");
        }
    }
    catch (err) {
        console.log(err);
    }

}
