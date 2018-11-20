document.getElementsByClassName('omise-checkout-button')[0].className = 'omise-checkout-button fixed-bottom w-100 text-center button-primary pt-2 pb-1';

const params = new URLSearchParams(window.location.search);
const productprice = params.get('productprice');
const quantity = params.get('quantity');
const totalPrice = quantity * productprice

document.getElementById('description').value = 'Product order ฿' + totalPrice + '.00'
document.getElementById('omise').setAttribute('data-amount', totalPrice * 100)