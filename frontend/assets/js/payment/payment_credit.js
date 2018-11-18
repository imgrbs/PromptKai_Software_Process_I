// Serialize the card into a valid card object.
var card = {
  name: "BUMBIN ARAUPORN",
  number: "4242424242424242",
  expiration_month: "02",
  expiration_year: "2020",
  security_code: "111",
}

Omise.createToken('card', card, function(statusCode, response) {
    if (statusCode == 200) {
    console.log(response)

    // Success: send back the TOKEN_ID to your server to create a charge.
    // The TOKEN_ID can be found in `response.id`.
  } else {
    // Error: display an error message. Note that `response.message` contains
    // a preformatted error message. Also note that `response.code` will be
    // "invalid_card" in case of validation error on the card.

    // Example Error displaying
    alert(response.code + ': ' + response.message)
  }
})