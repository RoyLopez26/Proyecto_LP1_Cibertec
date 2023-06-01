/**
 * 
 */
   
   /* Validación de todos los campos, si todo esta OK se registra, si no, muestra mensaje de error */
   $("#id_btn_registra").click(function(){
	    var validator = $('#id_form').data('bootstrapValidator');
        validator.validate();
	
        if (validator.isValid()) {
            $.ajax({
              type: "POST",
              url: "registraResponsable", 
              data: $('#id_form').serialize(),
              success: function(data){
        	      mostrarMensaje(data.mensaje);
        	      limpiarFormulario();
        	      validator.resetForm();
              },
              error: function(){
        	      mostrarMensaje(MSG_ERROR);
              }
            });
        
        }
    });
    
    $("#id_btn_limpiar").click(function(){
		 limpiarFormulario();
    });
    
    /* LLENADO DE LOS CBO DE CATEGORIA, PAIS Y ESTADO */
    $.getJSON("cargaCategoria",{},function (data){ // se llama del cbo servelt
	    $.each(data,function(index, item){ //for.each => $.each
		    $("#id_categoria").append("<option value="+ item.idCategoria +">"+ item.nombreCategoria +"</option>"); //le setea el valor de su id categoria al value
	    });
    });

    $.getJSON("cargaPais",{},function (data){
 	   $.each(data,function(index, item){
 		   $("#id_pais").append("<option value="+ item.idpais +">"+ item.nombrepais +"</option>");
 	   });
    }); 
    
    $.getJSON("cargaEstado",{},function (data){
  	   $.each(data,function(index, item){
  		   $("#id_estado").append("<option value="+ item.idestado +">"+ item.estado +"</option>");
  	   });
     });
     
     /* función para limpiar el formulario dps de un registro */
     function limpiarFormulario(){	
		$('#id_nombre').val('');
		$('#id_apellido').val('');
		$('#id_direccion').val('');
		$('#id_dni').val('');
		$('#id_genero').val('');
		$('#id_celular').val('');
		$('#id_correo').val('');
		$('#id_pais').val('');
		$('#id_usuario').val('');
		$('#id_contraseña').val('');
		$('#id_categoria').val('');
		$('#id_estado').val('');
	} 