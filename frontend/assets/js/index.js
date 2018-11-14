$(document).ready(function () {
    $.get("http://promptkai-api-bright-chimpanzee.mybluemix.net/products", function (data, status) {
        if (status == 'success') {
            var products = data[0]
                document.getElementById("products")
        } else {
            $('div#text h1').text('Fetch Errors :(')
        }
    });
    
});