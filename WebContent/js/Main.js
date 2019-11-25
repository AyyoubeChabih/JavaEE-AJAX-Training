var menu;
var biblio;
var action;
var views;

function main() {
    menu = new Menu("nouveau-document");
    biblio = new Biblio();
    views = new View();
    action = new Actions(biblio);
}

function exemples() {
    $("#test").html("<h1>jQuery Like</h1>");
    alert($("#nouveau-document").html());
    $("span").html("<h1>Test</h1>");
}