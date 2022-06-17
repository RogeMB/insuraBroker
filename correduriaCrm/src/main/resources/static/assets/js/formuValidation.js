
document.getElementById("nombre").addEventListener("blur",pasarNombreApellidosAMayusculas);
document.getElementById("apellidos").addEventListener("blur",pasarNombreApellidosAMayusculas);
document.getElementById("DNI").addEventListener("blur",comprobarDNI);
document.getElementById("email").addEventListener("blur",comprobarCorreo);
document.getElementById("pwd2").addEventListener("blur",comprobarContrasena);
document.getElementById("fnac").addEventListener("blur",comprobarEdad);


function revisarFormulario(){
	let resultado = false;

	resultado = pasarNombreApellidosAMayusculas()&&
				comprobarDNI()&&
				comprobarCorreo()&&
				comprobarContrasena()&&
				comprobarEdad();
	

	formulario.enviar.className = resultado?"btn btn-success mb-2":"btn btn-danger mb-2";

	return resultado;
}

function pasarNombreApellidosAMayusculas(){

	let campoNombre = formulario.nombre;
	let campoApellidos = formulario.apellidos;

	let mensaje = getElementById("errorFormu");
	mensaje.textContent
	mensaje.textContent("")
	let resultado = (campoNombre.value!=="")&&(campoApellidos.value!=="");
	if(resultado){		
		campoNombre.value = campoNombre.value.toUpperCase();
		campoApellidos.value = campoApellidos.value.toUpperCase();		
	}

	cambiarApariencia(campoNombre,resultado);
	cambiarApariencia(campoApellidos,resultado);
	
	return resultado;
}

function comprobarDNI(){
	let dni = formulario.DNI;

	let resultado = dni.value!=="";
	
	if(resultado){
		dni.value = dni.value.toUpperCase();
		let numDNI = dni.value.substring(0,8); 
		let letraDNI = dni.value.substring(8);

	
		let letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J',
		 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

		resultado = (numDNI > 0 && numDNI < 99999999) && (letras[numDNI%23]==letraDNI);					
	}

	cambiarApariencia(dni,resultado)
	
	return resultado;
}

function comprobarCorreo(){
	let correo = formulario.email;
	let resultado = correo.value!=="";


	if(resultado){
		let partesCorreo = correo.value.split('@');
		resultado = partesCorreo.length==2;
		if(resultado){
			let partesDominio = partesCorreo[1].split('.');
			resultado = partesDominio.length>1;
		}			
	}
	
	cambiarApariencia(correo,resultado);
	
	return resultado;
}

function comprobarContrasena(){
	let pwd1 = formulario.pwd1;
	let pwd2 = formulario.pwd2;
	let resultado = pwd1.value!=="" && pwd2.value!=="";
	let mensaje;
	if(pwd1.value !== pwd2.value){
		resultado = false;		
		mensaje = "Las contraseñas no coinciden";

	}else{
		
		let regex = /^(?=.*\d)(?=.*[a-záéíóúüñ]).*[A-ZÁÉÍÓÚÜÑ]/;
		resultado = pwd1.value.length>7 && regex.test(pwd1.value);
		mensaje = !resultado?"La contraseña debe tener al menos 8 caracteres, algún número, alguna mayúsucula y alguna minúscula":"Contraseña correcta"
	}
	
	cambiarAparienciaPwd(pwd1,pwd2,resultado,mensaje);
	
	return resultado;
}

function comprobarEdad(){
	let fecha = formulario.fnac;
	let resultado = fecha.value!="";
	
	if(resultado){
		let fechaDate = fecha.valueAsDate;
		let hoy = new Date(); 
		let anyos = hoy.getYear()-fechaDate.getYear();		
		
		
		resultado = anyos>18 ||
				    (anyos==18 && hoy.getMonth()>fechaDate.getMonth()) ||
					(anyos==18 && hoy.getMonth()==fechaDate.getMonth() && hoy.getDate()>=fechaDate.getDate());
		
	}

	cambiarApariencia(fecha,resultado);
	
	return resultado;
}


function cambiarApariencia(campo, estado){	
	if(estado){
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		campo.parentNode.nextElementSibling.style.visibility = 'hidden';
	}
	else{
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		campo.parentNode.nextElementSibling.style.visibility = 'visible';
	}
		
}

function cambiarAparienciaPwd(pw1,pw2,estado,mensaje){	
	if(estado){
		pw1.classList.remove("border-danger");
		pw1.classList.add("border-success");
		pw2.classList.remove("border-danger");		
		pw2.classList.add("border-success");
		pw2.parentNode.nextElementSibling.style.visibility = 'hidden';	
	}
	else{
		pw1.classList.remove("border-success");
		pw1.classList.add("border-danger");
		pw2.classList.remove("border-success");
		pw2.classList.add("border-danger");
		pw2.parentNode.nextElementSibling.innerText = mensaje;
		pw2.parentNode.nextElementSibling.style.visibility = 'visible';
	}
}