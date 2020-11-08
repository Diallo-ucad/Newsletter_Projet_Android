package com.mbds.newsletter.repository

import com.mbds.newsletter.model.aproposdenous.Aproposdenous_devInfoItem
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_fonctionalitieItem

object AproposdenousFonctionnalitiesData {
    val dataList = listOf(
        Aproposdenous_fonctionalitieItem(
            fonctionalitie_name = "Lister les articles par categorie",
            fonctionalitie_description="Liste les articles en fonction de la catégorie choisi "
        ),
        Aproposdenous_fonctionalitieItem(
            fonctionalitie_name = "Lister les articles par pays",
            fonctionalitie_description="Liste les articles en fonction du pays choisi"
        )
    )
}