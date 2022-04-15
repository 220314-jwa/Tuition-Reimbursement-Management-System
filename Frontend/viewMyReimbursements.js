let tableRequest = document.getElementById('requestsTable');
checkLogin().then(setMessageBox);


function setMessageBox() {
  if (loggedInUser) {
    if (loggedInUser) {
      getAllMyRequests();
    } else {
      console.log('You don\'t seem to have any pets. Try adopting some!');
    }
  } else {
    console.log('You need to be logged in to view your pets! (You may need to refresh the page.)');
  }
}

async function getAllMyRequests() {
  try {
    console.log("я начал выполняться!");
    let id = sessionStorage.getItem('Auth-Token');
    console.log(id);
    //let credentialJSON = JSON.stringify(credentials);
    const httpResp = await fetch('http://localhost:8085/myReimbursements/' + id);
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
              </tr>`;
      tableRequest.appendChild(thead);
      let tbody = document.createElement('tbody');
      requests.forEach((element, index, array) => {
        if (element.statusId == 1) {
          statusName = 'Pending Manager Approval';
        }
        let row = document.createElement('tr');
        var date = new Date(element.eventDate);
        let submitDate = new Date(element.submittedAt);
        submitDate = submitDate.getDate() +
          "/" + (submitDate.getMonth() + 1) +
          "/" + submitDate.getFullYear();
        date = date.getDate() +
          "/" + (date.getMonth() + 1) +
          "/" + date.getFullYear();
        row.innerHTML = `
                  <td>${element.requestId}</td>
                  <td>${statusName}</td>
                  <td>${element.location}</td>
                  <td>${element.description}</td>
                  <td>${element.eventTypeId}</td> 
                  <td>${date}</td>
                  <td>${element.cost}</td>
                  <td>${submitDate}</td>`;

        // add the row to the table
        tbody.appendChild(row);

      });
      tableRequest.appendChild(tbody);
    }
  } catch (err) {
    console.log(err);
  }
}
