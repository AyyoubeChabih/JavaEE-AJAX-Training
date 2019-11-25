function View() {

}

View.prototype.success = function(data) {
    $("#success").display("block");
    $("#success").html(data);
    
}

View.prototype.hideSuccess = function() {
    $("#success").display("none");
}

View.prototype.clear = function () {
    $("#isbn").value("");
    $("#titre").value("");
    $("#yearPublished").value("");
}

View.prototype.docs = function(docs) {
    if (docs.size() > 0) {
        var meta = "<tr><th>ISBN</th><th>Titre</th><th>Année Publication</th></tr>";
        $("#table").html(meta);
        for (var i = 0; i < docs.size(); i++) {
            this.addLine(docs.getByIndex(i), "table");
        }
    }
}

View.prototype.addLine = function (doc, tableName) {
    var data = "<tr><td>" + doc.isbn + "</td><td>" + doc.title + "</td><td>" + doc.yearPublished + "</td></tr>";
    $("#" + tableName).html($("#" + tableName).html() + data);
}

View.prototype.resultat = function(docs) {
    if (docs.length > 0) {
        var meta = "<tr><th>ISBN</th><th>Titre</th><th>Année Publication</th></tr>";
        $("#searchTable").html(meta);
        for (var i = 0; i < docs.length; i++) {
            this.addLine(docs[i], "searchTable");
        }
    } else {
        $("#searchTable").html("<h2>Aucun livre trouvé</h2>");
    }
}