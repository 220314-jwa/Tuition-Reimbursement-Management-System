let content = document.getElementById("content");
let urlToImg = 'src/img/profile.jpg'
function profileBody() {
    content.innerHTML = `<div class="card" style="width: 18rem;">
    <img src="${urlToImg}" class="card-img-top" alt="myProfilePhoto">
    <div class="card-body">
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    </div>
  </div>`;
}