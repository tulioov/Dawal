const LoginController = {
		
	init(){
		$("form").submit(function(){
			$("#loadingId").removeClass("oculta");
			$("#msgId").addClass("oculta");
			$("#btnEntrarId").attr('disabled', 'disabled');
		});
	}
};

$( document ).ready(function() {
	LoginController.init();
});
