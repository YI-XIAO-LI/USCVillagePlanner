# USCVillagePlanner
GIF Demonstration:
![](https://github.com/WeiLong27/public_project_gif/blob/master/dynamic_island.gif)

Run Instructions:
* Import unzipped project directory
* Set up Android Studio + Emulator
   - Ensure emulator is Pixel 4 API 33 (this should be your ‘running device’), If you don’t have Pixel 4 API 33 in your Android Studio, create a new device with Pixel 4 API 33 configuration at Device Manager.
   - Start the Pixel 4 API 33 emulator device, and this app will only support running in portrait mode
   - [Required] Try running the app first, then the app should appear on your emulator device. Then go to the emulator’s home page, swipe up and go to ‘Settings’, then scroll down to ‘Location’, toggle the ‘Use Location’ to be on, this ensures that the Village Planner App can access google location services. Then, click on “App Location Permissions” to enable location for the app “USC Village Planner”, choose “Allow only while using the app”, toggle to enable “Use Precise  Location.”
   - [Optional but Strongly Recommended] In the Android Studio Emulator window, click on ‘Extended Controls’ (it is a button with an icon of 3 dots lined vertically).
   - Select ‘Location’ on the sidebar, and click/search any location on the map, and you may choose to save that location as a ‘saved point’ and click on ‘Set Location’ to manually set your emulator device’s location. It is strongly recommended that you set a location near the USC campus region.
   - Click on the Run App icon to start the application
* The application will now officially start on your emulator window panel

[TroubleShooting - Build Project] If build failed, try clean and rebuild the project
[Troubleshooting - Google Login]

Our google login functionality may be unstable, but we will fix it in later iterations.
In the case where you choose to sign in via Google OAuth and find that the app is stuck in the login/register page, there are 2 ways to fix this:
1. If the screen did not turn gray, try clicking on the Google Sign in Button again (usually it won’t happen).
2. If the screen turns gray, then wait for 5-10 seconds, Google Sign in may take a short while to authenticate.
3. If the app is still not responding, or if the screen is gray and no clicks work, close the Emulator device (click on the ‘X’ icon next to the Pixel 4 API 33 title bar near the top of the Emulator window.
   Then, towards the rightmost of android studio, click on ‘Device Manager’. There, you will see your Pixel 4 API 33 device, try clicking on the downward arrow towards the right and select ‘Wipe Data’ then select ‘Cold Reboot Now’ to restart the emulator device. If it pops up a message saying your emulator device is still running, open your emulator window again and make sure you click on the ‘X’ icon to stop the device. And repeat this step again.

[TroubleShooting - Data Loading of Main/Reminder/Profile pages] Sometimes, it may take a few seconds for an application to load, therefore, please allow 5-7 seconds for reminders/map/profile to load (since it is retrieving data from the cloud).

Email Register and Login
* By selecting “Go to Register” -> entering registration information -> “Register”, you will be able to create a new account. Select “Go to Login” will direct you back to the Login page.
* We also have a few existing account for you to explore and test:
   - Email: 1@1.com; Password: 111111
   - Profile photo is already changed for demo purposes
   - Email: 2@2.com; Password: 222222
   - Email: batman@gmail.com; Password: 123456
* Profile photo is already changed for demo purposes

Run Instructions for Different Functions

* When landing on the home page, if the Location does not automatically animate to current location: Click on the “locate” icon the top right of the map. If it is the first time you use the app, the default location is set to USC SCA building.

Routing and Wait time Query
* To route to a restaurant, simply click on the red location icon and a route will be generated from your current location to the target location.

* Note: The first time a user clicks on a red location icon to display a route may take some time as the Google Map Services API is a little slow to connect and load on the emulator upon startup, this is completely normal. Subsequent routings should load faster than the initial one.
* Name, address, and Wait time of each restaurant will be displayed on top of the location icon when clicked on.
* Route time and total time to order at each restaurant will be displayed under google map.

Add a Reminder
* Select a red location icon, then click on the Add Reminder button, choose a time, then save the reminder.
* Reminders will appear on the reminders page (you can navigate to the reminders page from the navigation bar at the bottom). To cancel a reminder, simply click the cancel button on the top right corner of each reminder.
* When time’s up, you should be able to receive an in-app pop-up notification displaying details of the reminder. Once a user is done with the pop-up notification reminder, the user can select “Acknowledge and Delete” which will close the pop-up and remove the reminder from the database. Click the link below for a screenshot of such a notification.
![image](https://user-images.githubusercontent.com/50726914/200222364-b7af9305-262f-43d8-8aa6-79da7868fc4a.jpg)

Displaying and Adding Profile Photo

* By default, google-sign-in users’ profile photo will be the same one as their google account’s photo, and email sign-in user’s profile photo will be default to null. All user’s profile information can be found at the profile page (navigate to the profile page by the navigation bar at the bottom); Only email sign-in users are able to change their profile photos.
* [Required] Before changing the profile photo, there should be at least one photo in “Photos” so that you can upload a photo to change your profile picture. You can use the camera app in the emulator to take a photo (emulator will auto-generate a picture), and it will automatically be saved to “Photos.”
* Click on the image icon and you will be directed to selecting an image. You can upload an image from the local emulator device. When directing to select an image, click on the left navigation menu, choose your SDK device, click on the “Pictures” folder, pictures you took from the previous step should appear. Select any pictures to be your profile photo.

(Extra Feature) Add a new Restaurant and Map Reset
* At the home page, click on the “Add a New Restaurant” Button. Enter the restaurant name, latitude and longitude, to add a new restaurant on to the map. If you want to discard all the added restaurants and revert to the original restaurants’ map in the USC Village, then simply click on the “Revert to Original Map” button at Home page. Click on the “locate” icon on the top right corner, then you will be able to revert back to the original village restaurant map that is initialized in the app by default.
