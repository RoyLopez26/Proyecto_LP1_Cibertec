<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<link rel="stylesheet" href="css/CSSregistrarResponsable.css">

<title>Registrar Responsable</title>
</head>
<body>
<header class="headerr">
       <div class="contenedor_tituloimagen">
          <div class="titutlo-cn-imagen">
            <h1 class="tit">Registrar un nuevo responsable</h1>
            <img class="imagen_responsable" alt="" src="./imagenes/imagenResponsable.png">
          </div>
       </div>
</header>

<div class="container">
<br>
<br>
    <div class="contenedor-p">
       <p class="par">Para registrar un nuevo <span class="spn1" onclick="mostrarMensaje()">responsable</span>, es necesario completar el formulario que se muestra en pantalla. Sin embargo, se recomienda revisar y verificar los datos registrados en el formulario antes de enviarlo, con el fin de evitar posibles errores y confusiones. Estos datos podrán ser modificados más adelante si es necesario.</p>
    </div>
    
	<div class="contenedor_form_imagen">
	   <form action="registraResponsable" id="id_form"> 
	        <h2>Formulario de registro</h2>
	
			<input type="hidden" name="metodo" value="registra">	
			<div class="form-group">
				<label class="control-label" for="id_nombre">Nombres</label>
				<input class="form-control" type="text" id="id_nombre" name="nombre" placeholder="Ingrese el nombre">
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_apellido">Apellidos</label>
				<input class="form-control" type="text" id="id_apellido" name="apellido" placeholder="Ingrese el apellido">
			</div>
			
			<div class="form-group">
			    <label class="control-label" for="id_direccion">Dirección</label>
			    <input class="form-control" type="text" id="id_direccion" name="direccion" placeholder="Ingrese su dirección" maxlength="35">
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_dni">DNI</label>
				<input class="form-control" type="text" id="id_dni" name="dni" placeholder="Ingrese su DNI">
			</div>
			
			<div class="form-group">
			    <label class="control-label" for="id_genero">Género</label>
			    <input class="form-control" type="text" id="id_genero" name="genero" placeholder="Ingrese su género">
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_celular">Celular</label>
				<input class="form-control" type="text" id="id_celular" name="celular" placeholder="Ingrese su celular">
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_correo">Correo</label>
				<input class="form-control" type="text" id="id_correo" name="correo" placeholder="Ingrese su correo" maxlength="30">
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_pais"> País </label> <select
					class="form-control" id="id_pais" name="pais">
					<option value=" ">Seleccione...</option>
				</select>
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_usuario">Usuario</label>
				<input class="form-control" type="text" id="id_usuario" name="usuario" placeholder="Ingrese su usuario" maxlength="5">
			</div>
			
			<div class="form-group">
			    <label class="control-label" for="id_contraseña">Contraseña</label>
			    <input class="form-control" type="password" id="id_contraseña" name="contraseña" placeholder="Ingrese su contraseña" maxlength="7">
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_categoria"> Categoría </label> <select
					class="form-control" id="id_categoria" name="categoria">
					<option value=" ">Seleccione...</option>
				</select>
			</div>
			
			<div class="form-group">
				<label class="control-label" for="id_estado"> Estado </label> <select
					class="form-control" id="id_estado" name="estado">
					<option value=" ">Seleccione...</option>
				</select>
			</div>
			
			<br>
			<div class="form-groupButtons">
				<button type="button" class="btn btn-success" id="id_btn_registra">Registrar Responsable</button>
				<button type="button" class="btn btn-danger" id="id_btn_limpiar">Limpiar formulario</button>
			</div>
	    </form>
	    <div>
	       <img class="imagenRegistroForm" alt="" src="./imagenes/llenadoFormulario.jpg">
	    </div>
	</div>
</div>

<script type="text/javascript">
$("#success-alert").fadeTo(1000, 500).slideUp(500, function(){
    $("#success-alert").slideUp(500);
});
</script>

<script>
  function mostrarMensaje() {
    var mensaje = "El término \"responsable\" se utiliza para referirse a la entidad encargada de interactuar con una categoría específica durante el proceso de obtención de las licencias de funcionamiento.\n\nLas categorías de responsables incluyen:\n\n1) Administrador\n2) Asesor de Plataforma\n3) Cajero\n4) Secretaria General\n5) Inspector Técnico\n6) Subgerente\n7) Técnico Administrativo\n8) Asesor Legal";
    alert(mensaje);
  }
</script>

<script type="text/javascript">
$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        
        fields:{
        	nombre : {  
        		selector: "#id_nombre",
        		validators : {
        			notEmpty: {
                        message: 'El nombre es requerido'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'El nombre debe contener de 3 a 20 caracteres'
                    },
        		}
        	},
        	apellido : {  
        		selector: "#id_apellido",
        		validators : {
        			notEmpty: {
                        message: 'El apellido es requerido'
                    },
                    stringLength: {
                        min: 3,
                        max: 20,
                        message: 'El apellido debe contener de 3 a 20 caracteres'
                    },
        		}
        	},
        	direccion : {  
        		selector: "#id_direccion",
        		validators : {
        			notEmpty: {
                        message: 'La dirección del responsable es requerida'
                    },
                    regexp: {
                        regexp: /^[.a-zA-Z0-9 ]+$/,
                        message: 'Ingrese una direccion válida'
                    },
        		}
        	},
        	dni : {
        		selector: "#id_dni",
        		validators : {
        			notEmpty: {
                        message: 'El dni es requerido'
                    },
                    regexp: {
                        regexp: /^[0-9]{8}$/,
                        message: 'El dni tiene 8 dígitos'
                    },
        		}
        	},
        	genero : { 
        		selector: "#id_genero",
        		validators : {
        			notEmpty: {
                        message: 'El genero es requerido'
                    },
                    regexp: {
                        regexp: /^(F|M)$/,
                        message: 'El género debe ser F (femenino) o M (masculino)'
                    },
        		}
        	},
        	celular : {
        		selector: "#id_celular",
        		validators : {
        			notEmpty: {
                        message: 'El celular es requerido'
                    },
                    regexp: {
                        regexp: /^[0-9]{9}$/,
                        message: 'El celular debe tener 9 dígitos'
                    },
        		}
        	},
        	correo: {
                validators: {
                    notEmpty: {
                        message: 'The email address is required and can\'t be empty'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            },
        	pais : {
        		selector: "#id_pais",
        		validators : {
        			notEmpty: {
                        message: 'El país es requerido'
                    },
        		}
        	},
        	usuario : {  
        		selector: "#id_usuario",
        		validators : {
        			notEmpty: {
                        message: 'El usuario es requerido'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9]{5}$/,
                        message: 'El usuario debe contener 5 caracteres, entre ellos letras y números'
                    },
        		}
        	},
        	contraseña : {  
        		selector: "#id_contraseña",
        		validators : {
        			notEmpty: {
                        message: 'La contraseña es requerida'
                    },
                    regexp: {
                        regexp: /[a-zA-Z0-9]{7}/,
                        message: 'La contraseña debe contener 7 caracteres, entre ellos letras y números'
                    },
        		}
        	},
        	categoria : {
        		selector: "#id_categoria",
        		validators : {
        			notEmpty: {
                        message: 'La categoría es requerida'
                    },
        		}
        	},  
        	estado : {
        		selector: "#id_estado",
        		validators : {
        			notEmpty: {
                        message: 'El estado es requerido'
                    },
        		}
        	}, 
        } 
    });

});
</script>

<script type="text/javascript" src="js/JSvalidacionesRegistrarResponsable.js"></script>

</body>
</html>