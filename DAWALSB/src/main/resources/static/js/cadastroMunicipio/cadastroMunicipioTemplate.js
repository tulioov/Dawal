
const CadastroMunicipioTemplate = {
		
	itemLinha(retorno, comboEmissora){
		
		return `
			<tr>
				<td>${retorno.estado.id}</td>
				<td>${retorno.municipio.nome}
					<input type="text" id="${retorno.id}-id" class="oculta" value=${retorno.municipio.id}>
				</td>
				<td>
					<select id="${retorno.id}-selectEmissoraEd" name="selectEmissoraEd" class="selectpicker" data-live-search="true" title="Escolha uma opcao">
						${comboEmissora}
					</select>
				</td>
				<td>
					<span onclick="CadastroMunicipioController.salvar('${retorno.id}', this);" title="Salvar linha editada" class="glyphicon fas fa-save""></span>
				</td>
			</tr>
		`;
	}
};