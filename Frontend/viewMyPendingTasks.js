let tableRequest = document.getElementById('requestsTable');
checkLogin().then(setMessageBox);

function setMessageBox() {
  if (loggedInUser) {
    if (loggedInUser) {
      getAllMyPendingTasks();
    } else {
      console.log('You don\'t seem to have any pets. Try adopting some!');
    }
  } else {
    console.log('You need to be logged in to view your pets! (You may need to refresh the page.)');
  }
}

async function getAllMyPendingTasks() {
  try {
    console.log("я начал выполняться!");
    let id = sessionStorage.getItem('Auth-Token');
    console.log(id);
    //let credentialJSON = JSON.stringify(credentials);
    const httpResp = await fetch('http://localhost:8085/myPendingTasks/' + id);
    // { method: 'GET', headers: { 'Content-Type': 'application/json' } });
    console.log(httpResp);
    console.log("ive got my requests");
    if (httpResp && httpResp.status === 200) {
      requests = await httpResp.json();
      // let arrayOfRequets = JSON.parse(requests);
      console.log(requests);
      let thead = document.createElement('thead');
      thead.innerHTML = `
                <tr>
                  <th scope="col">Id</th>
                  <th scope="col">Status</th>
                  <th scope="col">Location</th>
                  <th scope="col">description</th>
                  <th scope="col">Event</th>
                  <th scope ="col">Date</th>
                  <th scope ="col">Cost</th>
                  <th scope = "col"> Submitted at</th>
                  <th scope = "col">Submitter</th>    
                </tr>`;
      tableRequest.appendChild(thead);
      let tbody = document.createElement('tbody');
      requests.forEach((element, index, array) => {
        let row = document.createElement('tr');
        let status = element.status;

        row.setAttribute('id', element.requestId);
        var date = new Date(element.eventDate);
        let submitDate = new Date(element.submittedAt);
        submitDate = submitDate.getDate() +
          "/" + (submitDate.getMonth() + 1) +
          "/" + submitDate.getFullYear();
        date = date.getDate() +
          "/" + (date.getMonth() + 1) +
          "/" + date.getFullYear();

        row.innerHTML = `
                    <td >${element.requestId}</td>
                    <td>${element.status}</td>
                    <td>${element.location}</td>
                    <td>${element.description}</td>
                    <td>${element.event}</td> 
                    <td>${date}</td>
                    <td>${element.cost}</td>
                    <td>${submitDate}</td>
                    <td>${element.submitter}</td>`;


        if (status.includes('Pending')) {
          let td = document.createElement('td');
          td.innerHTML = `<td><button type="button" class="btn btn-outline-primary btn-sm" id ="approveRequest" name="approveRequest">Approve</button>
          <button type="button" class="btn btn-outline-danger btn-sm" id ="rejectRequest">Reject</button></td>`;
          let th = document.createElement('th');
          th.innerHTML = `<th scope = "col">Action</th>`;
          thead.appendChild(th);
          row.appendChild(td);
        }

        // add the row to the table
        tbody.appendChild(row);


      });
      tableRequest.appendChild(tbody);

      let approveButtons = document.getElementsByName('approveRequest');
      console.log(approveButtons);
      if (approveButtons) {
        for (let i = 0; i < approveButtons.length; i++) {
          approveButtons[i].addEventListener("click", approveRequest);
        }
      };

      let rejectButtons = document.getElementsByName('rejectRequest');
      if (rejectButtons) {
        for (let i = 0; i < rejectButtons.length; i++) {
          rejectButtons[i].addEventListener("click", rejectRequest);
        }
      }
    }
  } catch (err) {
    console.log(err);
  }
}

async function approveRequest(event) {

  let rowId = event.target.parentNode.parentNode.id;

  const credentials = {

    eventTypeId: 0,
    statusId: 4,
    submitterId: sessionStorage.getItem('Auth-Token'),
    eventDate: new Date(),
    cost: 0,
    location: "",
    description: "",
    requestId: rowId

  };

  let credentialJSON = JSON.stringify(credentials);
  let httpResp = await fetch('http://localhost:8085/RequestAction',
    { method: 'PUT', body: credentialJSON, headers: { 'Content-Type': 'application/json' } });

  console.log(httpResp);


}

async function rejectRequest(event) {

  let rowId = event.target.parentNode.parentNode.id;

  const credentials = {

    eventTypeId: 0,
    statusId: 5,
    submitterId: sessionStorage.getItem('Auth-Token'),
    eventDate: new Date(),
    cost: 0,
    location: "",
    description: "",
    requestId: rowId

  };

  let credentialJSON = JSON.stringify(credentials);
  let httpResp = await fetch('http://localhost:8085/RequestAction',
    { method: 'PUT', body: credentialJSON, headers: { 'Content-Type': 'application/json' } });

  console.log(httpResp);


}