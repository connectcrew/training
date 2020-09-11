<script type="text/javascript">
/*コンテンツとして表示させたい内容のテキスト*/
	var textArray = new Array();
	textArray[0] = 'コンテンツ0。コンテンツ0。コンテンツ0。';
	textArray[1] = 'コンテンツ1。コンテンツ1。コンテンツ1。';
	textArray[2] = 'コンテンツ2。コンテンツ2。コンテンツ2。';
	/*コンテンツ表示フラグ*/
	var displayFlag = false;
	/*コンテンツ表示用関数*/
function dispContents() {
/*コンテンツ表示フラグをチェック*/
/*もし表示されていれば終了*/
if(displayFlag == true) { return; }
/*コンテンツを表示させたい領域のタグ要素ノードオブジェクト*/
var contentsNode = document.getElementById('contents');
/*ひな型となるHTMLタグの要素ノードオブジェクト*/
var tmplNode = document.getElementById('tmpl');
/**/
for(var i=0; i<textArray.length; {
/*ひな型の要素ノードオブジェクトを複製*/
var newNode = tmplNode.cloneNode(true);
/*スタイルを変更し可視化する*/
newNode.style.display = '';
/*id属性値を変更*/
newNode.id = 'box' + i;
/*コンテンツを挿入*/
newNode.appendChild( document.createTextNode(textArray[i]) );
/*新ノードを追加*/
contentsNode.appendChild(newNode);
　　}
/*表示ボタンを無効化*/
document.getElementById('dispBtn').disabled = true;
/*表示フラグをtrueにセット*/
displayFlag = true;
　}
</script>


var prFormArea = {
	currentNumber: 1, // 変数定義
	prFormArea: '<input type="text" name="prForm" size="40">',

	add : function () {
		this.currentNumber++;

		var field = document.getElementById('pr' + this.currentNumber);

		var nextNumber = this.currentNumber + 1;
		var new_area = document.createElement("div");
		new_area.setAttribute("id", "pr" + nextNumber)
	},

	remove : function () {
        if ( this.currentNumber == 1 ) { return; }

        var field = document.getElementById('pr' + this.currentNumber);
        field.removeChild(field.lastChild);
        field.innerHTML = '';

        this.currentNumber--;
	}

/*
	coFormArea: '<input type="text" name="coForm" size="40">',
	brFormArea: '<input type="text" name="brForm" size="40">',

	swFormArea: '<input type="text" name="swForm" size="40">',
	ilFormArea: '<input type="text" name="ilForm" size="40">',
	gcFormArea: '<input type="text" name="gcForm" size="40">',
	scFormArea: '<input type="text" name="scForm" size="40">',
	vaFormArea: '<input type="text" name="vaForm" size="40">',
	avFormArea: '<input type="text" name="avForm" size="40">',
*/


}

var ItemField = {
    currentNumber : 1,
    itemTemplate : '<h3>項目__count__<h3/>'
        + '<p><input type="text" name="text__count__" size="30" /></p>',
    add : function () {
        this.currentNumber++;

        var field = document.getElementById('item' + this.currentNumber);

        var newItem = this.itemTemplate.replace(/__count__/mg, this.currentNumber);
        field.innerHTML = newItem;

        var nextNumber = this.currentNumber + 1;
        var new_area = document.createElement("div");
        new_area.setAttribute("id", "item" + nextNumber);
        field.appendChild(new_area);
    },

    }
}


< style >
	label, input {display: block; }
input.text {margin - bottom: 12px; width: 95 %; padding: .4em; }
fieldset {padding: 0; border: 0; margin - top: 25px; }
h1 {font - size: 1.2em; margin: .6em 0; }
div#users - contain {width: 350px; margin: 20px 0; }
div#users - contain table {margin: 1em 0; border - collapse: collapse; width: 100 %; }
div#users - contain table td, div#users - contain table th {border: 1px solid #eee; padding: .6em 10px; text - align: left; }
    .ui - dialog.ui - state - error {padding: .3em; }
    .validateTips {border: 1px solid transparent; padding: 0.3em; }
  </ >
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$( function() {
    var dialog, form,

      // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
      emailRegex = /^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0, 61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0, 61}[a-zA-Z0-9])?)*$/,
      name = $( "#name" ),
      email = $( "#email" ),
      password = $( "#password" ),
      allFields = $( [] ).add( name ).add( email ).add( password ),
      tips = $( ".validateTips" );

    function updateTips( t ) {
			tips
				.text(t)
				.addClass("ui-state-highlight");
      setTimeout(function() {
			tips.removeClass("ui-state-highlight", 1500);
      }, 500 );
    }

    function checkLength( o, n, min, max ) {
      if ( o.val().length > max || o.val().length < min ) {
			o.addClass("ui-state-error");
        updateTips( "Length of " + n + " must be between " +
          min + " and " + max + "." );
        return false;
      } else {
        return true;
      }
    }

    function checkRegexp( o, regexp, n ) {
      if ( !( regexp.test( o.val() ) ) ) {
			o.addClass("ui-state-error");
        updateTips( n );
        return false;
      } else {
        return true;
      }
    }

    function addUser() {
      var valid = true;
      allFields.removeClass( "ui-state-error" );

      valid = valid && checkLength( name, "username", 3, 16 );
      valid = valid && checkLength( email, "email", 6, 80 );
      valid = valid && checkLength( password, "password", 5, 16 );

      valid = valid && checkRegexp( name, /^[a-z]([0-9a-z_\s])+$/i, "Username may consist of a-z, 0-9, underscores, spaces and must begin with a letter." );
      valid = valid && checkRegexp( email, emailRegex, "eg. ui@jquery.com" );
      valid = valid && checkRegexp( password, /^([0-9a-zA-Z])+$/, "Password field only allow : a-z 0-9" );

      if ( valid ) {
			$("#users tbody").append("<tr>" +
				"<td>" + name.val() + "</td>" +
				"<td>" + email.val() + "</td>" +
				"<td>" + password.val() + "</td>" +
				"</tr>");
        dialog.dialog( "close" );
      }
      return valid;
    }

    dialog = $( "#dialog-form" ).dialog({
			autoOpen: false,
      height: 400,
      width: 350,
      modal: true,
      buttons: {
			"Create an account": addUser,
        Cancel: function() {
			dialog.dialog("close");
        }
      },
      close: function() {
			form[0].reset();
        allFields.removeClass( "ui-state-error" );
      }
    });

    form = dialog.find( "form" ).on( "submit", function( event ) {
			event.preventDefault();
      addUser();
    });

    $( "#create-user" ).button().on( "click", function() {
			dialog.dialog("open");
    });
  } );
  </script>