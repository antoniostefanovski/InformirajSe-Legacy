package mk.awd.informirajse.config;

import mk.awd.informirajse.service.SessionService;
import mk.awd.informirajse.service.UserService;
import mk.awd.informirajse.service.interceptors.AuthInterceptor;
import mk.awd.informirajse.service.interceptors.SessionInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {
//    private final SessionInterceptor sessionInterceptor;
//
//    public InterceptorsConfig(SessionInterceptor sessionInterceptor) {
//        this.sessionInterceptor = sessionInterceptor;
//    }

    private final UserProfile userProfile;
    private final SessionService sessionService;
    private final UserService userService;

    public InterceptorsConfig(UserProfile userProfile, SessionService sessionService, UserService userService) {
        this.userProfile = userProfile;
        this.sessionService = sessionService;
        this.userService = userService;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionInterceptor(userProfile, sessionService, userService))
                .addPathPatterns("/api/**")
                .excludePathPatterns(authUrls);
    }

    List<String> authUrls = List.of(
            "/api/login",
            "/api/register",
            "/api/blogs",
            "/api/blog/{id}",
            "/api/delete-blog/{id}",
            "/api/new-blog",
            "/api/new-comment",
            "/api/delete-comment/{id}",
            "/api/edit-blog/{id}"
    );
}
