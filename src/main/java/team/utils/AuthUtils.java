package team.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {
    public static String getSessionId(){
        team.bahor.config.security.UserDetails principal = (team.bahor.config.security.UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getId();
    }

    public static boolean sessionHasRole(String role){
        team.bahor.config.security.UserDetails principal = (team.bahor.config.security.UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getAuthorities().stream().filter(grantedAuthority -> {
            return grantedAuthority.getAuthority().equalsIgnoreCase(role);
        }).count()==1;
    }
}
