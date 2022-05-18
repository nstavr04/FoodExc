
# FoodExc - Food Recipe Android Application


<p align="center">
 <a href="https://amplication.com" target="_blank">
    <img alt="amplication-logo" height="200" alt="FoodExc Logo" src="https://user-images.githubusercontent.com/63290952/169091661-43734fed-7ae6-493e-9663-f32b7d63ef7f.png"/>
  </a>
</p>


Description
=================

FoodExc is a food recipes app where Exchange students can find out about various international cuisines and try out some recipes themselves!<br/>

The application was developed as a team project during the Android Porgramming course offered by the University of Southern Denmark (SDU).


Spoonacular API
-----------

FoodExc uses the [Spoonacular API](https://spoonacular.com/food-api) to load recipes on the main activity
and also load recipe instructions and ingredients in the details activity of our application. <br/>
See [Spoonacular API Documentation](https://spoonacular.com/food-api/docs) for more details.


Screenshots
-----------
<p float="left">
  
<img src="https://user-images.githubusercontent.com/63290952/169118209-59acf290-c809-4d0b-9bcc-bb1cc2720bd6.jpg" height="500" width="200" />

<img src="https://user-images.githubusercontent.com/63290952/169125203-ed68e934-f917-49f8-952e-391dd69eeceb.jpg" height="500" width="200" />
  
<img src="https://user-images.githubusercontent.com/63290952/169118236-d1b95dc3-a1c9-445b-818e-6810e76f2343.jpg" height="500" width="200"/>
  
<img src="https://user-images.githubusercontent.com/63290952/169118259-38e10612-fd2f-43fe-98a3-8380bd3d731a.jpg" height="500" width="200"/>
  
</p>

Libraries Used
--------------
* [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
  multidex and automated testing.
  * [AppCompat][1] - Degrade gracefully on older versions of Android.
  * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
  * [Test][4] - An Android testing framework for unit and runtime UI tests.
* [Architecture][10] - A collection of libraries that help you design robust, testable, and
  maintainable apps. Start with classes for managing your UI component lifecycle and handling data
  persistence.
  * [Data Binding][11] - Declaratively bind observable data to UI elements.
  * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
  * [LiveData][13] - Build data objects that notify views when the underlying database changes.
  * [Navigation][14] - Handle everything needed for in-app navigation.
  * [Room][16] - Access your app's SQLite database with in-app objects and compile-time checks.
  * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
     asynchronous tasks for optimal execution.
  * [WorkManager][18] - Manage your Android background jobs.
* [UI][30] - Details on why and how to use UI Components in your apps - together or separate
  * [Animations & Transitions][31] - Move widgets and transition between screens.
  * [Fragment][34] - A basic unit of composable UI.
  * [Layout][35] - Lay out widgets using different algorithms.
* Third party and miscellaneous libraries
  * [Glide][90] for image loading
  * [Hilt][92]: for [dependency injection][93]
  * [Kotlin Coroutines][91] for managing background threads with simplified code and reducing needs for callbacks

[0]: https://developer.android.com/jetpack/components
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[4]: https://developer.android.com/training/testing/
[10]: https://developer.android.com/jetpack/arch/
[11]: https://developer.android.com/topic/libraries/data-binding/
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[14]: https://developer.android.com/topic/libraries/architecture/navigation/
[16]: https://developer.android.com/topic/libraries/architecture/room
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[18]: https://developer.android.com/topic/libraries/architecture/workmanager
[30]: https://developer.android.com/guide/topics/ui
[31]: https://developer.android.com/training/animation/
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout
[90]: https://bumptech.github.io/glide/
[91]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[92]: https://developer.android.com/training/dependency-injection/hilt-android
[93]: https://developer.android.com/training/dependency-injection

Upcoming features
-----------------
Updates will include incorporating the favorites fragment where users can save their favorite recipes for later use!


License
-------
This project is licensed under the [MIT Licence](https://choosealicense.com/licenses/mit/)
    
Contributors ✨
-------

<table>
  <tr>
    <td align="center"><a href="https://github.com/Kasoulides"><img src="https://avatars.githubusercontent.com/u/63290952?v=4/u/43705455?v=4?s=100" width="100px;" alt=""/><br/><sub><b>Christos Kasoulides</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/nstavr04"><img src="https://avatars.githubusercontent.com/u/60655570?v=4/u/63290952?v=4/u/43705455?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Nikolas Stavrou</b></sub></a><br /></td>
    <td align="center"><a href="https://github.com/celeft01"><img src="https://avatars.githubusercontent.com/u/63289367?v=4/u/63290952?v=4/u/43705455?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Christos Eleftheriou</b></sub></a><br /></td>
  <td align="center"><a href="https://github.com/apatti01"><img src="https://avatars.githubusercontent.com/u/63289392?v=4/u/63290952?v=4/u/43705455?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Andreas Pattichis</b></sub></a><br /></td>
  </tr>
</table>
  
