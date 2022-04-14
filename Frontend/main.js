let loggedInUser;
let logInBtn;
//document.querySelector("#loginButton").addEventListener("click", logIn);
// Prevent the form from submitting
let buttonLogin = document.getElementById("loginButton");
//let forma = document.getElementsByTagName('form')[0];
//forma.method = 'POST';
buttonLogin.addEventListener('click', logIn);
async function logIn() {
    const credentials = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    };
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
            const url = 'main.html';
            window.location.replace(url);
            //loggedInNavBar();
            console.log("Status" + httpResp.status + "finisged");
        }
    }
    catch (err) {
        console.log(err);
    }

}


async function checkLogin() {

    let userId = sessionStorage.getItem('Auth-Token');
    let options = {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    };
    //let httpResp = await fetch('http://localhost:8085/users/' + userId, options);
    const httpResp = await fetch('http://localhost:8085/users/' + userId);

    if (httpResp.status !== 200) {
        const message = `An error has occured: ${httpResp.status}`;
        throw new Error(message);
    }
    //const movies = await httpResp.json();
    //console.log("Aisariyev Rustem" + movies);
    console.log("status " + httpResp.status);
    if (httpResp && httpResp.status === 200) {
        loggedInUser = await httpResp.json();
        loggedInNavBar();
    }
    console.log(loggedInUser);
    // }
    //  catch (err) {
    //    console.log(err);
    // }
}
checkLogin().catch(error => {
    error.message; // 'An error has occurred: 404'
});

async function getUser() {
    let options = {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    };
    let userId = sessionStorage.getItem('Auth-Token');
    try {
        await fetch('http://localhost:8085/users/' + userId, options).then((response) => {
            response.json()
        }).then(data => { return data });
    }

    catch (err) {
        console.log(err);
    }
}

//var buttonlog = document.createElement("button");
//buttonlog.addEventListener('click', getUser);
//document.body.appendChild(buttonlog);

//var divDept = document.getElementById("dept");

/*async function getDepartment() {
 
    // let httpResp = await fetch('', { method: 'GET', mode: 'no-cors' });
    await fetch('http://localhost:8085/depts/1')
        .then((response) => {
            return response.json();
        })
        .then((data) => {
            console.log(data);
        });
}
*/
/*async function tryc() {
    const element = document.getElementById("test");
  let httpResp  fetch('https://reqres.in/api/users')
        .then(response => response.json())
        .then(data => console.log(data));
 
}*/
let navBar = document.getElementsByTagName('nav')[0];
function loggedInNavBar() {
    let navBar = document.getElementsByTagName('nav')[0];
    let fullName = sessionStorage.getItem('FullName');
    // let userPromise = getUser();
    //let fullName = userPromise.firstName + userPromise.lastName;
    //username.
    navBar.innerHTML = `<div class="container-fluid d-flex flex-row">
<div class="d-flex flex-row justify-content-start">
  <a class="navbar-brand" href="#">
    <i class="fa-solid fa-money-check-dollar">TRMS </i>
  </a>
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#">Features</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#" id = "requestReim">Request reimbursement</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">Contact us</a>
    </li>
  </ul>
</div>
<div class="d-flex flex-row justify-content-end">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" id ="profilePage">
      <i class="fa-regular fa-user">${fullName}</i>
      </a>
    </li>
  </ul>
</div>
</div>`;
    console.log(navBar);

    let profilePage = document.getElementById("profilePage");
    let requestReimbursementItem = document.getElementById("requestReim");
    profilePage.addEventListener('click', profileBody);
    requestReimbursementItem.addEventListener('click', requestReimbursement);
};

let content = document.getElementById("content");
let urlToImg = 'src/img/profile.jpg'


//console.log(profilePage);

