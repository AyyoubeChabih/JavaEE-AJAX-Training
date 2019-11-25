function Ajax() {
	this.xhr = new XMLHttpRequest();
}

Ajax.prototype.get = function (url, action) {
	this.xhr.open("GET", url, true);
	var $this = this;
	this.xhr.onreadystatechange = function() {
		if ($this.xhr.readyState == XMLHttpRequest.DONE) {
			alert($this.xhr.status);
			if ($this.xhr.status == 200) {
				$this.xml = $this.xhr.responseText;
				alert($this.xhr.responseText);
				action($this.xml);
			}
		}
	};
	this.xhr.send();
}

var ajax = new Ajax();