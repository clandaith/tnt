$(document).ready(function () {
	
	$(".nameTabChange").change(function () {
		var id = $(this).attr('nameFieldId');
		$("#tabText-" + id).text($(this).val());		
	});
	
//	$('.printWarband').click(function () {
//		$('#warbandForm').attr('target', '_blank');
//		$("#warbandForm").attr("action", "/print");
//		$('#warbandForm').submit();
//	});	

	
	$('.deleteWarband').click(function () {
		if (confirm('Are you sure you want to delete this warband?')) {
			var warbandId = $(this).attr("id").replace("warbandDelete-","");
			$("#deleteWarbandForm").attr("action", "/warbands/" + warbandId);
			$('#deleteWarbandForm').submit();
		}else{
			return false;
		}
	});
		
	$('.deleteCharacter').click(function () {
		if (confirm('Are you sure you want to remove this character?')) {
			$('#warbandForm').submit();
		}else{
			return false;
		}
	});
});


function openWarbandCharacter(evt, warbandCharacterId) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(warbandCharacterId).style.display = "block";
    evt.currentTarget.className += " active";
}
