const SelectUtil = {
		
	showLoad(selectId){
		$("#loadingId-"+selectId).removeClass("oculta");
		$("#"+selectId).selectpicker('hide');
	},
	
	ocultaLoad(selectId){
		$("#loadingId-"+selectId).addClass("oculta");
		$("#"+selectId).selectpicker('show');
	},
	
	montarSelect(nomeComponente,url, callBack){
		
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
	        	let html = `<select id="${nomeComponente}Id" name="${nomeComponente}" class="selectpicker" data-live-search="true" title="Escolha uma opcao">`
	        	$(retorno.response).each(function(index, data) {
	        		html += `<option value='+data.id+' >'+data.nome+'</option>`
	        	});
	        	html += `</select>`;
	        	callBack(html);
	        } 
	    });
	},
		
	carregarSelect(url,selectId, msgId){
		
		SelectUtil.resetSelect(selectId,false);
		let objectGet = new Object();
		objectGet.url = url;
		objectGet.acao = "GET"; 
		
		SelectUtil.showLoad(selectId);
		$.ajax({
	        headers: {
	            'Authorization': '',
	            'Content-Type':'application/json'
	        },
	        type: "POST",
	        url: "/chamadaBE",
	        dataType: "json",
	        cache: false,
	        data : JSON.stringify(objectGet),
	        success: function(retorno) {
				$('#'+selectId).append("<option value='' >Nenhum selecionado</option>");
	        	$(retorno.response).each(function(index, data) {
	        		$('#'+selectId).append('<option value='+data.id+' >'+data.nome+'</option>');
	        	});
	        }, 
	        error: function (data) {  
	        	if(data.responseJSON == undefined){
	        		MsgAlert.setMsgAlert("msgId", "alert-danger", "Erro no servi\u00e7o do Info Atlas");
	        	}
	        },complete: function(data) { 
	        	SelectUtil.ocultaLoad(selectId);
	        	$('.selectpicker').selectpicker('refresh');
	        }
	    });
		
	},
	
	resetSelect(selectId,isDisabled){
		$("#"+selectId).empty().selectpicker('refresh');
		if(isDisabled){
			$('#'+selectId).attr("disabled",true);
			$('.selectpicker').selectpicker('refresh');
		}
	}
};