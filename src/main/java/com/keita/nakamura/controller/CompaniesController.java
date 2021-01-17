package com.keita.nakamura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.keita.nakamura.entity.Company;
import com.keita.nakamura.service.CompanyService;

/**
 * Companiesコントローラー
 */
@Controller
public class CompaniesController {

    @Autowired
    CompanyService CompanyService;

    /**
     * 都道府県リスト(都道府県コードを都道府県に変換するために使用)
     */
    public static final String[] PREFECTURES = { null, "北海道", "青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県", "茨城県", "栃木県", "群馬県", "埼玉県",
            "千葉県", "東京都", "神奈川県", "新潟県", "富山県", "石川県", "福井県", "山梨県", "長野県", "岐阜県", "静岡県", "愛知県", "三重県", "滋賀県", "京都府",
            "大阪府", "兵庫県", "奈良県", "和歌山県", "鳥取県", "島根県", "岡山県", "広島県", "山口県", "徳島県", "香川県", "愛媛県", "高知県", "福岡県", "佐賀県",
            "長崎県", "熊本県", "大分県", "宮崎県", "鹿児島県", "沖縄県" };

    /**
     * 会社一覧
     */
    @GetMapping(value = "/companies/index")
    public String index(Model model) {
        List<Company> companies = CompanyService.findAll();
        model.addAttribute("companies", companies);

        model.addAttribute("PREFECTURES", PREFECTURES);

        return "/companies/index";
    }

    /**
     * 会社詳細
     */
    @GetMapping(value = "/companies/show/{id}")
    public String show(@PathVariable int id, Model model) {
        Company company = CompanyService.findById(id);
        model.addAttribute("company", company);

        model.addAttribute("PREFECTURES", PREFECTURES);

        return "companies/show";
    }

    /**
     * 会社追加画面
     */
    @GetMapping(value = "/companies/create")
    public String create(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);

        return "companies/create";
    }

    /**
     * 会社追加
     */
    @PostMapping(value = "/companies/create")
    public String store(@ModelAttribute @Validated Company company, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "companies/create";
        }
        CompanyService.insert(company);

        redirectAttributes.addFlashAttribute("success", "会社を追加しました。");

        return "redirect:/companies/index";
    }

    /**
     * 会社編集画面
     */
    @GetMapping(value = "/companies/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Company company = CompanyService.findById(id);
        model.addAttribute("company", company);

        return "companies/edit";
    }

    /**
     * 会社編集
     */
    @PostMapping(value = "/companies/edit/{id}")
    public String update(@ModelAttribute @Validated Company company, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "companies/edit";
        }
        CompanyService.update(company);

        redirectAttributes.addFlashAttribute("success", "会社を編集しました。");

        return "redirect:/companies/index";
    }

    /**
     * 会社削除画面
     */
    @GetMapping(value = "/companies/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Company company = CompanyService.findById(id);
        model.addAttribute("company", company);

        model.addAttribute("PREFECTURES", PREFECTURES);

        return "companies/delete";
    }

    /**
     * 会社削除
     */
    @PostMapping(value = "/companies/delete/{id}")
    public String destroy(@PathVariable int id, RedirectAttributes redirectAttributes) {
        CompanyService.delete(id);

        redirectAttributes.addFlashAttribute("success", "会社を削除しました。");

        return "redirect:/companies/index";
    }
}
