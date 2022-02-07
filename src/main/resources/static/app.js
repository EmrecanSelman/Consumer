$("#formRegister").hide();
$("#deleteandupgradeSection").hide();
$("#ugradeSection").hide();
$( "#saklamak" ).click(function() {
    $( "#formRegister" ).slideDown( 2500, function() {
      alert( "Animation complete." );
    });
  });
var admin ={
    "name":"admin",
    "pass":"1234",
    "mail":"admin@gmail.com"
}
let BASE_URL = "http://192.168.1.102:8082/";
$("#saveButton").click(() => {
    let username = $("#usernameText")[0].value;
    let pass = $("#passwordText")[0].value;
    let mail = $("#mailText")[0].value;
    
    let data = {
        name : username,
        pass:pass,
        mail:mail
    };

    $.ajax({
        type:"POST",
        url:BASE_URL +"api/saveUser",
        data : data,
        success:(resultObj) => {
            console.log(resultObj)
        },
        error: (err,status) => {
            alert(err.responseJSON.message)
        }
    });

});

$("#loginButton").click(()=>{
    console.log("login Clicked");

    let username = $("#usernameTextLogin")[0].value;
    let pass = $("#passwordTextLogin")[0].value;
    let mail = $("#mailTextLogin")[0].value;
    
    var data = {
        name : username,
        pass:pass,
        mail:mail
    };
   let url="/api/login";

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: url,
        dataType: 'json',
        cache: false,
        data:data
        ,
 
        success: function(data,response) {
            if (data==false) {
               console.log("başarısız giriş") }
            else if(username==admin.name || pass==admin.pass || mail==admin.mail){
            console.log("admin geldi")
            console.log(data)
            $( "#deleteandupgradeSection" ).slideDown( 2500, function() { console.log("ugrade ve delete işlemleri açıldı") });

        }
                
            else{
            console.log("başarılı bir giriş yaptınız bravo")
            $( "#deleteandupgradeSection" ).slideDown( 2500, function() { console.log("ugrade ve delete işlemleri açıldı") });
        }
     },
        error: function(err) {
            alert(err.responseJSON.message)
        }
    });


$("#deleteButton").click(()=>{
    let username = $("#usernameTextLogin").val();
    let pass = $("#passwordTextLogin").val();
    let mail = $("#mailTextLogin").val();
    let data = {
        name : username,
        pass:pass,
        mail:mail
    };
    let url="/api/delete";

    $.ajax({
        type:"DELETE",
        url:url,
        data:data,
        success: function(data) {
            alert(data);
        console.log("başarılı bir şekilde kayıt silindi")},
        error: function(err) {
            alert(err.responseJSON.message)
        }
    });
    });
$("#upgradeButtonForUpgrade").click(function(){
    $( "#ugradeSection" ).slideDown( 1250, function() {
        alert( "Animation complete." );
      });
});

    $("#upgradeButton").click(()=>{ 
        let username = $("#usernameTextUpg").val();
    let pass = $("#passwordTextUpg").val();
    let mail = $("#mailTextUpg").val();
    let oldMail = $("#mailTextLogin").val();
    let data = {
        name : username,
        pass:pass,
        mail:mail,
        oldMail:oldMail
    };
    let url="/api/"+username+"/"+pass+"/"+mail;

    $.ajax({
        type:"PUT",
        url:url,
        data:data,
        success: function(data) {
            alert(data);
        console.log("başarılı bir şekilde kayıt güncellendi")},
        error: function(err) {
            alert(err.responseJSON.message)
        }
    });



    });

});