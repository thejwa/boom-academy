package team.bahor.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import team.bahor.config.security.UserDetails;
import team.bahor.entity.user.Principal;

public class Utils {
    public static String getSessionId() {
        return ((Principal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

    public static boolean sessionHasRole(String role) {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .stream().
                filter(grantedAuthority -> {
                    return grantedAuthority.getAuthority().equalsIgnoreCase(role);
                })
                .count() == 1;
    }
}
