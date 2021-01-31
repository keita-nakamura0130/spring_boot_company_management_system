package com.keita.nakamura.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;

import com.keita.nakamura.security.LoginUserDetails;

/**
 * 認証インターセプター
 */
@Component
public class AuthIntercepter implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        return true;
    }
    
    private void a(Model model) {
        // ログインユーザー情報を取得
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof LoginUserDetails) {
            LoginUserDetails user = LoginUserDetails.class.cast(authentication.getPrincipal());
            model.addAttribute("user", user.getUser());
        } else {
            model.addAttribute("user", null);
        }
    }
}
