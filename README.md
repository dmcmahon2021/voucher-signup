voucher.signup

# Getting Started with Voucher.SignUp

This gradle project was created with [spring initializr](https://start.spring.io/). It uses a local SQL database [H2](https://www.h2database.com/).

## Available Scripts

In the project directory, you can run:

### `./gradlew bootRun`

## Testing it out

Using your HTTP tool of choice, do the following as Method "POST": localhost:8080/submission

##### POST HTTP Body Format:

{
"firstname": "Damon",
"lastname": "McMahon",
"age": 29,
"dateOfBirth": "01/10/1991",
"email": "damon.mcmahon@service.nsw.gov.au",
"mobileNumber": "0412321123",
"medicareCard": {
"number": 2566788555,
"expiryMonth": 2,
"expiryYear": 2022
} }

This will return a randomly generated 12 character alphanumeric string as a voucherNumber Object in JSON.

###### Requirements not yet met

###### • Only one voucher to be generated per Medicare number. If a request from the same number comes through, it should return the voucher number generated previously.
###### • Include server side validation - unable to validate embedded class*