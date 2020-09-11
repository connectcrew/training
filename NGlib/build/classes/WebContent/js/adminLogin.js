function checkLogin() {
	var count = 0;
	var exception1 = document.getElementById("exception1");
	var exception2 = document.getElementById("exception2");
	var id = document.getElementById("id").value;
	var pass = document.getElementById("pass").value;

	if (id == "") {
		exception1.innerHTML = "IDを入力してください。";
		count++;
	} else {
		exception1.innerHTML = "";
	}

	if (pass == "") {
		exception2.innerHTML = "パスワードを入力してください。";
		count++;
	} else {
		exception2.innerHTML = "";
	}

	if (count == 0) {
		return true;
	} else {
		return false;
	}
}