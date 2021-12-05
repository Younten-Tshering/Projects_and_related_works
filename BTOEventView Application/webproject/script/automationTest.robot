*** Settings ***
Library  Selenium2Library
*** Variables ***
${URL}  http://web8.cs.ait.ac.th
${BROWSER}  Chrome
${delay}  1
*** Test Cases ***
1. Open Website
    Open Browser    ${URL}    ${BROWSER} 
    Maximize Browser Window
    Set Selenium Speed  0.3 
2. Click on Sign in
   Click Element   //a[contains(text(),'Sign in')]   
   Sleep  2s
3. Input email and password
   Input Text  name=user[email]  st121775@ait.asia 
   Input Text  name=user[password]  web888
4. Login
   Click Button  //*[contains(text(),'Log in')]
5. Click to view the event list
    Click Element   //a[contains(text(),'Events')]
6. Click on show to view more details
    Sleep  2s
    Click Element   //a[contains(text(),'Show')] 
    Sleep  2s
7. Click on back to view the event list again
    Click Element   //a[contains(text(),'Back')] 
    Sleep  2s
8. Click on the like option - if user liked the event
    Click Element   //a[contains(text(),'Like')] 
    Sleep  2s
9. Logout
    Click Element   //a[contains(text(),'Sign out')]
    Sleep  2s
10. Close Browser
    Close Browser