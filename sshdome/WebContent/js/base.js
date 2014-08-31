window.onresize = function () {
	var w = document.body.offsetWidth;
	var h = $("#navigate_div").width();
	var h2 = $("#navigate_div").width();
	if (h < 1000) {
		$("#navigate_div").css("width", "1000px");
	}
	if (h2 < 1000) {
		$("#navigate_div2").css("width", "1000px");
	}
	if (w > 1000) {
		$("#navigate_div").css("width", "100%");
		$("#navigate_div2").css("width", "100%");
	}
};
//显示布局调整
var h = $("#navigate_div").width();
var h2 = $("#navigate_div2").width();
if (h < 1000) {
	$("#navigate_div").css("width", "1000px");
}
if (h2 < 1000) {
	$("#navigate_div2").css("width", "1000px");
}
//控制menu
var now = "";
var before = "";
function cateShow(liId) {
	now = liId;
	$("#menu_div_" + now).show();
	if (before != now) {
		$("#menu_div_" + before).hide();
	}
	before = now;
}

function cateHidden(liId, event) {
	var div_tip = document.getElementById(liId);
	var div_tip2 = document.getElementById("menu_ul");
	var div_tip3 = document.getElementById("home");
	//firefox
	if (event.currentTarget) {
		if (!div_tip.contains(event.relatedTarget) && !div_tip2.contains(event.relatedTarget) && !div_tip3.contains(event.relatedTarget)) {
			div_tip.style.display = "none";
			$("#menu_ul").hide();
		}
	//other
	} else {
		if (!div_tip.contains(event.toElement) && !div_tip2.contains(event.toElement) && !div_tip3.contains(event.toElement)) {
			div_tip.style.display = "none";
			$("#menu_ul").hide();
		}
	}
}
function cateHiddenMenuUl(ulId, event) {
	var ul_tip = document.getElementById(ulId);
	if (now != "") {
		var ul_tip2 = document.getElementById("menu_div_" + now);
		//firefox
		if (event.currentTarget) {
			if (!ul_tip.contains(event.relatedTarget) && !ul_tip2.contains(event.relatedTarget)) {
				ul_tip2.style.display = "none";
				$("#menu_ul").hide();
			}
		//other
		} else {
			if (!ul_tip.contains(event.toElement) && !ul_tip2.contains(event.toElement)) {
				ul_tip2.style.display = "none";
				$("#menu_ul").hide();
			}
		}
	}
}

