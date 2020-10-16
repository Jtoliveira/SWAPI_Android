# SWAPI_Android
Basic Android application using a Star Wars API (SWAPI). 

  The game starts with a grid where you can choose one of 6 categories. Since i couldn't work with the AsyncTask and multiple activities,
when the category is chosen the gridLayout is set to invisible and the layout of the category is visible to the user.
  
  The method to switch layouts also calls on the AsyncTask (i made one class for each category since i needed some textViews to update when the call to the API finished
  and i couldn't for the life of me deal with the asynchronous aspect of it all) in the form of the generate() methods.
  
  
