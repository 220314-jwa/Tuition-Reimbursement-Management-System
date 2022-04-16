let registerButton = document.getElementById('registerButton');
registerButton.addEventListener('click', register);

var deptList = document.getElementById("department");
if (deptList) {
    deptList.addEventListener('click', getDepartments);
}
async function register() {

    let selectManager = document.getElementById('manager');
    let selectDepartment = document.getElementById('department');
    const credentials = {

        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('secondName').value,
        password: document.getElementById('password').value,
        email: document.getElementById('email').value,
        userName: document.getElementById('userName').value,
        managerId: selectManager.options[selectManager.selectedIndex].value,
        deptId: selectDepartment.options[selectDepartment.selectedIndex].value

    };

    let credentialJSON = JSON.stringify(credentials);
    let httpResp = await fetch('http://localhost:8085/users',
        { method: 'POST', body: credentialJSON, headers: { 'Content-Type': 'application/json' } });


    if (httpResp && httpResp.status === 200) {
        reimburesemnt = await httpResp.json();
        console.log("User created reimbursement!");
        location.href = "login.html";
    }


}

async function getDepartments() {

    try {
        let httpResp = await fetch('http://localhost:8085/departments',
            { method: 'GET', headers: { 'Content-Type': 'application/json' } });

        if (httpResp && httpResp.status === 200) {
            deptsArray = await httpResp.json();

            if (!deptList.children.length > 0) {
                for (dept of deptsArray) {
                    const option = document.createElement('option');
                    option.setAttribute('id', 'deptOption');
                    option.value = dept.id;
                    option.text = dept.deptName;
                    deptList.appendChild(option);
                };
                console.log("Departments" + httpResp.status + "finished");
            }
        }
    }
    catch (err) {
        console.log(err);
    }


}