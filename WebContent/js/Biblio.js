function Biblio() {
    this.docs = [];
    this.hashDocs = [];
}

Biblio.prototype.add = function (doc) {
    this.docs.push(doc);
    this.hashDocs[doc.id] = doc;
}

Biblio.prototype.get = function (isbn) {
    return this.hashDocs[isbn];
}

Biblio.prototype.getByIndex = function (index) {
    return this.docs[index];
}

Biblio.prototype.size = function () {
    return this.docs.length;
}

Biblio.prototype.search = function (keyword) {
    var data = [];
    for (var i = 0; i < this.size(); i++) {
        if (this.docs[i].title.toUpperCase().includes(keyword.toUpperCase())) {
            data.push(this.docs[i]);
        }
    }
    return data;
}