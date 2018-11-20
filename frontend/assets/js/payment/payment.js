document.getElementsByClassName('omise-checkout-button')[0].className = 'omise-checkout-button fixed-bottom w-100 text-center button-primary pt-2 pb-1';

const params = new URLSearchParams(window.location.search);
const quantity = params.get('quantity');
const prodoctId = params.get('productid');

$.get("https://promptkai-api-bright-chimpanzee.mybluemix.net/product/"+prodoctId, function (product, status) {
    if (status === 'success') {
        const productprice = product.productPrice
        const totalPrice = quantity * productprice
        $('#productname').text(product.productName);
        $('#productprice').text(productprice);
        $('#productimg').attr('src', product.imgPath);
        $('#totalprice').text(totalPrice);

        document.getElementById('description').value = 'Product order ฿' + totalPrice + '.00'
        document.getElementById('omise').setAttribute('data-amount', totalPrice * 100)
    }
})

