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
        setProfile();
        redirectPreviousPath();
    } else {
        redirectToLogin();
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

function setProfile() {
    return FB.api('/me', { fields: 'id,name,email' },function (response) {
        var profileSection = document.getElementById("profile_section");
        if (profileSection) {
            document.getElementById("profile_image").setAttribute("src", "https://graph.facebook.com/" + response.id + "/picture?type=normal");
            document.getElementById("name").innerText = response.name;
            document.getElementById("email").innerText = response.email;
        }
    });
}

function redirectPreviousPath(){
    const cookiePath = Cookies.get('path');
    if (cookiePath && window.location.pathname != cookiePath) {
        return window.location.replace(cookiePath);
    }
    Cookies.remove('path');
}

function redirectToLogin(){
    const path = window.location.pathname;
    if (!path.includes('login')) {
        Cookies.set('path', path);
        return window.location.replace("/login");
    }
}

function logout() {
    FB.logout(function(response) {
        console.log('logout')
    });
}

