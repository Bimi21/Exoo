
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
object Main {
  var placeASéance1 = 50
  var placeASéance2 = 50
  var placeASéance3 = 50

  var placeBSéance1 = 50
  var placeBSéance2 = 50
  var placeBSéance3 = 50

  var filmSalle1 = "Le mystère de la forêt"
  var filmSalle2 = "Voyage Interstellaire"

  def main(args: Array[String]): Unit = {
    import scala.io.StdIn._

    var Séance1 = "14h00"
    var Séance2 = "17h00"
    var Séeance3 = "20h00"


    var prixAdulte = 12.00
    var prixEtudiant = 8.00
    var prixEnfant = 6.00

    println("Choisir le mode : Client = A / Admin = B / Quitter = C  ")
    var Client = readC()

    if (Client == 'A') {
      println("Vous êtes en mode Client")
      println("Choisir un des deux films : + \n1) FilmA (Salle 1) \n2) FilmB (Salle 2)")
      var choixFilm = readInt()

      var FilmChoisi = ""
      if (choixFilm == 1) {
        FilmChoisi = filmSalle1
      } else if (choixFilm == 2) {
        FilmChoisi = filmSalle2
      }
      println("Choisir la Séance : \n1) 14h00 (Rabais -2.00 CHF \n2) 17h00 (Prix normal) \n3) 20h00 (Prix normal: + 1CHF)")
      print(">")
      var Seance = readInt()

      println("Combien de billet souhaitez-vous ? (1-5)")
      var nbBillets = readInt()
      // validation : entre 1 et 5
      if (nbBillets <= 0 || nbBillets < 1) {
        println("Erreur : vous devez choisir entre 1 et 5 billets.")
        nbBillets = readInt()
      } else if (nbBillets > 5) {
        println ("Erreur vous devez choisir entre 1 et 5 billets.")
        nbBillets = readInt()
      }

      var placeRestantes = 0
      if (choixFilm == 1) {
        if (Seance == 1) placeRestantes = placeASéance1
        else if (Seance == 2) placeRestantes = placeASéance2
        else if (Seance == 3) placeRestantes = placeBSéance3
      } else if (choixFilm == 2) {
        if (Seance == 1) placeRestantes = placeBSéance1
        else if (Seance == 2) placeRestantes = placeBSéance2
        else if (Seance == 3) placeRestantes = placeBSéance3
      }


      if (nbBillets > placeRestantes) {
        println("Erreur : seulment " + placeRestantes + " places disponibles pour cette séance")
      } else {
        var prixTotal: Double = 0.0
        var i = 1
        while (i <= nbBillets) {
          println("Type du billet" + i + "\n1) Adulte ("+ prixAdulte + "CHF)" + "\n2) Etudiant ("+ prixEtudiant + "CHF)" + "\n3) Enfant (" + prixEnfant + "CHF")
          print(">")
          var typeBillet = readInt()

          var prixUnBillet: Double = 0.0
          if (typeBillet == 1) {
            prixUnBillet = prixAdulte
          } else if (typeBillet == 2) {
            prixUnBillet = prixEtudiant
          } else if (typeBillet == 3) {
            prixUnBillet = prixEnfant
          }

        if (Seance == 1) {
          prixUnBillet = prixUnBillet - 2
        } else if (Seance == 3) {
          prixUnBillet = prixUnBillet + 1
        }

        prixTotal = prixTotal + prixUnBillet
        i = i + 1
        }

        println("\nRécapitulatif de votre comande")

      if (choixFilm == 1) {
        println("Film : " + filmSalle1)
        } else {
        println("Film : " + filmSalle2)
      }

        if (Seance == 1) {
          println(" Séance : 14h00")
        } else if (Seance == 2) {
          println("Séance : 17h00")
        } else {
          println("Séance == 3")
        }

        println(" Nombre de billets : " + nbBillets)
        println("Prix totale : " + prixTotal + " CHF")
          println(" -- \n")

        var nouvellesPlaces = 0
        if (choixFilm == 1 && Seance == 1) {
          nouvellesPlaces = placeASéance1 - nbBillets
        }
        else if (choixFilm == 1 && Seance ==2) {
          nouvellesPlaces = placeASéance2 - nbBillets
        }
        else if (choixFilm == 1 && Seance == 3) {
          nouvellesPlaces = placeASéance3 - nbBillets
        }
        else if (choixFilm == 2 && Seance == 1) {
          nouvellesPlaces = placeBSéance1 - nbBillets
        }
        else if (choixFilm == 2 && Seance == 2) {
          nouvellesPlaces = placeBSéance2 - nbBillets
        } else if (choixFilm == 2 && Seance == 3) {
          nouvellesPlaces = placeBSéance3 - nbBillets
        }

        if (choixFilm == 1 && Seance == 1) {
          placeASéance1 = nouvellesPlaces
        } else if (choixFilm == 1 && Seance == 2) {
          placeASéance2 = nouvellesPlaces
        } else if (choixFilm == 1 && Seance == 3) {
          placeASéance2 = nouvellesPlaces
        }  else if (choixFilm == 2 && Seance == 1) {
          placeBSéance1 = nouvellesPlaces
        } else if (choixFilm == 2 && Seance == 2) {
          placeBSéance2 = nouvellesPlaces
        } else if (choixFilm == 2 && Seance == 3) {
          placeBSéance3 = nouvellesPlaces
        }

        println("Paiement par carte bencaire")
        print("\n Code de transaction : " + Math.round(Math.random() * 1000))
        print("\n(Traitemnet en cours...)")

        print("\n\nPaiement confirmé !")
        print("\n Vos billets ont été réservés avec succès")
        print("\nBon film !\n")
    }
      println("Retour au menu principal ...")
      main(Array(""))
  }
    if(Client == 'B') {
      println("Vous êtes en mode Admin")

      println("Entrez le PIN: ")
      print(">")
      val PIN = 2025
      var pin = readInt()

      while (pin != PIN) {
        print("Erreur")
        pin = readInt()
      }
      print("Acès autorisé. \nChoix:\n1)Etat des salles\n2) Changement de salle\n>")
      var choixADD = readInt()

      if (choixADD == 1) {
        println("État des salles :\n")

        println("Salle 1 - " + filmSalle1 + "\n Séance 14h00 : " + placeASéance1 + "/50 places disponibles" + "\n Séance 17h00 : " + placeASéance2 + "/50 places disponibles" + "\n Séance 20h00 : " + placeASéance3 + "/50 places disponibles")

        println()

        println("Salle 2 - " + filmSalle2 + "\nSéance 14h00 : " + placeBSéance1 + "/50 places disponibles" + "\n Séance 17h00 : " + placeBSéance2 + "/50 places disponibles" + "\n Séance 20h00 : " + placeBSéance3 + "/50 places disponibles")

      } else if (choixADD == 2) {
        println("Quelle salle voulez-vous modifier ? \n1) Salle 1 \n2) Salle 2")
        val salleChoisie = readInt()

        var choisis = 0
        val aucuneVenteSalle1 =
          placeASéance1 == 50 && placeASéance2 == 50 && placeASéance3 == 50
        val aucuneVenteSalle2 =
          placeBSéance1 == 50 && placeBSéance2 == 50 && placeBSéance3 == 50

        if (salleChoisie == 1 && aucuneVenteSalle1) {
          print("Le film en salle 1 est : " + filmSalle1 + ".\n Quel film choisissez-vous en salle  1 ?")
          var choisis = readLine()
          filmSalle1 = choisis
          print("Salle 1 - " + filmSalle1 + "\nRetour au menu principal")
          main(Array(""))
          //sys.exit(0)
        } else if (salleChoisie == 2 && aucuneVenteSalle2) {
          println("Le film en salle 2 est : " + filmSalle2 + ".\n Quel film choisissez-vous en salle 2 ?")
          var choisis = readLine()
          filmSalle2 = choisis
          print("Salle 2 - " + filmSalle2 + " \nRetour au menu principale")
          main(Array(""))
          //sys.exit(0)
        } else {
          println("Ce filme ne peut pas être modifié, car la séance a déjà des réservations.")
          print("Retour au menu principal...")
          main(Array(""))
      }
      main(Array(""))
      }
    }
    }
}