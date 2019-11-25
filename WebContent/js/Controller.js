function addDoc() {
    var context = action.addDoc();
    show(context.view, context.data);
}

function show(view, data) {
    if (view == "success") {
        views.clear();
        views.success(data["message"]);
    }
    else if (view == "liste-des-livres") {
        views.docs(data);
    }
    else if (view == "resultat-du-recherche") {
        views.resultat(data);
    }
}

function hideSuccess() {
    views.hideSuccess();
}

function lister() {
    var context = action.lister();
    show(context.view, context.data);
}

function rechercher() {
    var context = action.rechercher();
    show(context.view, context.data);
}

function getDocuments() {
    ajax.get(
        "/PAJAX/ajax/test",
        action
    );
}

function action(xml) {
	alert("action");
    action.getDocuments(xml);
}