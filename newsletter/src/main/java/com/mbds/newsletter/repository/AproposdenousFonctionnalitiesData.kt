package com.mbds.newsletter.repository

import com.mbds.newsletter.model.aproposdenous.Aproposdenous_devInfoItem
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_fonctionalitieItem

object AproposdenousFonctionnalitiesData {
    val dataList = listOf(
        Aproposdenous_fonctionalitieItem(
            fonctionalitie_name = "Open by Category",
            fonctionalitie_description="Le bouton Open by Category nous permet de voir la liste des articles en fonction de la categorie choisi. " +
                                        "Nous avons 6 types de catégories : Entreprise, Divertissement, Général, Santé, Sciences, Sport  "
        ),
        Aproposdenous_fonctionalitieItem(
            fonctionalitie_name = "Open By Country",
            fonctionalitie_description="Le bouton Open by Country nous permet de voir la liste des articles en fonction du pays choisi " +
                                        "(France, USA, Angleterre, Chine )"
        ),
        Aproposdenous_fonctionalitieItem(
            fonctionalitie_name = "Open By Editor",
            fonctionalitie_description="Le bouton Open by Editor nous permet de voir la liste des articles en fonction de l'editeur choisi " +
                                        "(Google News, Le Monde, L'équipe, Les Echos)"
        ),
        Aproposdenous_fonctionalitieItem(
            fonctionalitie_name = "Entreprise",
            fonctionalitie_description="Dès qu'on clique sur la catégorie Entreprise, on voit l'image de l'article de l'entreprise, son titre, sa description, " +
                                        "l'heure sur laquelle l'article a été publié et la possibilité d'ajouter l'article dans les favoris"
        ),
        Aproposdenous_fonctionalitieItem(
            fonctionalitie_name = "France",
            fonctionalitie_description="Dès qu'on clique sur la France, on voit l'image de l'article publié en France, son titre, sa description, " +
                                        "l'heure sur laquelle l'article a été publié et la possibilité d'ajouter l'article dans les favoris"
        ),
        Aproposdenous_fonctionalitieItem(
            fonctionalitie_name = "Le monde",
            fonctionalitie_description="Dès qu'on clique aussi sur l'editeur le monde, on voit l'image de l'article , son titre, sa description, " +
                                        "l'heure sur laquelle l'article a été publié et la possibilité d'ajouter l'article dans les favoris"
        )

    )
}