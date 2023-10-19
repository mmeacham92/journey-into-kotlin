package com.example.kotlinnotes
/*
Intents:
- Android system for communicating between different components
- A request given to:
    - Your own application (one activity to another activity)
    - An external application (maybe the Camera app)
    - A built-in Android service

A very common design pattern of using intent requests within an application is:

* You have an activity which displays a list of views (Persons in the first RVPractice, maybe a list of tweets, a menu, etc) and when one of these views is clicked, we change to a different activity which shows details about the item which was clicked *

Use Cases:
- Email list -> detail view
- Tweet list -> single tweet
- Data params can be passed to the child activity (the 'clicked' view is the parent while the next-to-be-shown view is the child)
- Data can also be returned to the parent activity (have seen this when using MyFitnessPal)

How it works:
- Create a new XML layout file for the UI
- Create a Kotlin file for the business logic
- Adds the activity to the AndroidManifest.xml file so your app is aware of it

<application>
    ...
    <activity android:name=".AddContactActivity"></activity>
</application>

^^^^^^^ These steps will happen automatically if we use Android Studio to create the new activity for us

Create an intent:
- Navigate to the newly created Activity (usually in response to an event)
    - val myIntent = Intent(this, ActivityName::class.java)
    - startActivity(myIntent)

- If you want to pass data into the 2nd activity, call putExtra on the intent. Think of it like a map
    - val myIntent = Intent(this, ActivityName::class.java)
    - myIntent.putExtra("tweet_id", 1234)
    - myIntent.putExtra("username", "bigmeach")
    - startActivity(myIntent)


RecyclerView:
- RecyclerView is freaking sweet...
- Initially, create as many views as needed to fill UI
- As the user scrolls, elements which fall off the screen ("discarded views") are recycled
- The "dirty" views are bound with new data, then displayed as the next view seen
- This decreases how much memory is needed (compared to a ListView) since we only have to create a fixed number
    of views, then we can recycle as needed

- RecyclerView uses a LayoutManager to control how views are displayed
- The RecyclerView is attached to an Adapter
- The Adapter is responsible for binding data to each views
- The Adapter does this by "communicating" with a dataset (API, database, data object, etc)

*/