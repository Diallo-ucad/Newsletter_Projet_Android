package com.mbds.newsletter.repository

import com.mbds.newsletter.model.aproposdenous.Aproposdenous_devInfoItem
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_fonctionalitieItem
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_librairiesItem

object AproposdenousLibrairiesData {
    val dataList = listOf(
        Aproposdenous_librairiesItem(
            librairie_name = "Librairie 1",
            librairie_description = "Librairie 1 description "
        ),
        Aproposdenous_librairiesItem(
            librairie_name = "Librairie 2",
            librairie_description = "Librairie 2 description "
        )
    )
}