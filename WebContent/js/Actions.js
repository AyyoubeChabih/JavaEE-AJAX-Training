function Actions(biblio) {
    this.biblio = biblio;
}

Actions.prototype.addDoc = function () {
    var id = $("#isbn").value();
    var title = $("#titre").value();
    var yearPublished = $("#yearPublished").value();
    var book = new Book(id, title, yearPublished);
    this.biblio.add(book);
    var data = [];
    data["message"] = "livre ajouté avec succée";
    return new Context("success", data);
}

Actions.prototype.lister = function() {
    return new Context("liste-des-livres", this.biblio);
}

Actions.prototype.rechercher = function () {
    var keyword = $("#keyword").value();
    var data = this.biblio.search(keyword);
    return new Context("resultat-du-recherche", data);
}

Actions.prototype.getDocuments = function (xml) {
    var i;
    var isbn, title, yearPublished;
    var x = xml.getElementsByTagName("document");
    for (var i = 0; i < x.length; i++) {
      isbn = x[i].getAttribute("isbn")[0];
      alert(isbn);
      title = x[i].getElementsByTagName("title")[0].childNodes[0].nodeValue;
      yearPublished = x[i].getElementsByTagName("year-published")[0].childNodes[0].nodeValue;
      var book = new Book(isbn, title, yearPublished);
      this.biblio.add(book);
    }
}