var image = window.location.host + '/assets/img/logo.png';

$(document).ready(function () {
    $('button.omise-checkout-button').click(function () {
        document.querySelector('.OmiseCheckoutForm img').src = image;
    });
});