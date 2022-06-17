document.getElementById("nombre").addEventListener("blur",comprobarNombre);
let mensaje = document.getElementById("errorNombre");

function validarFormulario(){
	let resultado = false;

	resultado = comprobarNombre();

	return resultado;
}

function comprobarNombre(){
	let nombre = formulario.nombre;
	let correcto = nombre.value!="";
	
	if(correcto){
		nombre.nextElementSibling.hidden = true;
		camelize(nombre.value);
	}else{
		nombre.nextElementSibling.hidden = false;
		mensaje.classList.remove('d-none');
        mensaje.classList.add('d-block');
        mensaje.textContent = ("Este campo no puede estar vacío ni ser un número.");
	}
	
	return correcto;
};


function camelize(str) {
	let words = str.split(" ");

	for (let i = 0; i < words.length; i++) {

		let word = words[i].split('');
		word[0] = word[0].toUpperCase();
		words[i] = word.join('');
	}
	return words.join(' ');
};