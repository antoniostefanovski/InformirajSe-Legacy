package mk.awd.informirajse.service.interceptors;

import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        String token = (String) request.getSession().getAttribute("token");

        if(cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getValue().equals(token))
                    return true;
            }
        }

        return ResponseEntity.notFound().build().hasBody();
    }
}
