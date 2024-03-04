Feature: Identifying Courses
Scenario: Searching Web Development Courses
  Given user navigates to Coursera website
  When searches for Web Development Courses
  And level is selected as beginner
  And language is selected as English
  Then get first course details
  And get second course details


Scenario: Searching Language Learning
  Given user navigates to the home page
  When searches for Language Learning
  Then count of levels available is taken
  Then count of languages available is taken

 
Scenario: Filling ready to transform form
  Given user navigates back to the home page
  And clicks for enterprise
  When solution is selected
  And clicks coursera for campus
  Then fills ready to transform form
  And clicks submit button
  And captures error message
