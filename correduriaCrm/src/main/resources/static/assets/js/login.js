AOS.init();
(function () {
    "use strict";

    var forms = document.querySelectorAll('.needs-validation')
  
    Array.prototype.slice.call(forms)
      .forEach(function (form) {
        form.addEventListener('submit', function (event) {
          if (!form.checkValidity()) {
            event.preventDefault()
            event.stopPropagation()
          }
          form.classList.add('was-validated')
        }, false)
      })

      window.scrollTo({
        top:0,
        brehaviour: 'smooth'
      })

      const mensaje = document.querySelector (".forget-pass");
      mensaje.onclick = function(){
        window.alert("El ususario es Admin y su contraseña es admin. Usuario User y su contraseña es 1234.");
      }
  })()

 

