Travel Journal – Milestone 3

Local Storage, Room Database, MVVM Architecture, Jetpack Compose UI

This milestone builds on the previous work by adding persistent local storage using the Room Database. 
The app now allows users to create, store, and view travel journal entries (Trips) directly on the device.

Overview of Milestone 3

The goal of this milestone was to integrate a local database system into the Travel Journal application. My implementation uses:
-	Room Database for local offline storage.
-	DAO (Data Access Object) to handle database queries.
-	Repository layer to separate data logic
-	ViewModel and Factory for UI-friendly data handling
-	Jetpack Compose for all screens
-	MVVM architecture for clean structure and separation of concerns


The app now supports adding and displaying saved travel trips.

-	 Room Database Integration: Created a Trip entity storing Title, Destination, Configured AppDatabase with Room to store data locally. and added TripDao with insert and query functions.

-	Repository Pattern Implemented TripRepository for clean data management., Keeps UI separate from database operations and Prevents direct DB access inside the UI.

-	 MVVM Architecture TripViewModel exposes live data for the UI, TripViewModelFactory provides dependencies correctly and Ensures configuration-change safety (e.g., rotation).

-	Jetpack Compose Screens TripListScreen displays all saved trips in a clean, scrollable UI and AddTripScreen Users can enter Trip name, Destination , Date, Notes and 	Then now save the trip into the database MainActivity , Loads the entire Compose app and attaches the TripViewModel.

Technologies I  Used
-	Kotlin
-	Jetpack Compose
-	Room Database
-	ViewModel and LiveData/State
-	Material 3 Design
-	MVVM Architecture Pattern

Conclusion

Milestone 3 successfully transforms the app from a sensor-focused project into a fully functional journal system with persistent storage.
my implementation follows best practices using Room, Repository, and MVVM, while maintaining a clean Jetpack Compose UI.
