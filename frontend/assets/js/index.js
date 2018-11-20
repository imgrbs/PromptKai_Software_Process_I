$('#type').on('change', function() {
    var filter = this.value;
    if(filter == 'เลือกหมวดหมู่'){
        $.get("https://promptkai-api-bright-chimpanzee.mybluemix.net/products", function (data, status) {
            if (status == 'success') {
                var productElements = '';
                data.forEach(function (product) {
                    productElements +=
                        '<a class="col-6 col-lg-3 text-center mb-3" href="product_detail.html?productid='+
                        product.id+'" style="color:black ; text-decoration: none" >'+
                        '<div class="card border-0">' +
                        '<img class="card-img-top" src="' + product.imgPath + '" alt="' + product.productName + '">' +
                        '<div class="card-body p-0">' +
                        '<h5 class="mt-3 mb-0"><b>' + product.productName + '</b></h5>' +
                        'รหัสสินค้า' + product.id + '<br>' +
                        product.productPrice + 'บาท<br>' +
                        '</div></div></a>';
                })
                $('#products').html(productElements);
            } else {
                $('div#text h1').text('Fetch Errors :(')
            }
        });
    }else{
        $.get("https://promptkai-api-bright-chimpanzee.mybluemix.net/products?filter="+filter, function (data, status) {
            if (status == 'success') {
                var productElements = '';
                data.forEach(function (product) {
                    productElements +=
                        '<a class="col-6 col-lg-3 text-center mb-3" href="product_detail.html?productid='+
                        product.id+'" style="color:black ; text-decoration: none" >'+
                        '<div class="card border-0">' +
                        '<img class="card-img-top" src="' + product.imgPath + '" alt="' + product.productName + '">' +
                        '<div class="card-body p-0">' +
                        '<h5 class="mt-3 mb-0"><b>' + product.productName + '</b></h5>' +
                        'รหัสสินค้า' + product.id + '<br>' +
                        product.productPrice + 'บาท<br>' +
                        '</div></div></a>';
                })
                $('#products').html(productElements);
            } else {
                $('div#text h1').text('Fetch Errors :(')
            }
        });
    }
});