
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

* [Architecture][1] - collection of libraries 
  * [Data Binding][2] - Declaratively bind observable data to UI elements.
  * [Lifecycles][3] - Create a UI that automatically responds to lifecycle events.
  * [LiveData][4] - Build data objects that notify views when the underlying database changes.
  * [Navigation][5] - Handle everything needed for in-app navigation.
  * [Room][6] - Access your app's SQLite database with in-app objects and compile-time checks.
  * [Recycler View][7] - RecyclerView makes it easy to efficiently display large sets of data
 

* Third party and miscellaneous libraries
  * [Coil][8] - for image loading
  * [Hilt][9] - for [dependency injection][10] 
  * [Kotlin Coroutines][11] - for managing background threads with simplified code and reducing needs for callbacks
  * [Gson][12] - for converting Objects into their JSON representation 
  * [Retrofit][13] - for making network calls
  * [Jsoup][14] - for extracting data from HTML 
  * [Shimmer][15] - for adding shimmer effect when viewing data



[1]: https://developer.android.com/jetpack/arch/
[2]: https://developer.android.com/topic/libraries/data-binding/
[3]: https://developer.android.com/topic/libraries/architecture/lifecycle
[4]: https://developer.android.com/topic/libraries/architecture/livedata
[5]: https://developer.android.com/topic/libraries/architecture/navigation/
[6]: https://developer.android.com/topic/libraries/architecture/room
[7]: https://developer.android.com/guide/topics/ui/layout/recyclerview
[8]: https://coil-kt.github.io/coil/
[9]: https://developer.android.com/training/dependency-injection/hilt-android
[10]: https://developer.android.com/training/dependency-injection
[11]: https://kotlinlang.org/docs/reference/coroutines-overview.html
[12]: https://github.com/google/gson
[13]: https://square.github.io/retrofit/
[14]: https://jsoup.org/
[15]: https://facebook.github.io/shimmer-android/

Upcoming features
-----------------
Updates will include incorporating the favorites fragment where users can save their favorite recipes for later use!
    
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
  
