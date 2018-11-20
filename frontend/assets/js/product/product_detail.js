$(document).ready(function () {
    var url_string = window.location.href;
    var url = new URL(url_string);
    var productId = url.searchParams.get("productid");
    $.get("https://promptkai-api-bright-chimpanzee.mybluemix.net/product/"+productId, function (product, status) {
        if (status === 'success') {
            $('#productname').text(product.productName);
            $('#productdetail').text(product.productDetail);
            $('#productprice').text(product.productPrice);
            $('#productimg').attr('src', product.imgPath);

        } else {
            $('#productname').text('Fetch Errors ?');
            $('#productdetail').text('Fetch Errors ?');
            $('#productprice').text('Fetch Errors ?');
        }
    });
});


$('#buybtn').click(function(){
    var url_string = window.location.href;
    var url = new URL(url_string);
    var productId = url.searchParams.get("productid");
    var productName = document.getElementById ( "productname" ).innerText
    var productPrice = document.getElementById ( "productprice" ).innerText
    var quantity = document.getElementById ( "quantity" ).value
   window.location.href='payment.html?productid='+productId+'&quantity='+quantity;
})
