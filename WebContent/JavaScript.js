function teclaSomenteNumero()
{
	evt = window.event;
	var tecla = evt.keyCode;
					
	if(tecla > 58 && tecla < 255 || tecla >=0 && tecla < 48)
        { 
	alert('Favor inserir somente Numeros!');
	evt.preventDefault();
	}
}


