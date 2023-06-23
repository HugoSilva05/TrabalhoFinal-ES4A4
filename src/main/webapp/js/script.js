let navbar = document.querySelector(".header .navbar");
let menuBtn = document.querySelector("#menu-btn");

menuBtn.onclick = () => {
  menuBtn.classList.toggle("fa-times");
  navbar.classList.toggle("active");
};

window.onscroll = () => {
  menuBtn.classList.remove("fa-times");
  navbar.classList.remove("active");
};

var roundtripRadio = document.getElementById("roundtrip");
var oneWayRadio = document.getElementById("one-way");
var destinationInput = document.getElementById("destination");

roundtripRadio.addEventListener("change", handleFlightTypeChange);
oneWayRadio.addEventListener("change", handleFlightTypeChange);

function handleFlightTypeChange() {
  if (roundtripRadio.checked) {
    destinationInput.style = "";
  } else if (oneWayRadio.checked) {
    destinationInput.style = "display:none";
  }
}

function mostrarConsulta() {
  var rowDiv1 = document.getElementById("consultarViagem");
  var rowDiv2 = document.getElementById("consultarReservas");
  var rowDiv3 = document.getElementById("alterarVoos");
  rowDiv1.style.display = "block";
  rowDiv2.style.display = "none";
  rowDiv3.style.display = "none";
}

function mostrarReserva() {
  var rowDiv1 = document.getElementById("consultarViagem");
  var rowDiv2 = document.getElementById("consultarReservas");
  var rowDiv3 = document.getElementById("alterarVoos");
  rowDiv1.style.display = "none";
  rowDiv2.style.display = "block";
  rowDiv3.style.display = "none";
}

function mostrarVoos() {
  var rowDiv1 = document.getElementById("consultarViagem");
  var rowDiv2 = document.getElementById("consultarReservas");
  var rowDiv3 = document.getElementById("alterarVoos");
  rowDiv1.style.display = "none";
  rowDiv2.style.display = "none";
  rowDiv3.style.display = "block";
}

function selectCard(card2) {
  const cards = document.getElementsByClassName("card2");
  for (let i = 0; i < cards.length; i++) {
    cards[i].classList.remove("selected");
  }
  card2.classList.add("selected");
}
