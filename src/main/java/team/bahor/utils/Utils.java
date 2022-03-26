package team.bahor.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import team.bahor.config.security.UserDetails;

public class Utils {
    public static String getSessionId() {
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
    }

    public static boolean sessionHasRole(String role) {
        return ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getAuthorities().stream()
                .filter(grantedAuthority -> {
                    return grantedAuthority.getAuthority().equalsIgnoreCase("ROLE_" + role);
                }).count() == 1;
    }
}
