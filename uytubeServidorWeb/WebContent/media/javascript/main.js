//Crear Lista
$(document).on("submit", "#crearListaForm", function(event) {
    var $form = $(this);

    $.post($form.attr("action"), $form.serialize(), function(response) {
        if (response === "") {
        	window.location.reload(true);
        } else {
        	$("#alertaCrearLista").empty();
        	$("#alertaCrearLista").append(response);
        	$("#alertaCrearLista").addClass("alert");
        }
        
    });

    event.preventDefault();
});

//Cambiar Lista
$(document).on("click", "#botonCambiarLista", function(event) {
	var pri = $("#botonCambiarLista").text();
	var nom = $("title").text();
	
	$.post("/app/cambiar-lista", { nombreLista: nom, privadoLista: pri }, function(response) {
		if (response === "") {
			window.location.reload(true);
		} else {
			$("#alertaCambiarLista").empty();
			$("#alertaCambiarLista").append(response);
			$("#alertaCambiarLista").addClass("alert");
		}
	})
	
});

//Seguir y No seguir
$(document).on("click", "#botonSeguir", function(event) {
	var seg = $("#botonSeguir").text();
	var user = $("title").text();
	
	$.post("/app/seguir", { loSiguen: user, seguir: seg}, function(response) {
		if (response === "") {
			window.location.reload(true);
		} else {
			$("#alertaSeguir").empty();
			$("#alertaSeguir").append(response);
			$("#alertaSeguir").addClass("alert");
		}
	})
	
});

//Agregar o Quitar Video a Lista
$(document).on("click", ".botonAddRemoveVideo", function(event) {
	var boton = $(this);
	var listaVal = boton.text();
	var usrVideoVal = $("#autor").text();
	var videoVal = $("title").text();
	var addVal = boton.hasClass("botonAddVideo");

	$.post("/app/add-remove-video", { lista: listaVal, usrVideo: usrVideoVal, video: videoVal, add: addVal }, function(response) {
		if (response === "") {
			window.location.reload(true);
		} else {
			$("#alertaAddRemove").empty();
			$("#alertaAddRemove").append(response);
		}
	})
});

//Valorar video
$(document).on("click", ".botonValorar", function(event) {
	var videoVal = $("title").text();
	var usrVideoVal = $("#autor").text();
	var gustaVal = $(this).attr('id');
	
	$.post("/app/valorar", { uVideo: usrVideoVal, video: videoVal, gusta: gustaVal }, function(response) {
		if (response === "") {
			window.location.reload(true);
		} else {
			$("#alertaGustar").empty();
			$("#alertaGustar").append(response);
		}
	})
});

//Comentar
$(document).on("submit", "#comentarForm", function(event) {
	var $form = $(this);
	var fechaAhora = new Date().toISOString();
	$("#inputFechaHora").val(fechaAhora);
	
	$.post($form.attr("action"), $form.serialize(), function(response) {
        if (response === "") {
        	window.location.reload(true);
        } else {
        	$("#alertaComentar").empty();
        	$("#alertaComentar").append(response);
        	$("#alertaComentar").addClass("alert");
        }
        
    });
	
	event.preventDefault();
});

//Reply
$(document).on("click", ".botonReply", function(event) {
	var ruta = $(this).attr('id');
	$("#inputRuta").val(ruta);
	document.getElementById("myTab").scrollIntoView();
	document.getElementById("comentarioTextArea").focus();
});

//Sign Up
$(document).on("click", "#botonSubmitSignUp", function(event) {
	var passwordConfirmado = ($("#password").val()) === ($("#confirmarPassword").val());
	
	if (!passwordConfirmado) {
		document.getElementById("confirmarPassword").setCustomValidity("Debe ser igual al password");
		event.preventDefault();
	}
	else
		document.getElementById("confirmarPassword").setCustomValidity("");
});

$(document).on("change", "#selectOrden", function(event) {
	var criterio = $(this).val();
	
	var sort_by_name = function(a, b) {
        return a.innerHTML.toLowerCase().localeCompare(b.innerHTML.toLowerCase());
    }
	
	var sort_by_id= function(a, b) {
        return a.getAttr("id").toLowerCase().localeCompare(b.getAttr("id").toLowerCase());
    }
	
	if (criterio === "alfa") {
		var list = $(".resItem").get();
	    list.sort(sort_by_name);
	    for (var i = 0; i < list.length; i++) {
	        list[i].parentNode.appendChild(list[i]);
	    }
	} else if (criterio === "fecha") {
		var list = $(".resItem").get();
	    list.sort(sort_by_id);
	    for (var i = 0; i < list.length; i++) {
	        list[i].parentNode.appendChild(list[i]);
	    }
	}
});