function profileBody() {
    content.innerHTML = `<div class="container">
    <div class="main-body">
        <div class="row">
            <div class="col-lg-4">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Admin" class="rounded-circle p-1 bg-primary" width="110">
                            <div class="mt-3">
                                <h4>John Doe</h4>
                                <p class="text-secondary mb-1">Full Stack Developer</p>
                                <p class="text-muted font-size-sm">Bay Area, San Francisco, CA</p>
                                <button class="btn btn-primary">Follow</button>
                                <button class="btn btn-outline-primary">Message</button>
                            </div>
                        </div>
                        <hr class="my-4">
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-globe me-2 icon-inline"><circle cx="12" cy="12" r="10"></circle><line x1="2" y1="12" x2="22" y2="12"></line><path d="M12 2a15.3 15.3 0 0 1 4 10 15.3 15.3 0 0 1-4 10 15.3 15.3 0 0 1-4-10 15.3 15.3 0 0 1 4-10z"></path></svg>Website</h6>
                                <span class="text-secondary">https://bootdey.com</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-github me-2 icon-inline"><path d="M9 19c-5 1.5-5-2.5-7-3m14 6v-3.87a3.37 3.37 0 0 0-.94-2.61c3.14-.35 6.44-1.54 6.44-7A5.44 5.44 0 0 0 20 4.77 5.07 5.07 0 0 0 19.91 1S18.73.65 16 2.48a13.38 13.38 0 0 0-7 0C6.27.65 5.09 1 5.09 1A5.07 5.07 0 0 0 5 4.77a5.44 5.44 0 0 0-1.5 3.78c0 5.42 3.3 6.61 6.44 7A3.37 3.37 0 0 0 9 18.13V22"></path></svg>Github</h6>
                                <span class="text-secondary">bootdey</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-twitter me-2 icon-inline text-info"><path d="M23 3a10.9 10.9 0 0 1-3.14 1.53 4.48 4.48 0 0 0-7.86 3v1A10.66 10.66 0 0 1 3 4s-4 9 5 13a11.64 11.64 0 0 1-7 2c9 5 20 0 20-11.5a4.5 4.5 0 0 0-.08-.83A7.72 7.72 0 0 0 23 3z"></path></svg>Twitter</h6>
                                <span class="text-secondary">@bootdey</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-instagram me-2 icon-inline text-danger"><rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect><path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path><line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>Instagram</h6>
                                <span class="text-secondary">bootdey</span>
                            </li>
                            <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                <h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-facebook me-2 icon-inline text-primary"><path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path></svg>Facebook</h6>
                                <span class="text-secondary">bootdey</span>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <div class="card">
                    <div class="card-body">
                        <div class="row mb-3">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Full Name</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control" value="John Doe">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Email</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control" value="john@example.com">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Phone</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control" value="(239) 816-9029">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Mobile</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control" value="(320) 380-4539">
                            </div>
                        </div>
                        <div class="row mb-3">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Address</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <input type="text" class="form-control" value="Bay Area, San Francisco, CA">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-9 text-secondary">
                                <input type="button" class="btn btn-primary px-4" value="Save Changes">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="d-flex align-items-center mb-3">Project Status</h5>
                                <p>Web Design</p>
                                <div class="progress mb-3" style="height: 5px">
                                    <div class="progress-bar bg-primary" role="progressbar" style="width: 80%" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <p>Website Markup</p>
                                <div class="progress mb-3" style="height: 5px">
                                    <div class="progress-bar bg-danger" role="progressbar" style="width: 72%" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <p>One Page</p>
                                <div class="progress mb-3" style="height: 5px">
                                    <div class="progress-bar bg-success" role="progressbar" style="width: 89%" aria-valuenow="89" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <p>Mobile Template</p>
                                <div class="progress mb-3" style="height: 5px">
                                    <div class="progress-bar bg-warning" role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <p>Backend API</p>
                                <div class="progress" style="height: 5px">
                                    <div class="progress-bar bg-info" role="progressbar" style="width: 66%" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>`;
}
function requestReimbursement() {
    content.innerHTML = `<form class="row g-3">
    <div class="col-md-6">
      <label for="inputEmail4" class="form-label">Email</label>
      <input type="email" class="form-control" id="inputEmail4">
    </div>
    <div class="col-md-6">
      <label for="inputPassword4" class="form-label">Password</label>
      <input type="password" class="form-control" id="inputPassword4">
    </div>
    <div class="col-12">
      <label for="inputAddress" class="form-label">Address</label>
      <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
    </div>
    <div class="col-12">
      <label for="inputAddress2" class="form-label">Address 2</label>
      <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
    </div>
    <div class="col-md-6">
      <label for="inputCity" class="form-label">City</label>
      <input type="text" class="form-control" id="inputCity">
    </div>
    <div class="col-md-4">
      <label for="inputState" class="form-label">State</label>
      <select id="inputState" class="form-select">
        <option selected>Choose...</option>
        <option>...</option>
      </select>
    </div>
    <div class="col-md-2">
      <label for="inputZip" class="form-label">Zip</label>
      <input type="text" class="form-control" id="inputZip">
    </div>
    <div class="col-12">
      <div class="form-check">
        <input class="form-check-input" type="checkbox" id="gridCheck">
        <label class="form-check-label" for="gridCheck">
          Check me out
        </label>
      </div>
    </div>
    <div class="col-12">
      <button type="submit" class="btn btn-primary">Sign in</button>
    </div>
  </form>
  `;
}