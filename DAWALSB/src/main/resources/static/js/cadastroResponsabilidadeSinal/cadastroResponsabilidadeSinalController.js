const CadastroResponsabilidadeSinalController = {
		
		
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
		
		$('#tableRespSinal').dataTable().fnClearTable();
	    $('#tableRespSinal').dataTable().fnDestroy();
	    $('#tableRespSinal').DataTable( {
		    language: {
		        url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/pt_br.json'
		    }
		});
	    
    	SelectUtil.carregarSelect(urlComboGrupo,"selectGrupoId","msgId");
	    SelectUtil.carregarSelect(urlComboEstado,"selectEstadoId","msgId");
	    
		$('#selectGrupoId').on('change', function() {
			CadastroResponsabilidadeSinalController.carregarComboEmissoraFiltro();
		});
		$('#selectEstadoId').on('change', function() {
			CadastroResponsabilidadeSinalController.carregarComboEmissoraFiltro();
		});
	},
	
	pesquisar(){
		
		$("#loadingId").removeClass("oculta");
		MsgAlert.cleanMsgAlert("msgId");
	    $('#tableRespSinal').dataTable().fnClearTable();
	    $('#tableRespSinal').dataTable().fnDestroy();
	    
	    let valEmissora = $('#selectEmissoraId').val();
	    let valEstado = $('#selectEstadoId').val();
	    
	    if(valEmissora == ''){
	    	MsgAlert.setMsgAlertTime("msgId", "alert-warning", "Use o painel de pesquisa para filtrar e escolher a emissora",5000);
	    	$("#loadingId").addClass("oculta");
	    	return;
	    }
	    
	    let objectGet = new Object();
	    objectGet.url = $('#urlBackEnd').val()+"responsabilidadeSinal/"+valEstado+"/"+valEmissora;
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
	        		let id = data.id.municipio.estado.id+'-'+data.id.municipio.id;
	        		let comboEmissorasED = CadastroResponsabilidadeSinalTemplate.comboRespSinaTable(id, data.emissora.nome, data.nomeResponsavel);
	        		$("#tableRespSinal").find('tbody').append(CadastroResponsabilidadeSinalTemplate.itemLinha(id, data, comboEmissorasED));
        		});
	        }, 
	        error: function (data) {  
	        	console.log(data);
	        	if(data.responseJSON == undefined){
	        		MsgAlert.setMsgAlert("msgId", "alert-danger", "Erro no servi\u00e7o do Info Atlas");
	        	}
	        },
	        complete: function(data) { 
	        	$('#tableRespSinal').DataTable( {
	        	    language: {
	        	        url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/pt_br.json'
	        	    }
	        	});
	        	$('.selectpicker').selectpicker('refresh');
	        	$("#loadingId").addClass("oculta");
	        }
	    });
	},
	salvar(id){
		
		let formControl = new Object();
		formControl  = $('#formId').serializeJSON();
		
		formControl.idMunicipio =  $("#"+id+"-id").val();
		formControl.responsabilidadeSinal = $("#"+id+"-selectEmissoraEd").val();
		formControl.potencia = $("#"+id+"-qtdPotencia").val();
		formControl.canal = $("#"+id+"-canalNumero").val();
		formControl.decalagem = $("#"+id+"-selectDecalagem").val();
		formControl.sateliteRegional = $("#"+id+"-satRegional").is(':checked')?'S':'N';
        
		let objectGet = new Object();
		objectGet.url = $('#urlBackEnd').val()+"responsabilidade/salvar";
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
	},
	
	editarModal(uf,municipioId){
		$('#myModal').html(CadastroResponsabilidadeSinalTemplate.geradoraOrigemModal(uf,municipioId)).show();
//		$('.selectpicker').selectpicker('refresh');
		let urlComboMunicipio = $('#urlBackEnd').val()+"municipio/"+uf;
		let urlComboEmissora = $('#urlBackEnd').val()+"emissoras/";
		
		$('#tableGeradoraOrigem').dataTable().fnClearTable();
	    $('#tableGeradoraOrigem').dataTable().fnDestroy();
	    $('#tableGeradoraOrigem').DataTable( {
		    language: {
		        url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/pt_br.json'
		    }
		});

    	SelectUtil.carregarSelect(urlComboMunicipio,"selectMunicipioIdModal","msgIdModal");
	    SelectUtil.carregarSelect(urlComboEmissora, "selectEmissoraIdModal","msgIdModal");
	},
	
	atualizarGeradora(idMunicipioOrigem, idEmissoraOrigem){
		
		let formControl = new Object();
		formControl  = $('#formId').serializeJSON();
		
		formControl.idMunicipio =  $("#municipioIdResp").val();
		formControl.idMunicipioOrigem = idMunicipioOrigem;
		formControl.idEmissoraOrigem = idEmissoraOrigem;
		
		let objectGet = new Object();
		objectGet.url = $('#urlBackEnd').val()+"responsabilidade/atualizarGeradora";
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
	        	MsgAlert.setMsgAlertTime("msgIdModal", "alert-success", "Salvo com sucesso!",2000);
	        },
	        error: function (data) {  
	        	window.scrollTo(0,0);
	        	console.log(data);
        		MsgAlert.setMsgAlert("msgIdModal", "alert-danger", "Erro no servi\u00e7o do Info Atlas");
	        },
	    });
		
	},
	
	deletar(idMunicipio){
		
		let formControl = new Object();
		formControl  = $('#formId').serializeJSON();
		
		formControl.idMunicipio =  idMunicipio;
		
		let objectGet = new Object();
		objectGet.url = $('#urlBackEnd').val()+"responsabilidade/excluir";
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
	        	MsgAlert.setMsgAlertTime("msgIdTable", "alert-success", "Excluido com sucesso!",2000);
	        },
	        error: function (data) {  
	        	window.scrollTo(0,0);
	        	console.log(data);
        		MsgAlert.setMsgAlert("msgIdTable", "alert-danger", "Erro no servi\u00e7o do Info Atlas");
	        },
	    });
		
	},
	
	pesquisarGeradoraOrigem(uf){
		
		$("#loadingIdModal").removeClass("oculta");
		MsgAlert.cleanMsgAlert("msgIdModal");
	    $('#tableGeradoraOrigem').dataTable().fnClearTable();
	    $('#tableGeradoraOrigem').dataTable().fnDestroy();
	    
	    let valEmissora = $('#selectEmissoraIdModal').val();
	    let valMunicipio = $('#selectMunicipioIdModal').val();
	    let url = $('#urlBackEnd').val()+"responsabilidadeSinal/"+valEmissora;
	    
	    if($('#selectMunicipioIdModal').val()!=''){
	    	url = $('#urlBackEnd').val()+"responsabilidadeSinal/"+uf+"/"+valMunicipio+"/"+valEmissora;
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
	        		$("#tableGeradoraOrigem").find('tbody').append(CadastroResponsabilidadeSinalTemplate.itemLinhaGeradoraOrigem(data));
        		});
	        }, 
	        error: function (data) {  
	        	console.log(data);
	        	if(data.responseJSON == undefined){
	        		MsgAlert.setMsgAlert("msgIdModal", "alert-danger", "Erro no servi\u00e7o do Info Atlas");
	        	}
	        },
	        complete: function(data) { 
	        	$('#tableGeradoraOrigem').DataTable( {
	        	    language: {
	        	        url: '//cdn.datatables.net/plug-ins/1.11.3/i18n/pt_br.json'
	        	    }
	        	});
	        	$("#loadingIdModal").addClass("oculta");
	        }
	    });
	},
	
	donwload(acao, nomeDocumento, filtroEmissora){
		
		let downloadUrl = $('#urlBackEnd').val()+"responsabilidadeXLS/planilha/"+acao;
		
		if(filtroEmissora &&  $('#selectEmissoraId').val() == ''){ 
			MsgAlert.setMsgAlertTime("msgId", "alert-warning", "Selecione uma emissora.",2000);
			return;
		}
		
		if(filtroEmissora){ 
			downloadUrl += '/'+ $('#selectEmissoraId').val()
		}
		
		$("#loadingId").removeClass("oculta");
		
		let objectGet = new Object();
		objectGet.url = downloadUrl;
		objectGet.acao = nomeDocumento;
		
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "/chamadaBEDownload");
		xhr.responseType = 'blob';
		xhr.setRequestHeader("Content-Type", "application/json");

		xhr.onload = function(e) {
		    if (this.status == 200) {
		        var blob = new Blob([this.response], {type: 'text/csv'|'application/vnd.ms-excel'});
		        var a = document.createElement("a");
		        a.href = URL.createObjectURL(blob);
		        a.download = nomeDocumento;
		        document.body.appendChild(a);
		        a.click();
		    } else {
		        alert('Unable to download excel.')
		    }
		    $("#loadingId").addClass("oculta");
		};

		xhr.send(JSON.stringify(objectGet));
	}
	
};
$( document ).ready(function() {
	CadastroResponsabilidadeSinalController.init();
});