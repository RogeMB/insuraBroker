AOS.init();
(function () {
    "use strict";

    let forms = document.querySelectorAll('.needs-validation')
  
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
      });

      let  mensaje = document.getElementById("passwordHelp");
   
      let momodal = new bootstrap.Modal(document.getElementById("staticBackdrop"), {});
      mensaje.addEventListener('click', showModal, true); 
      function showModal () {
		momodal.show();
	  };
				
 
      
  })()

 

