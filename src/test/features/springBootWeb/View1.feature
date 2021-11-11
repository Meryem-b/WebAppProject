Feature: View images

	Background: Launch the web site
		Given To launch web site
		
	Scenario: Get first product page and copy link
		When Click the first product button
		And Click the first view
		Then Get text of first URL and type to google search
		
	Scenario: Get second product page and copy link
		When Click the second product button
		And Click the second view
		Then Get text of second URL and type to google search