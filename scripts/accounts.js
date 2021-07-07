var login_form = document.getElementById("login_form");
var login_form_children = login_form.children;

function close_signup_form () {
    document.getElementsByClassName("container")[0].style.filter = "grayscale(0%)";
    document.getElementsByClassName("outer_signup_box")[0].style.display = "none";
    for (var i = 0; i < login_form_children.length; i++) {
        login_form_children[i].disabled = false;
    }

}

function open_signup_form () {
    document.getElementsByClassName("container")[0].style.filter = "grayscale(100%)";
    document.getElementsByClassName("outer_signup_box")[0].style.display = "block";
    for (var i = 0; i < login_form_children.length; i++) {
        login_form_children[i].disabled = true;
    }
}