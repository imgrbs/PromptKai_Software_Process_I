// Load the SDK asynchronously
(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
    }(document, 'script', 'facebook-jssdk'));

function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    if (response.status === 'connected') {
        fetchUser();
    } else {
    }
}

function checkLoginState() {
    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });
}

window.fbAsyncInit = function() {
    FB.init({
        appId      : '257585084911795',
        cookie     : true,
        xfbml      : true,
        version    : 'v2.8'
    });

    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
    });

    FB.Event.subscribe("auth.logout", function() {
        window.location.replace("/")
    });
};

function fetchUser() {
    return FB.api('/me', function(response) {
        console.log('Successful login for: ' + response.name);
    });
}

}

function logout() {
    FB.logout(function(response) {
        console.log('logout')
    });
}

