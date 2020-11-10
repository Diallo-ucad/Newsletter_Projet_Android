package com.mbds.newsletter.repository

import com.mbds.newsletter.model.aproposdenous.Aproposdenous_devInfoItem
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_fonctionalitieItem
import com.mbds.newsletter.model.aproposdenous.Aproposdenous_librairiesItem

object AproposdenousLibrairiesData {
    val dataList = listOf(
         Aproposdenous_librairiesItem(
            librairie_name = "implementation \"'androidx.core:core-ktx:1.3.2'",
            librairie_description = "Android KTX est un ensemble d'extensions Kotlin qui sont inclus avec Android Jetpack " +
                                    "et d'autres bibliothèques Android. Les extensions KTX fournissent Kotlin concis et idiomatique à Jetpack, " +
                                    "à la plate-forme Android et à d'autres API. "
            ),
         Aproposdenous_librairiesItem(
            librairie_name = "implementation \"androidx.appcompat:appcompat:1.2.0",
            librairie_description = "La bibliothèque de support est une bibliothèque statique que vous pouvez ajouter à votre application Android afin d'utiliser des API " +
                                    "qui ne sont pas disponibles pour les anciennes versions de plate-forme ou des API utilitaires " +
                                    "qui ne font pas partie des API du framework. Compatible sur les appareils exécutant l'API 14 ou version ultérieure. "
            ),
         Aproposdenous_librairiesItem(
                 librairie_name = "implementation \"'com.google.android.material:material:1.2.1'",
                 librairie_description = "Material Components for Android est une bibliothèque statique que vous pouvez ajouter à votre application Android afin d'utiliser des API " +
                                        "qui fournissent des implémentations de la spécification Material Design. Compatible sur les appareils exécutant l'API 14 ou version ultérieure. "
            ),
         Aproposdenous_librairiesItem(
             librairie_name = "implementation \"'androidx.navigation:navigation-fragment-ktx:2.3.1'",
             librairie_description = "La navigation est un cadre permettant de naviguer entre les «destinations» dans une application " +
                                     "Android qui fournit une API cohérente, que les destinations soient implémentées en tant que fragments, activités ou autres composants. "
            ),

         Aproposdenous_librairiesItem(
             librairie_name = "implementation \" 'androidx.recyclerview:recyclerview:1.2.0-alpha06'",
             librairie_description = "RecyclerView remplace la plupart des produits de la famille AdapterView, en particulier ListView, GridView et ExpandableListView. " +
                                     "RecyclerView est plus puissant que ceux-ci, grâce à un système enfichable de stratégies de rendu, " +
                                     "en plus d'un moyen de style ListAdapter pour fournir la représentation visuelle des éléments de données individuels. "
            ),

         Aproposdenous_librairiesItem(
                    librairie_name = "implementation \" 'androidx.preference:preference:1.1.1'",
                    librairie_description = "Extensions Kotlin pour les préférences "
            ),

         Aproposdenous_librairiesItem(
                  librairie_name = "implementation \" 'androidx.annotation:annotation:1.1.0'",
                  librairie_description = "La bibliothèque de support est une bibliothèque statique que vous pouvez ajouter à votre application Android afin d'utiliser des API qui ne sont pas disponibles " +
                                          "pour les anciennes versions de plate-forme ou des API utilitaires qui ne font pas partie des API du framework. "
            ),

         Aproposdenous_librairiesItem(
                 librairie_name = " implementation \" 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'",
                 librairie_description = " Ce sont des composants prenant en charge le cycle de vie exécutent des actions en réponse à une modification de l'état du cycle de vie d'un autre composant, telles que des activités et des fragments. " +
                                         "Ces composants vous aident à produire un code mieux organisé et souvent plus léger, plus facile à gérer."
            ),

         Aproposdenous_librairiesItem(
                 librairie_name = " implementation \" 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'",
                 librairie_description = " Extensions Kotlin pour l'artefact 'viewmodel' "
            ),
         Aproposdenous_librairiesItem(
                  librairie_name = " implementation \" 'androidx.legacy:legacy-support-v4:1.0.0'",
                  librairie_description = " La bibliothèque de support est une bibliothèque statique que vous pouvez ajouter à votre application Android afin d'utiliser des API " +
                                            "qui ne sont pas disponibles pour les anciennes versions de plate-forme ou des API utilitaires qui ne font pas partie des API du framework. "
            ),
         Aproposdenous_librairiesItem(
                  librairie_name = " implementation \"com.squareup.retrofit2:retrofit:2.6.0",
                  librairie_description = " Un client HTTP de type sécurisé pour Android et Java. "
            ),

         Aproposdenous_librairiesItem(
                  librairie_name = " implementation \"com.squareup.okhttp3:okhttp:3.12.0",
                  librairie_description = " Le client HTTP méticuleux de Square pour Java et Kotlin. "
            ),

         Aproposdenous_librairiesItem(
                  librairie_name = " implementation \" 'com.squareup.okhttp3:logging-interceptor:3.8.0'",
                  librairie_description = "Square’s meticulous HTTP client for Java and Kotlin. "
            ),
         Aproposdenous_librairiesItem(
                  librairie_name = " implementation \" 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9'",
                  librairie_description = "Une coroutine est un modèle de conception d'accès concurrentiel que vous pouvez utiliser sur Android pour simplifier le code qui s'exécute de manière asynchrone. " +
                                          "Les coroutines ont été ajoutées à Kotlin dans la version 1.3 et sont basées sur des concepts établis d'autres langages. "
            ),

         Aproposdenous_librairiesItem(
                 librairie_name = " testImplementation \" 'junit:junit:4.13.1'",
                 librairie_description = "JUnit est un framework de test unitaire pour Java, créé par Erich Gamma et Kent Beck. "
            ),

         Aproposdenous_librairiesItem(
                  librairie_name = " implementation\"com.synnapps:carouselview:0.1.5",
                  librairie_description = "Le carrousel est un composant pour montrer aux utilisateurs un diaporama, généralement des images. " +
                                          "Sous Android, nous pouvons facilement créer ce composant à l'aide d'une bibliothèque open source appelée CarouselView. "
            ),

         Aproposdenous_librairiesItem(
                  librairie_name = " implementation 'com.squareup.picasso:picasso:2.71828'",
                  librairie_description = "Une puissante bibliothèque de téléchargement d'images et de mise en cache pour Android "
            ),
    )
}