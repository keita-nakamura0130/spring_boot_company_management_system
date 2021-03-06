package com.keita.nakamura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keita.nakamura.entity.User;
import com.keita.nakamura.security.LoginUserDetails;
import com.keita.nakamura.service.UserService;

/**
 * 認証コントローラー
 */
@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * ログイン画面
     *
     * @return
     */
    @GetMapping(value = "/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error, Model model) {
        // ログインしていた場合、会社一覧にリダイレクト
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof LoginUserDetails) {
            LoginUserDetails user = LoginUserDetails.class.cast(authentication.getPrincipal());
            if (user != null) {
                return "redirect:/companies/index";
            }
        }

        // エラーメッセージ
        boolean isError = false;
        if (error != null) {
            isError = true;
        }
        model.addAttribute("isError", isError);

        return "auth/login";
    }

    /**
     * ログイン成功時のメニュー画面への遷移
     *
     * @return
     */
    @PostMapping(value = "/login")
    public String postLogin() {
        return "redirect:/companies/index";
    }

    /**
     * ユーザー追加画面
     */
    @GetMapping(value = "/users/create")
    public String create(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "users/create";
    }

    /**
     * ユーザー追加
     */
    @PostMapping(value = "/users/create")
    public String store(@ModelAttribute @Validated User user, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "users/create";
        }

        // パスワードをハッシュ化
        String password = user.getPassword();
        password = passwordEncoder.encode(password);
        user.setPassword(password);

        userService.insert(user);

        redirectAttributes.addFlashAttribute("success", "ユーザーを追加しました。");

        return "redirect:/companies/index";
    }
}
