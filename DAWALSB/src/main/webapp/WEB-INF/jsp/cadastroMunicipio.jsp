<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt">
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.css">
	<link href="./externo/bootstrap-4.6.1/css/bootstrap.min.css" rel="stylesheet">
	<link rel="icon" type="image/png" sizes="96x96" href="./img/favicon/favicon-96x96.png">
	<link href="./externo/bootstrap-4.6.1/css/bootstrap.min.css" rel="stylesheet">
	<title>De-para de Municípios</title>
</head>
<body>

	<jsp:include page="./header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<form id="formId" class="col-md-12">
                <div class="panel panel-default mt15">
                	<div class="panel-heading">Painel de pesquisa</div>
                	<div class="col-md-12 mt15" style="text-align: center;">
						<div id="loadingId" class="spinner-border text-primary oculta" role="status"></div>
						<div id="msgId">
							<div></div>
						</div>
					</div>
                	<div class="panel-body">
	                	<div class="row">
	                		<div class="col-md-4" style="display: table;">
								<div>Grupo: </div>
								<div id="loadingId-selectGrupoId" class="spinner-border text-primary oculta" role="status"></div>
								<select id="selectGrupoId" name="idGrupo" class="selectpicker" data-live-search="true" title="Escolha uma opcao">
									<option value='' >Nenhum selecionado</option>
								</select>
							</div>
							<div class="col-md-4" style="display: table;">
								<div>Estado: </div>
								<div id="loadingId-selectEstadoId" class="spinner-border text-primary oculta" role="status"></div>
								<select id="selectEstadoId" name="idEstado" class="selectpicker" data-live-search="true" title="Escolha uma opcao">
									<option value='' >Nenhum selecionado</option>
								</select>
							</div>
							<div class="col-md-4" style="display: table;">
								<div>Emissora (*): </div>
								<div id="loadingId-selectEmissoraId" class="spinner-border text-primary oculta" role="status"></div>
								<select id="selectEmissoraId" name="idEmissora" class="selectpicker" data-live-search="true" title="Escolha uma opcao">
								</select>
							</div>
						</div>
						<div class="row mt15">
							<div class="col-md-12">
								<button id="salvarIdButton" type="button" class="btn btn-primary" onClick="CadastroMunicipioController.pesquisar()">
									Ver Municipios sem emissora
								</button>
							    <button id="salvarIdButton" type="button" class="btn btn-primary" onClick="CadastroMunicipioController.pesquisar(true)">
									Pesquisar
								</button>
							</div>
						</div>
					</div>
				</div>
				<div class="panel panel-default mt15">
					<div class="panel-heading">Resultado da pesquisa</div>
					<div class="col-md-12 mt15" style="text-align: center;">
						<div id="msgIdTable">
							<div></div>
						</div>
					</div>
					<div class="panel-body">
						<div class="row mt15">
							<div class="col-md-12" style="display: table;">
								<table id="tableMunicipio" class="display">
									<thead>
								    <tr>
								        <th>UF</th>
								        <th>Municipio</th>
								        <th>Emissora</th>
								        <th>A&ccedil;&atilde;o</th>
								    </tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
			    		</div>
			    	</div>
			    </div>
	        </form>
		</div>
		<div class="modal scroll" id="myModal">
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
	<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.js"></script>
	<script src="./externo/serializejson/serializejson.js"></script>
	<script src="./externo/bootstrap-4.6.1/js/bootstrap.bundle.min.js"></script>
	<script src="./js/util/selectUtil.js"></script>
	<script src="./js/util/msgAlert.js"></script>
	<script src="./js/cadastroMunicipio/cadastroMunicipioTemplate.js"></script>
	<script src="./js/cadastroMunicipio/cadastroMunicipioController.js"></script>
</body>
</html>
