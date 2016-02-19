function getXmlHttpRequest() {
	var xhr;

	try {
		// Firefox, Opera 8.0+, Safari
		xhr = new XMLHttpRequest();
	} catch (e) {

		// Internet Explorer
		try {
			xhr = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {

			try {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("您的浏览器不支持AJAX！");
				return false;
			}
		}
	}
	return xhr;
}
