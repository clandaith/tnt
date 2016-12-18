$(document).ready(function () {
	
	$('.deleteCharacter').click(function () {
		if (confirm('Are you sure you want to remove this character?')) {
			$('#warbandForm').submit();
		}else{
			return false;
		}
	});

	
	$('.printWarband').click(function () {
		$('#warbandForm').attr('target', '_blank');
		$("#warbandForm").attr("action", "/print");
		$('#warbandForm').submit();
	});
	
	$(".meleeWeapon").change(function () {
		var selected_values = $(this).find("option:selected").map(function () {
			return meleeWeapons[this.text].xpCost;
		}).get();

		var totalXp = $().totalXp(selected_values);
		var charId = $().getCharId($(this), "meleeWeapon");
		$().doAllTotals(charId, totalXp, "melee");
	});

	$(".rangedWeapon").change(function () {
		var selected_values = $(this).find("option:selected").map(function () {
			return rangedWeapons[this.text].xpCost;
		}).get();

		var totalXp = $().totalXp(selected_values);
		var charId = $().getCharId($(this), "rangedWeapon");
		$().doAllTotals(charId, totalXp, "ranged");
	});

	$(".equipment").change(function () {
		var selected_values = $(this).find("option:selected").map(function () {			
			return equipment[this.text].xpCost;
		}).get();

		var totalXp = $().totalXp(selected_values);		
		var charId = $().getCharId($(this), "equipment");
		$().doAllTotals(charId, totalXp, "equipment");
	});

	$(".armour").change(function () {
		var selected_values = $(this).find("option:selected").map(function () {
			return armours[this.text].xpCost;
		}).get();

		var totalXp = $().totalXp(selected_values);
		var charId = $().getCharId($(this), "armour");
		$().doAllTotals(charId, totalXp, "armour");
	});

//	$(".trait").change(function () {
//		var charId = $().getCharId($(this), "trait");
//		var selectBoxName = this.name;
//		
//		var selected_values = $(this).find("option:selected").map(function () {
//			var traitId = this.value;
//			
//			console.log($("#levelTraits-" + charId).val() + " :: " + traitId + " :: " + $("#levelTraits-" + charId).val().indexOf(traitId + ","));
//			
//			if($(this).attr('data-subtext').indexOf("Leveled") > 0 && $("#levelTraits-" + charId).val().indexOf(traitId + ",") < 0){
//				console.log(selectBoxName + " " + this.text + " " + $(this).attr('data-subtext') + " " + traitId);
//				
//				vex.dialog.open({
//				    message: 'Select the level for trait '+this.text+':',
//				    input: [
//				       $().createStartingTraitTextBox(this.value)
//				    ].join(''),
//				    buttons: [
//				        $.extend({}, vex.dialog.buttons.YES, { text: 'Set' }),
//				        $.extend({}, vex.dialog.buttons.NO, { text: 'Cancel' })
//				    ],
//				    callback: function (data) {
//				        if (!data) {
//				            console.log('Cancelled')
//				        } else {
//				            console.log('Selected amount: ' + data.blork)		
//				            $("#levelTraits-" + charId).val($("#levelTraits-" + charId).val() + traitId + "," + data.blork+";");
//				            console.log($("#levelTraits-" + charId).val());
//				        }
//				    }
//				});
//			}
//			
//			return traits[this.text].xpCost;
//			
//			return $(this).attr('xp-cost');
//		}).get();
//		
//		var totalXp = $().totalXp(selected_values);
//		$().doAllTotals(charId, totalXp, "trait");
//	});

	
	$(".trait").change(function () {
		var selected_values = $(this).find("option:selected").map(function () {
			return traits[this.text].xpCost;
		}).get();

		var totalXp = $().totalXp(selected_values);
		var charId = $().getCharId($(this), "trait");
		$().doAllTotals(charId, totalXp, "trait");
	});
	
	$.fn.createStartingTraitTextBox = function(traitId){
		var text = "";
		
		console.log("Max level: " + startingTraits[traitId].maxLevel);
		
		text += "<select name='blork'>";
		
		for(i = 1; i <= startingTraits[traitId].maxLevel; i++){
			text += "<option value='"+i+"'>"+i+"</option>";
		}
		
		text += "</select>";
		
		return text;
	}
	
	$.fn.doAllTotals = function(charId, totalXp, value){
		$('#'+value+'Total-' + charId).val(totalXp);
		$().totalCharBoxes(charId);
		$().totalBoxes();
	};
	
	$.fn.totalXp = function(objArray){
		var totalXp = parseInt("0");
		if (objArray !== null) {
			$.each(objArray, function (index, item) {
				totalXp += parseInt(item);
			});
		}
		return totalXp;
	}
	
	$.fn.getCharId = function(selectBox, selectName){
		return selectBox.attr('id').replace(selectName + "-", "");
	};
			
	$.fn.totalBoxes = function () {
		var totalWarbandCost = 0;

		for (var i = 0; i < characterIds.length; i++) {
			totalWarbandCost += parseInt($('#charTotal-' + characterIds[i]).val());
		}

		$('#total-value-box').val(totalWarbandCost);
	};

	$.fn.totalCharBoxes = function (charId) {
		var rangedTotal = parseInt($('#rangedTotal-' + charId).val());
		var meleeTotal = parseInt($('#meleeTotal-' + charId).val());
		var armourTotal = parseInt($('#armourTotal-' + charId).val());
		var traitTotal = parseInt($('#traitTotal-' + charId).val());
		var equipmentTotal = parseInt($('#equipmentTotal-' + charId).val());

		$('#charTotal-' + charId).val(equipmentTotal + rangedTotal + meleeTotal + armourTotal + traitTotal);
	}

	$(".theme-desc").hide();
	
	$("#themeSelector").change(function () {
		$(".theme-desc").hide();
		var themeId = $("#themeSelector").val();

		$("#theme-desc-" + themeId).show();
		$("#themeId").val(themeId);
		
		if(characterIds !== null && characterIds.length > 0 && 
				confirm("You've already added characters to this warband.  Changing the theme will remove all the characters.  " +
					"Do you want to do this?")) {
				window.location.href = "/";
		}
	});
	
	$("#tacDisSelector").change(function () {
		var tacDisId = $("#tacDisSelector").val();

		$("#tacticleDisciplineId").val(tacDisId);
	});
});
