const CadastroMunicipioController = {
	
	carregarComboEmissoraFiltro(){
		
		let urlComboEmissora = $('#urlBackEnd').val()+"emissoras";
		if($('#selectEstadoId').val() == '' && $('#selectGrupoId').val() == ''){
			return;
		}
		let url = urlComboEmissora+"/findEmissorasByGrupoAndEstado/";
		if($('#selectEstadoId').val() == ''){
			url = urlComboEmissora+"/findEmissorasByGrupo/"+$('#selectGrupoId').val();
			SelectUtil.carregarSelect(url,"selectEmissoraId","msgId");
			return;
		}
		if($('#selectGrupoId').val() == ''){
			url = urlComboEmissora+"/findEmissorasByEstado/"+$('#selectEstadoId').val();
			SelectUtil.carregarSelect(url,"selectEmissoraId","msgId");
			return;
		}
		SelectUtil.carregarSelect(url+$('#selectGrupoId').val()+"/"+$('#selectEstadoId').val(),"selectEmissoraId","msgId");
		
	},
		
	init(){
		let urlComboGrupo = $('#urlBackEnd').val()+"grupoEmissora/";
		let urlComboEstado = $('#urlBackEnd').val()+"grupoEmissora/estados/";
		let urlComboEmissora = $('#urlBackEnd').val()+"emissoras";
		
		$('#tableMunicipio').dataTable().fnClearTable();
	    $('#tableMunicipio').dataTable().fnDestroy();
	    $('#tableMunicipio').DataTable( {
		    language: {
		        url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/pt_br.json'
		    }
		});
		
    	SelectUtil.carregarSelect(urlComboGrupo,"selectGrupoId","msgId");
	    SelectUtil.carregarSelect(urlComboEstado,"selectEstadoId","msgId");
	    
		$('#selectGrupoId').on('change', function() {
			CadastroMunicipioController.carregarComboEmissoraFiltro();
		});
		$('#selectEstadoId').on('change', function() {
			CadastroMunicipioController.carregarComboEmissoraFiltro();
		});
	    
	},
	
	pesquisar(isFiltroAtivo){
		
		$("#loadingId").removeClass("oculta");
		MsgAlert.cleanMsgAlert("msgId");
	    $('#tableMunicipio').dataTable().fnClearTable();
	    $('#tableMunicipio').dataTable().fnDestroy();
	    
	    let valEmissora = $('#selectEmissoraId').val();
//	    let valEstado = $('#selectEstadoId').val();
	    
	    if(valEmissora == '' && isFiltroAtivo){
	    	MsgAlert.setMsgAlertTime("msgId", "alert-warning", "Use o painel de pesquisa para filtrar e escolher a emissora",5000);
	    	$("#loadingId").addClass("oculta");
	    	return;
	    }
	    
	    let objectGet = new Object();
	    objectGet.url = $('#urlBackEnd').val()+"emissoras/";
	    objectGet.acao = "GET";
	    
	    $.ajax({
	    	headers: {
	            'Authorization': '',
	            'Content-Type': 'application/json'
	        },
	        type: "POST",
	        url: "/chamadaBE",
	        dataType: "json",
	        cache: false,
	        data: JSON.stringify(objectGet),
	        success: function(retorno) {
	        	let html = ``
	        	$(retorno.response).each(function(index, data) {
	        		html += `<option value=${data.id} >${data.nome}</option>`
	        	});
	        	CadastroMunicipioController.carregarTable(html,isFiltroAtivo);
	        } 
	    });
	},
	carregarTable(comboEmissorasED,isFiltroAtivo){
		
		let valEmissora = $('#selectEmissoraId').val();
	    let valEstado = $('#selectEstadoId').val();
	    
	    let url = $('#urlBackEnd').val()+"/municipio/findMunicipiosSemEmissoras";
	    
	    if(isFiltroAtivo){
	    	url = $('#urlBackEnd').val()+"responsabilidadeSinal/"+valEstado+"/"+valEmissora;
	    }
	    
	    let objectGet = new Object();
	    objectGet.url = url;
	    objectGet.acao = "GET";
	    
		$.ajax({
			headers: {
	            'Authorization': '',
	            'Content-Type': 'application/json'
	        },
		    type: "POST",
		    url: "/chamadaBE",
		    dataType: "json",
		    cache: false,
		    data: JSON.stringify(objectGet),
	        success: function(retorno) {
	        	$(retorno.response).each(function(index, data) {
	        		
	        		let retorno = {};
	        		retorno.estado = {};
	        		retorno.municipio = {};
	        		
	        		if(isFiltroAtivo){
	        			retorno.id = data.id.municipio.estado.id+'-'+data.id.municipio.id;
		        		retorno.estado.id = data.id.municipio.estado.id;
		        		retorno.municipio.nome = data.id.municipio.nome;
						retorno.municipio.id = data.id.municipio.id;
						$("#tableMunicipio").find('tbody').append(CadastroMunicipioTemplate.itemLinha(retorno,comboEmissorasED));
						return;
	        	    }
	        		
	        		retorno.id = data.municipio.estado.id+'-'+data.municipio.id;
	        		retorno.estado.id = data.municipio.estado.id;
	        		retorno.municipio.nome = data.municipio.nome;
					retorno.municipio.id = data.municipio.id;
	        		
	        		$("#tableMunicipio").find('tbody').append(CadastroMunicipioTemplate.itemLinha(retorno,comboEmissorasED));
        		});
	        }, 
	        error: function (data) {  
	        	console.log(data);
	        	if(data.responseJSON == undefined){
	        		MsgAlert.setMsgAlert("msgId", "alert-danger", "Erro no servi\u00e7o do Info Atlas");
	        	}
	        },
	        complete: function(data) { 
	        	$('#tableMunicipio').DataTable( {
	        	    language: {
	        	        url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/pt_br.json'
	        	    }
	        	});
	        	let emissoraSelecionada = $( "#selectEmissoraId  :selected" ).text();
	        	$('.selectpicker').selectpicker('refresh');
	        	$('select[name=selectEmissoraEd]').val( $('option:contains("'+emissoraSelecionada+'")').val()).change().selectpicker('refresh');
	        	$("#loadingId").addClass("oculta");
	        }
	    });
	},
	
	salvar(id, linha){
		
		let formControl = new Object();
		formControl  = $('#formId').serializeJSON();
		formControl.idMunicipio =  $("#"+id+"-id").val();
		formControl.idEmissora = $("#"+id+"-selectEmissoraEd").val();
		
		let myJsonData = JSON.stringify(formControl);
		
		let objectGet = new Object();
		objectGet.url = $('#urlBackEnd').val()+"responsabilidadeSinal/salvar";
		objectGet.acao = "POST";
		objectGet.objetoPOST = JSON.stringify(formControl);
		
		$.ajax({
			headers: {
		        'Authorization': '',
		        'Content-Type': 'application/json'
		    },
		    type: "POST",
		    url: "/chamadaBE",
		    dataType: "json",
		    cache: false,
		    data: JSON.stringify(objectGet),
	        success: function(retorno) {
	        	window.scrollTo(0,0);
	        	MsgAlert.setMsgAlertTime("msgIdTable", "alert-success", "Salvo com sucesso!",2000);
	        },
	        error: function (data) {  
	        	window.scrollTo(0,0);
	        	console.log(data);
	    		MsgAlert.setMsgAlert("msgIdTable", "alert-danger", "Erro no servi\u00e7o do Info Atlas");
	        },
	    });

	}
};
$( document ).ready(function() {
	CadastroMunicipioController.init();
});