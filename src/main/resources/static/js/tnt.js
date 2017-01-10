$(document).ready(function () {
	
	$(".nameTabChange").change(function () {
		var id = $(this).attr('nameFieldId');
		$("#tabText-" + id).text($(this).val());		
	});
	
//	$('.printWarband').click(function () {
//		$('#warbandForm').attr('target', '_blank');
//		$("#warbandForm").attr("action", "/print");
//		$('#warbandForm').submit();
//		$('#warbandForm').attr('target', '_self');
//		$("#warbandForm").attr("action", "/warband");
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
	
	$(".unitTitle").change(function () {
		var selectedTitleId = $(this).val();
		var tntCharId = $(this).attr("id");
		
		tntCharId = tntCharId.replace("tntCharacters","");
		tntCharId = tntCharId.replace(".warbandUnit","");
		
		//console.log("selectedId: " + selectedTitleId + " :: tntCharId: " + tntCharId);
		
		$(jq("tntCharacters" + tntCharId + ".baseCost")).val(warbandUnits[selectedTitleId].baseCost);
		$(jq("tntCharacters" + tntCharId + ".defense")).val(warbandUnits[selectedTitleId].defense);
		$(jq("tntCharacters" + tntCharId + ".wounds")).val(warbandUnits[selectedTitleId].wounds);
		$(jq("tntCharacters" + tntCharId + ".move")).val(warbandUnits[selectedTitleId].move);
		$(jq("tntCharacters" + tntCharId + ".melee")).val(warbandUnits[selectedTitleId].melee);
		$(jq("tntCharacters" + tntCharId + ".ranged")).val(warbandUnits[selectedTitleId].ranged);
		$(jq("tntCharacters" + tntCharId + ".strength")).val(warbandUnits[selectedTitleId].strength);
		$(jq("tntCharacters" + tntCharId + ".mettle")).val(warbandUnits[selectedTitleId].mettle);
		
	});
	
});

function jq( myid ) {
    return "#" + myid.replace( /(:|\.|\[|\]|,|=)/g, "\\$1" );
}


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
