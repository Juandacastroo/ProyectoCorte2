document.addEventListener("DOMContentLoaded", function() {
  // Aquí va tu código JavaScript
  const carreras = document.getElementById("carreras");
  const mostrar = document.getElementById("mostrar");

  carreras.addEventListener("change", () => {
    const opcionSeleccionada = carreras.value;
    if (opcionSeleccionada === "Arquitectura") {
      mostrar.textContent = "3 cop";
    } else if (opcionSeleccionada === "2") {
      mostrar.textContent = "Has seleccionado la opción 2";
    } else if (opcionSeleccionada === "3") {
      mostrar.textContent = "Has seleccionado la opción 3";
    }
  });
});






