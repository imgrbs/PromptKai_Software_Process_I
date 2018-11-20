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
    });

    FB.getLoginStatus(function(response) {
        statusChangeCallback(response);
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
    });
}

