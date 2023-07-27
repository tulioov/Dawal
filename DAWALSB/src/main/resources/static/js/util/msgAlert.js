const MsgAlert = {
		
	setMsgAlert(msgComponentId, type, msg){
		$("#"+msgComponentId).find('div').addClass("alert").addClass(type).html(msg);
		MsgAlert.ocultarLoad();
	},
	setMsgAlertTime(msgComponentId, type, msg, mSecond){
		MsgAlert.setMsgAlert(msgComponentId, type, msg);
		MsgAlert.ocultarLoad();
		setTimeout(function () {
			MsgAlert.cleanMsgAlert(msgComponentId);
		}, mSecond);
	},
	cleanMsgAlert(msgComponentId){
		$("#"+msgComponentId).html('<div></div>');
	},
	ocultarLoad(){
		if($("#loadingId") != undefined){
			$("#loadingId").addClass("oculta");
		}
	}
};