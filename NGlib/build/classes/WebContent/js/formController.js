var prArea = {
	currentNumber: 0,

	add: function () {
		this.currentNumber++;

		var originNode = document.getElementById('prSelecter');
		var newNode = originNode.cloneNode(true);
		newNode.setAttribute("id", "producer" + this.currentNumber);
		newNode.setAttribute("name", "producer" + this.currentNumber);

		var targetNode = document.getElementById('pr' + this.currentNumber);
		targetNode.parentNode.replaceChild(newNode, targetNode);

		var nextNumber = this.currentNumber + 1;
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "pr" + nextNumber)
		newNode.insertAdjacentElement('afterend', nextIndex);

		var counter = document.getElementById("prlength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},

	remove: function () {
		if (this.currentNumber == 0) { return; }

		// replace <form> to <new nextIndex>
		var targetNode = document.getElementById('producer' + this.currentNumber);
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "pr" + this.currentNumber)
		targetNode.parentNode.replaceChild(nextIndex, targetNode);

		// delete <old nextIndex>
		var nextNumber = this.currentNumber + 1;
		var deleteIndex = document.getElementById('pr' + nextNumber);
		deleteIndex.parentNode.removeChild(deleteIndex);

		this.currentNumber--;

		var counter = document.getElementById("prlength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},
}

var swArea = {
	currentNumber: 0,

	add: function () {
		this.currentNumber++;

		var originNode = document.getElementById('swSelecter');
		var newNode = originNode.cloneNode(true);
		newNode.setAttribute("id", "scenario" + this.currentNumber);
		newNode.setAttribute("name", "scenario" + this.currentNumber);

		var targetNode = document.getElementById('sw' + this.currentNumber);
		targetNode.parentNode.replaceChild(newNode, targetNode);

		var nextNumber = this.currentNumber + 1;
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "sw" + nextNumber)
		newNode.insertAdjacentElement('afterend', nextIndex);

		var counter = document.getElementById("swlength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},

	remove: function () {
		if (this.currentNumber == 0) { return; }

		// replace <form> to <new nextIndex>
		var targetNode = document.getElementById('scenario' + this.currentNumber);
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "sw" + this.currentNumber)
		targetNode.parentNode.replaceChild(nextIndex, targetNode);

		// delete <old nextIndex>
		var nextNumber = this.currentNumber + 1;
		var deleteIndex = document.getElementById('sw' + nextNumber);
		deleteIndex.parentNode.removeChild(deleteIndex);

		this.currentNumber--;

		var counter = document.getElementById("swlength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},
}

var ilArea = {
	currentNumber: 0,

	add: function () {
		this.currentNumber++;

		var originNode = document.getElementById('ilSelecter');
		var newNode = originNode.cloneNode(true);
		newNode.setAttribute("id", "illustrator" + this.currentNumber);
		newNode.setAttribute("name", "illustrator" + this.currentNumber);

		var targetNode = document.getElementById('il' + this.currentNumber);
		targetNode.parentNode.replaceChild(newNode, targetNode);

		var nextNumber = this.currentNumber + 1;
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "il" + nextNumber)
		newNode.insertAdjacentElement('afterend', nextIndex);

		var counter = document.getElementById("illength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},

	remove: function () {
		if (this.currentNumber == 0) { return; }

		// replace <form> to <new nextIndex>
		var targetNode = document.getElementById('illustrator' + this.currentNumber);
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "il" + this.currentNumber)
		targetNode.parentNode.replaceChild(nextIndex, targetNode);

		// delete <old nextIndex>
		var nextNumber = this.currentNumber + 1;
		var deleteIndex = document.getElementById('il' + nextNumber);
		deleteIndex.parentNode.removeChild(deleteIndex);

		this.currentNumber--;

		var counter = document.getElementById("illength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},
}

var gcArea = {
	currentNumber: 0,

	add: function () {
		this.currentNumber++;

		var originNode = document.getElementById('gcSelecter');
		var newNode = originNode.cloneNode(true);
		newNode.setAttribute("id", "graphic" + this.currentNumber);
		newNode.setAttribute("name", "graphic" + this.currentNumber);

		var targetNode = document.getElementById('gc' + this.currentNumber);
		targetNode.parentNode.replaceChild(newNode, targetNode);

		var nextNumber = this.currentNumber + 1;
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "gc" + nextNumber)
		newNode.insertAdjacentElement('afterend', nextIndex);

		var counter = document.getElementById("gclength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},

	remove: function () {
		if (this.currentNumber == 0) { return; }

		// replace <form> to <new nextIndex>
		var targetNode = document.getElementById('graphic' + this.currentNumber);
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "gc" + this.currentNumber)
		targetNode.parentNode.replaceChild(nextIndex, targetNode);

		// delete <old nextIndex>
		var nextNumber = this.currentNumber + 1;
		var deleteIndex = document.getElementById('gc' + nextNumber);
		deleteIndex.parentNode.removeChild(deleteIndex);

		this.currentNumber--;

		var counter = document.getElementById("gclength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},
}

var scArea = {
	currentNumber: 0,

	add: function () {
		this.currentNumber++;

		var originNode = document.getElementById('scSelecter');
		var newNode = originNode.cloneNode(true);
		newNode.setAttribute("id", "sound" + this.currentNumber);
		newNode.setAttribute("name", "sound" + this.currentNumber);

		var targetNode = document.getElementById('sc' + this.currentNumber);
		targetNode.parentNode.replaceChild(newNode, targetNode);

		var nextNumber = this.currentNumber + 1;
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "sc" + nextNumber)
		newNode.insertAdjacentElement('afterend', nextIndex);

		var counter = document.getElementById("sclength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},

	remove: function () {
		if (this.currentNumber == 0) { return; }

		// replace <form> to <new nextIndex>
		var targetNode = document.getElementById('sound' + this.currentNumber);
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "sc" + this.currentNumber)
		targetNode.parentNode.replaceChild(nextIndex, targetNode);

		// delete <old nextIndex>
		var nextNumber = this.currentNumber + 1;
		var deleteIndex = document.getElementById('sc' + nextNumber);
		deleteIndex.parentNode.removeChild(deleteIndex);

		this.currentNumber--;

		var counter = document.getElementById("sclength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},
}

var vaArea = {
	currentNumber: 0,

	add: function () {
		this.currentNumber++;

		var originNode = document.getElementById('vaSelecter');
		var newNode = originNode.cloneNode(true);
		newNode.setAttribute("id", "voiceactor" + this.currentNumber);
		newNode.setAttribute("name", "voiceactor" + this.currentNumber);

		var targetNode = document.getElementById('va' + this.currentNumber);
		targetNode.parentNode.replaceChild(newNode, targetNode);

		var nextNumber = this.currentNumber + 1;
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "va" + nextNumber)
		newNode.insertAdjacentElement('afterend', nextIndex);

		var counter = document.getElementById("valength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},

	remove: function () {
		if (this.currentNumber == 0) { return; }

		// replace <form> to <new nextIndex>
		var targetNode = document.getElementById('voiceactor' + this.currentNumber);
		var nextIndex = document.createElement("div");
		nextIndex.setAttribute("id", "va" + this.currentNumber)
		targetNode.parentNode.replaceChild(nextIndex, targetNode);

		// delete <old nextIndex>
		var nextNumber = this.currentNumber + 1;
		var deleteIndex = document.getElementById('va' + nextNumber);
		deleteIndex.parentNode.removeChild(deleteIndex);

		this.currentNumber--;

		var counter = document.getElementById("valength");
		counter.setAttribute("value", 1 + this.currentNumber);
	},
}

function switchBox(value) {
	var targetNode = document.getElementById("newSeries");
	if (value == "new") {
		targetNode.removeAttribute("disabled");
	} else {
		targetNode.setAttribute("disabled", "disabled");
	}
}

function checkPi() {
	var count = 0;
	var exception1 = document.getElementById("exception1");
	var exception2 = document.getElementById("exception2");
	var exception3 = document.getElementById("exception3");
	var must1 = document.getElementById("title").value;
	var must2 = document.getElementById("brand").value;
	var year = document.getElementById("year").value;
	var month = document.getElementById("month").value;
	var day = document.getElementById("day").value;

	if (must1 == "") {
		exception1.innerHTML = "製品タイトルを入力してください。";
		count++;
	} else {
		exception1.innerHTML = "";
	}

	if (must2 == "null") {
		exception2.innerHTML = "ブランドを選択してください。";
		count++;
	} else {
		exception2.innerHTML = "";
	}

	if (year == "----" || month == "--" || day == "--") {
		exception3.innerHTML = "発売年月日を選択してください。";
		count++;
	} else {
		exception3.innerHTML = "";
	}

	if (count == 0) {
		return true;
	} else {
		return false;
	}
}

function checkCo() {
	var count = 0;
	var exception1 = document.getElementById("exception1");
	var must1 = document.getElementById("coName").value;

	if (must1 == "") {
		exception1.innerHTML = "会社/組織の名称を入力してください。";
		count++;
	} else {
		exception1.innerHTML = "";
	}

	if (count == 0) {
		return true;
	} else {
		return false;
	}
}

function checkBr() {
	var count = 0;
	var exception1 = document.getElementById("exception1");
	var exception2 = document.getElementById("exception2");
	var must1 = document.getElementById("brName").value;
	var must2 = document.getElementById("company").value;

	if (must1 == "") {
		exception1.innerHTML = "ブランド名を入力してください。";
		count++;
	} else {
		exception1.innerHTML = "";
	}

	if (must2 == "null") {
		exception2.innerHTML = "会社/組織を選択してください。";
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

function checkCr() {
	var count = 0;
	var exception1 = document.getElementById("exception1");
	var must1 = document.getElementById("name").value;
	var exception2 = document.getElementById("exception2");
	var exception3 = document.getElementById("exception3");
	var must2 = document.getElementById("month").value;
	var must3 = document.getElementById("day").value;

	if (must1 == "") {
		exception1.innerHTML = "名前を入力してください。";
		count++;
	} else {
		exception1.innerHTML = "";
	}

	if (must2 == "__" && must3 != "__") {
		exception2.innerHTML = "不正な値です。";
		count++;
	} else {
		exception2.innerHTML = "";
	}

	if (must2 != "__" && must3 == "__") {
		exception3.innerHTML = "不正な値です。";
		count++;
	} else {
		exception3.innerHTML = "";
	}

	if (count == 0) {
		return true;
	} else {
		return false;
	}
}

function checkVA() {
	var count = 0;
	var exception1 = document.getElementById("exception1");
	var must1 = document.getElementById("name").value;
	var exception2 = document.getElementById("exception2");
	var must2 = document.getElementById("spell").value;
	var exception3 = document.getElementById("exception3");
	var exception4 = document.getElementById("exception4");
	var must3 = document.getElementById("month").value;
	var must4 = document.getElementById("day").value;
	if (must1 == "") {
		exception1.innerHTML = "名前を入力してください。";
		count++;
	} else {
		exception1.innerHTML = "";
	}

	if (must2 == "") {
		exception2.innerHTML = "よみがなを入力してください。";
		count++;
	} else {
		exception2.innerHTML = "";
	}

	if (must3 == "__" && must4 != "__") {
		exception3.innerHTML = "不正な値です。";
		count++;
	} else {
		exception3.innerHTML = "";
	}

	if (must3 != "__" && must4 == "__") {
		exception4.innerHTML = "不正な値です。";
		count++;
	} else {
		exception4.innerHTML = "";
	}

	if (count == 0) {
		return true;
	} else {
		return false;
	}
}
