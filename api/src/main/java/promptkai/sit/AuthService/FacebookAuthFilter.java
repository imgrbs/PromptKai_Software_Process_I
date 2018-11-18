package promptkai.sit.AuthService;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FacebookAuthFilter extends OncePerRequestFilter {
    private final String FACEBOOK_API = "https://graph.facebook.com";
    String FIELDS = "fields=id,name,email";

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException, HttpClientErrorException {
        String accessToken = request.getHeader("Authorization");
        if (accessToken != null) {
            RestTemplate restTemplate = new RestTemplate();
            String url = FACEBOOK_API + "/v3.2/me?" + FIELDS + "&access_token=" + accessToken;
            FacebookResponse user = restTemplate.getForEntity(url, FacebookResponse.class).getBody();
            if (user != null) {
                chain.doFilter(request, response);
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized.");
        }
    }
}
