/**
 * 
 */
function printAlert(input){
	input.addClass("alert");
    input.addClass("alert-danger");
}

function removeAlert(input) {
	input.removeClass("alert");
    input.removeClass("alert-danger");
}

function printError(input, messageError){
	printAlert(input);
    input.parent().find(".error").html(messageError);
}

function removeError(input) {
	removeAlert(input);
    input.parent().find(".error").html("");
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function isValide(input, messageError){
    var submissible = true;
    if(input.val().trim() === ''){
        submissible = false;
        printError(input, messageError);
    } else {
        submissible = true;
        removeError(input);
    }
    return submissible;
}

function isValide(input) {
	var submissible = true;
    if(input.val().trim() === ''){
        submissible = false;
        printAlert(input);
    } else {
        submissible = true;
        removeAlert(input);
    }
    return submissible;
}

function valideAddEnseignantForm() {
    var numero = $("#addEnseignantForm input[name=numero]");
    var nom = $("#addEnseignantForm input[name=nom]");
    var prenom = $("#addEnseignantForm input[name=prenom]");
    var sexe = $("#addEnseignantForm select[name=sexe]");
    var grade = $("#addEnseignantForm select[name=grade]");
    var dateNaissance = $("#addEnseignantForm input[name=dateNaissance]");
    var dateEmbauche = $("#addEnseignantForm input[name=dateEmbauche]");
    
    var submissible = true;

    if(!isValide(numero,"Entre le numero de l'enseignant stp !")) {
        submissible = false;
    }
    if(!isValide(nom,"Entre le nom de l'enseignant stp !")) {
        submissible = false;
    }
    if(!isValide(prenom,"Entre le prenom de l'enseignant stp !")) {
        submissible = false;
    }
    if(!isValide(sexe,"Entre le sexe de l'enseignant stp !")) {
        submissible = false;
    }    
    if(!isValide(grade,"Entre le grade de l'enseignant stp !")) {
        submissible = false;
    }
    if(!isValide(dateNaissance,"Entre la date de naissance de l'enseignant stp !")) {
        submissible = false;
    }
    if(!isValide(dateEmbauche,"Entre la date d'embauche de l'enseignant stp !")) {
        submissible = false;
    }
    return submissible;
}

function valideUpdateEnseignantForm() {
    var nom = $("#updateEnseignantForm input[name=nom]");
    var prenom = $("#updateEnseignantForm input[name=prenom]");
    var sexe = $("#updateEnseignantForm select[name=sexe]");
    var grade = $("#updateEnseignantForm select[name=grade]");
    
    var submissible = true;

    if(!isValide(nom,"Entre le nom de l'enseignant stp !")) {
        submissible = false;
    }
    if(!isValide(prenom,"Entre le prenom de l'enseignant stp !")) {
        submissible = false;
    }
    if(!isValide(sexe,"Entre le sexe de l'enseignant stp !")) {
        submissible = false;
    }    
    if(!isValide(grade,"Entre le grade de l'enseignant stp !")) {
        submissible = false;
    }

    return submissible;
}

function valideAddEtudiantForm() {
    var numEtudiant = $("#addEtudiantForm input[name=numEtudiant]");
    var nom = $("#addEtudiantForm input[name=nom]");
    var prenom = $("#addEtudiantForm input[name=prenom]");
    var sexe = $("#addEtudiantForm select[name=sexe]");
    var dateNaissance = $("#addEtudiantForm input[name=dateNaissance]");
    var email = $("#addEtudiantForm input[name=email]");
    var adresse = $("#addEtudiantForm input[name=adresse]");
    
    var submissible = true;
    
    if(!isValide(numEtudiant)) {
    	submissible = false;
    }
    if(!isValide(nom)) {
    	submissible = false;
    } 
    if (!isValide(prenom)) {
    	submissible = false;
    } 
    if (!isValide(sexe)) {
    	submissible = false;
    } 
    if ((!isValide(email))) {
    	submissible = false;
    } 
    if(!isValide(dateNaissance)) {
    	submissible = false; 
    }
    if(!isValide(adresse)) {
    	submissible = false; 
    }
    return submissible;
}

function valideUpdateEtudiantForm() {
	var id = $("#updateEtudiantForm input[name=id]");
    var numEtudiant = $("#updateEtudiantForm input[name=numEtudiant]");
    var nom = $("#updateEtudiantForm input[name=nom]");
    var prenom = $("#updateEtudiantForm input[name=prenom]");
    var sexe = $("#updateEtudiantForm select[name=sexe]");
    var dateNaissance = $("#updateEtudiantForm input[name=dateNaissance]");
    var email = $("#updateEtudiantForm input[name=email]");
    var adresse = $("#updateEtudiantForm textarea[name=adresse]");
    
    var submissible = true;
    
    if(!isValide(numEtudiant)) {
    	submissible = false;
    }
    if(!isValide(nom)) {
    	submissible = false;
    } 
    if (!isValide(prenom)) {
    	submissible = false;
    } 
    if (!isValide(sexe)) {
    	submissible = false;
    } 
    if ((!isValide(email))) {
    	submissible = false;
    } 
    if(!isValide(dateNaissance)) {
    	submissible = false; 
    }
    if(!isValide(adresse)) {
    	submissible = false; 
    }

    return submissible;
}

function valideUpdateMatiereForm() {
	var id = $("#updateMatiereForm input[name=id]");
    var numeroMatiere = $("#updateMatiereForm input[name=numeroMatiere]");
    var nom = $("#updateMatiereForm input[name=nom]");
    var coef = $("#updateMatiereForm input[name=coef]");
    var dateDebut = $("#updateMatiereForm input[name=dateDebut]");
    var dateFin = $("#updateMatiereForm input[name=dateFin]");
    var enseignant = $("#updateMatiereForm select[name=enseignant]");

    var submissible = true;
    
    if(!isValide(numeroMatiere)) {
    	submissible = false;
    }
    if(!isValide(nom, "Entre le libellé de la matière stp !")) {
    	submissible = false;
    }
    if(!isValide(coef, "Entre le coefficiant stp !")) {
    	submissible = false;
    }
    if(!isValide(dateDebut, "Entre la date de début stp !")) {
    	submissible = false;
    }
    if(!isValide(dateFin, "Entre la date de fin stp !")) {
    	submissible = false;
    }
    if(!isValide(enseignant, "Entre un enseignant stp !")) {
    	submissible = false;
    }
    if(!isValide(id)) {
    	submissible = false;
    }
    return submissible;
}
