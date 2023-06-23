var termServiceLink = document.querySelector(".term-service");

var popup = document.getElementById("termsPopup");

var closeBtn = document.querySelector(".close");

termServiceLink.addEventListener("click", function (event) {
  event.preventDefault();

  popup.style.display = "block";
});

closeBtn.addEventListener("click", function () {
  popup.style.display = "none";
});
