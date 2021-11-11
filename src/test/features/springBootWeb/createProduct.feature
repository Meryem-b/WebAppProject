Feature: Create Product

	Background: Launch the web site
		Given Launch web site
		
	Scenario: Create product
		When Click the create product button
		And Fill the data table
		|Fields			|Values		|
		|productId		|1			|
		|description	|T-shirt	|
		|price			|15			|
		|imageUrl		|https://productimages.hepsiburada.net/l/37/600-800/10544243933234.jpg|
		Then Submit button