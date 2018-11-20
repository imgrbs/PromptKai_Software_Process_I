document.getElementsByClassName('omise-checkout-button')[0].className = 'omise-checkout-button fixed-bottom w-100 text-center button-primary pt-2 pb-1';

const params = new URLSearchParams(window.location.search);
const quantity = params.get('quantity');
const productId = params.get('productid');

$.get("https://promptkai-api-bright-chimpanzee.mybluemix.net/product/"+productId, function (product, status) {
    if (status === 'success') {
        const productprice = product.productPrice;
        const totalPrice = quantity * productprice;
        $('#productname').text(product.productName);
        $('#productprice').text(productprice);
        $('#productimg').attr('src', product.imgPath);
        $('#totalprice').text(totalPrice);
        $('#quantity').text(quantity)

        document.getElementById('productId').value = product.id;
        document.getElementById('totalPrice').value = totalPrice;
        document.getElementById('amount').value = quantity;

        document.getElementById('description').value = 'Product order ฿' + totalPrice + '.00'
        document.getElementById('omise').setAttribute('data-amount', totalPrice * 100)
    }
})

