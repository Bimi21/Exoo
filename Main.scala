import scala.io.StdIn.readInt
import scala.io.StdIn.readLine
import java.lang.Math
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
object Main {
  def main(args: Array[String]): Unit = {
    val nbSalles = new Array[String](4)
    val acunFilm: String ="Acun film programmé"

    val prixAulte = 12.0
    val prixEtudiant = 8.0
    val prixEnfant = 6.0

    val discount = Array(-2.00,0,1)
    val horaireSeance = Array("14h00", "17h00", "20h00")
    val films = Array(acunFilm)

    var places14h = Array(50,50,50)
    var places17h = Array(50,50,50)
    var places20h = Array(50,50,50)

    val pins = Array(2025,2025,2025)

    def validerPin(idSalle: Int, pins:Array[Int]):Boolean = {
      print("Entrez le code PIN : \n>")
      val saisi = readInt()
      if (saisi == pins(idSalle)){
        return  true
      }
        return false
    }
    def mettreAJourPin(idSalle: Int, pins: Array[String]):Unit={
      var ok = false
      while(!ok) {
        println("Modification du PIN pour les salles")
        print("Entrez un nouveau PIN à 4 chiffre: \n>")
        val nouveaupin = readLine()
        if (nouveaupin.toInt >= 1000 && nouveaupin.toInt <= 9999){
          pins(idSalle) = nouveaupin
          println("PIN mis à jour avec succès.")
          ok = true
        }else {
          println("PIN invalide. Le PIN doit contenir exactement 4 chiffre.")
        }
      }
    }
    def reserveClient (idSalle: Int, films: Array[String], places14h: Array[Int], places17h00: Array[Int], places20h: Array[Int]): Boolean ={
      if (films(idSalle) == acunFilm) {
        println("Erreur : cette salle n'a pas de film programmé.")
        return false
      }
      println("Mode Client")
      println("Salle: " +films(idSalle))
      println("\n Veuillez sélectionner votre séance : ")
      println("1) (Tarif réduit : -2.00 CHF")
      println("2) (Tarif normal)")
      println("3) (Tarif soirée : +1.00 CHF)")
      print(">")
      val choixSeance = readInt()-1

      val salles = Array(places14h, places17h, places20h)
      println("Combien de billet souhaitez-vous ? (1-5)")
      val nbBillet = readInt()

      if (nbBillet < 1 || nbBillet > 5) {
        println("Erreur: le nombre de billets doit etre entre 1 et 5")
        return false
      }
      var total = 0.0
      var i = 1
      while (i <= nbBillet) {
        println("Billet" + i)
        println("1) Adulte")
        println("2) Etudiant")
        println("3) Enfant")
        print(">")
        val typeBillet = readInt()
        var prix = 0.0
        if(typeBillet == 1) prix = prixAulte
        else if (typeBillet == 2) prix = prixEtudiant
        else if (typeBillet == 3) prix = prixEnfant
        else return false
        total = total + prix + discount(choixSeance)
        i += 1
      }
      println("\n Récapitulatif de votre comande :")
      print("Salle :" +  idSalle + 1)
      print("Film:" + films(idSalle))
      print("\nSéance:" + choixSeance)
      print("\nNombre de billet: " + nbBillet)
      println("\nPrix total :" + total)

      val codeTransaction = 1000 + Math.floor(Math.random() * 9000).toInt
      println("Traitement en cours...")
      println("Paiement confirmé !")
      println("Vos billets ont été réservés avec succès.")
      println("Bon film !")

    salles(choixSeance)(idSalle)=salles(choixSeance)(idSalle) - nbBillet
      return true
    }
    def afficherEtatSalles(films: Array[String], places14h: Array[Int], places17h: Array[Int], places20h: Array[Int]): Unit ={
      println("\n Etat des salles: \n")
      var i = 0
      while (i < films.length) {
        println("Salle (i + 1) - (film(i)")
        println("Seance 14h00 : places14h/50 places disponible")
        println("Seance 17h00 : places14h/50 places disponible")
        println("Seance 20h00 : places14h/50 places disponible")
        println()
        i += 1
      }
    }
    def changerFilmSalle(idSalle: Int, films: Array[String], places14h00: Array[Int], places17h00: Array[Int], places20h00 Array[Int]): Unit ={
      val aucuneVente = places14h(idSalle) == 50 && places17h(idSalle) == 50 && places20h(idSalle) == 50

      if (!aucuneVente) {
        println("Ce film ne peut pas être modifié, car la salle a déjà des réservation.")
        return
      }
      println("Film actuel (salle (idSalle + 1): films(idSalle)")
      print("Entrez le nouveau titre du film : \n>")
      val nouveau = readLine()
      films(idSalle) = nouveau
      println("Film mis à jour.")



    }
  }
}


