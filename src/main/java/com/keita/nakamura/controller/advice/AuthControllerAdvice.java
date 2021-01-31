package com.keita.nakamura.controller.advice;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.keita.nakamura.security.LoginUserDetails;

/**
 * 認証コントローラーアドバイス
 */
@ControllerAdvice
public class AuthControllerAdvice {

    /**
     * ログインしているユーザーを取得
     *
     * @param model
     */
    @ModelAttribute
    public void getLoginUser(Model model) {
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
