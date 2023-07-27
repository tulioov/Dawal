
const CadastroResponsabilidadeSinalTemplate = {
		
	geradoraOrigemModal (uf, municipioId){
		return `
		<div class="modal-dialog modal-lg ">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title">Geradora de origem</h5>
	            </div>
	            <div class="modal-body">
		            
	                <form id="formId">
	                	<input type="text" id="municipioIdResp" name="id" value=${municipioId} class="oculta">
		                <div class="panel panel-default">
		                	<div class="panel-heading">Painel de pesquisa para emissora</div>
		                	<div class="col-md-12 mt15" style="text-align: center;">
								<div id="loadingIdModal" class="spinner-border text-primary oculta" role="status"></div>
								<div id="msgIdModal">
									<div></div>
								</div>
							</div>
		                	<div class="panel-body">
			                	<div class="row">
			                		<div class="col-md-4" style="display: table;">
										<div>Estado: </div>
										<label>${uf}</label>
									</div>
			                		<div class="col-md-4" style="display: table;">
										<div>Municipio de ${uf}: </div>
										<div id="loadingId-selectMunicipioIdModal" class="spinner-border text-primary oculta" role="status"></div>
										<select id="selectMunicipioIdModal" class="selectpicker" data-live-search="true" title="Escolha uma opcao">
										<option value='' >Nenhum selecionado</option>
										</select>
									</div>
									
									<div class="col-md-4" style="display: table;">
										<div>Emissora (*): </div>
										<div id="loadingId-selectEmissoraIdModal" class="spinner-border text-primary oculta" role="status"></div>
										<select id="selectEmissoraIdModal" name="idEmissora" class="selectpicker" data-live-search="true" title="Escolha uma opcao">
										</select>
									</div>
								</div>
								<button type="button" class="btn btn-primary mt15" onClick="CadastroResponsabilidadeSinalController.pesquisarGeradoraOrigem('${uf}')">
									Pesquisar
								</button>
							</div>
						</div>
						<hr>
						<div class="row mt15">
						<div class="col-md-12" style="display: table;">
							<table id="tableGeradoraOrigem" class="display">
								<thead>
							    <tr>
							        <th>UF</th>
							        <th>Municipio</th>
							        <th>A&ccedil;&atilde;o</th>
							    </tr>
								</thead>
								<tbody></tbody>
							</table>
						</div>
		    		</div>
			        </form>
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-danger" onClick="$('#myModal').hide();" data-dismiss="modal">Fechar</button>
	            </div>
	        </div>
	    </div>
		`;
	},
	itemLinhaGeradoraOrigem(data){
		
		return `
			<tr>
				<td>${data.id.municipio.estado.id}</td>
				<td>${data.id.municipio.nome} - ${data.emissora.sigla}</td>
				<td>
					<span onclick="CadastroResponsabilidadeSinalController.atualizarGeradora('${data.id.municipio.id}',${data.emissora.id});" title="Salvar" class="fas fa-save""></span>
				</td>
			</tr>
		`;
		
	},
	
	comboRespSinaTable(id, emissoraNome, valueTxt){
		
		return `
			<select id="${id}-selectEmissoraEd" name="selectEmissoraEd" class="selectpicker" data-live-search="true" title="Escolha uma opcao">
				<option ${valueTxt == 0?'selected':''} value=0 >${emissoraNome}</option>
				<option ${valueTxt == 1?'selected':''} value=1 >${emissoraNome} / PREFEITURA</option>
				<option ${valueTxt == 2?'selected':''} value=2 >SAT\u00c9LITE (RJ)</option>
				<option ${valueTxt == 3?'selected':''} value=3 >OUTRA GERADORA</option>
				<option ${valueTxt == 4?'selected':''} value=4 >N\u00c3O ATENDIDO</option>
			</select>
		`;
		
	},
	
	itemLinha(id, data, comboEmissora){
		
		let municipioOrigemNome = data.municipioOrigem == undefined?'-':data.municipioOrigem.nome;
		
		return `
			<tr>
				<td>${data.id.municipio.estado.id}</td>
				<td>${data.id.municipio.nome}
					<input type="text" id="${id}-id" class="oculta" value=${data.id.municipio.id}>
				</td>
				<td>
					${comboEmissora}
				</td>
				<td><input id="${id}-qtdPotencia" type="number" name="quantidadePotencia" class="form-control" value="${data.quantidadePotencia}" ></td>
				<td><input id="${id}-canalNumero" type="number" name="canalNumero" class="form-control" value="${data.canalNumero}" ></td>
				<td>
					<select id="${id}-selectDecalagem" class="selectpicker" data-live-search="true" title="Escolha uma opcao" style="width: auto;!important">
						<option ${data.decalagem == null?'selected':''}></option>
						<option ${data.decalagem == '+'?'selected':''} value=+ >+</option>
						<option ${data.decalagem == '-'?'selected':''} value=- >-</option>
					</select>
				</td>
				<td>
					<div class="material-switch pull-right">
                        <input id="${id}-satRegional" name="satRegidonal" ${data.sateliteRegional=="N"?'':'checked'} type="checkbox"/>
                        <label for="${id}-satRegional" class="label-success"></label>
                    </div>
				</td>
				<td>
					<div class="reticencia">
						<i class="fas fa-info-circle ${data.emissoraOrigem==null?'oculta':''}" title="${data.emissoraOrigem==null?' - ':'Municipio: '+ municipioOrigemNome +' Emissora: '+ data.emissoraOrigem.nome}"></i>
						${data.emissoraOrigem==null?'-':municipioOrigemNome +'-'+ data.emissoraOrigem.nome}</td>
					</div>
				</td>
				<td>
					<span onclick="CadastroResponsabilidadeSinalController.salvar('${id}');" title="Salvar linha editada" class="glyphicon fas fa-save""></span>
					<span onclick="CadastroResponsabilidadeSinalController.editarModal('${data.id.municipio.estado.id}',${data.id.municipio.id});" title="Editar Geradora de origem" class="glyphicon glyphicon-pencil"></span>
					<span onclick="CadastroResponsabilidadeSinalController.deletar(${data.id.municipio.id});" class="glyphicon glyphicon-trash"></span>
				</td>
			</tr>
		`;
		
	}
	
};