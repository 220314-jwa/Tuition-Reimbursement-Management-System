var eventList = document.getElementsByTagName("select")[0];
var requests;
var reim = document.getElementById('createReimbursementButton');

if (eventList) {
  eventList.addEventListener('click', getEvents);
}

if (reim) {
  reim.addEventListener('click', createRequest);
}

async function getEvents() {
  try {
    let httpResp = await fetch('http://localhost:8085/events',
      { method: 'GET', headers: { 'Content-Type': 'application/json' } });

    if (httpResp && httpResp.status === 200) {
      eventsArray = await httpResp.json();

      if (!eventList.children.length > 0) {
        for (eventType of eventsArray) {
          const option = document.createElement('option');
          option.setAttribute('id', 'eventOption');
          option.value = eventType.eventTypeId;
          option.text = eventType.eventTypeName;
          eventList.appendChild(option);
        };
        console.log("Events" + httpResp.status + "finished");
      }
    }
  }
  catch (err) {
    console.log(err);
  }
}


async function createRequest() {
  try {
    let selectEvent = document.getElementById('selectEvents');
    const credentials = {
      eventTypeId: selectEvent.options[selectEvent.selectedIndex].value,
      statusId: 1,
      submitterId: 23,
      eventDate: document.getElementById('eventDate').value,
      cost: document.getElementById('cost').value,
      location: document.getElementById('location').value,
      description: document.getElementById('description').value,

    };

    let credentialJSON = JSON.stringify(credentials);
    let httpResp = await fetch('http://localhost:8085/createReimbursement',
      { method: 'POST', body: credentialJSON, headers: { 'Content-Type': 'application/json' } });

    console.log(httpResp);

    if (httpResp && httpResp.status === 200) {
      reimburesemnt = await httpResp.json();
      console.log("I ve created reimbursement!!!");
      location.href = "reimbursements.html";
    }
  }
  catch (err) {
    console.log(err);
  }
}


