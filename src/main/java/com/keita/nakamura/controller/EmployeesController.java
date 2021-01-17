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

import com.keita.nakamura.entity.Employee;
import com.keita.nakamura.service.EmployeeService;

/**
 * Employeesコントローラー
 */
@Controller
public class EmployeesController {

    @Autowired
    EmployeeService EmployeeService;

    /**
     * 都道府県リスト(都道府県コードを都道府県に変換するために使用)
     */
    public static final String[] PREFECTURES = { null, "北海道", "青森県", "岩手県", "宮城県", "秋田県", "山形県", "福島県", "茨城県", "栃木県", "群馬県", "埼玉県",
            "千葉県", "東京都", "神奈川県", "新潟県", "富山県", "石川県", "福井県", "山梨県", "長野県", "岐阜県", "静岡県", "愛知県", "三重県", "滋賀県", "京都府",
            "大阪府", "兵庫県", "奈良県", "和歌山県", "鳥取県", "島根県", "岡山県", "広島県", "山口県", "徳島県", "香川県", "愛媛県", "高知県", "福岡県", "佐賀県",
            "長崎県", "熊本県", "大分県", "宮崎県", "鹿児島県", "沖縄県" };

    /**
     * 社員一覧
     */
    @GetMapping(value = "/employees/index/{companyId}")
    public String index(@PathVariable int companyId, Model model) {
        List<Employee> employees = EmployeeService.findAll(companyId);
        model.addAttribute("employees", employees);

        model.addAttribute("PREFECTURES", PREFECTURES);

        return "employees/index";
    }

    /**
     * 社員詳細
     */
    @GetMapping(value = "/employees/show/{companyId}/{id}")
    public String show(@PathVariable int companyId, int id, Model model) {
        Employee employee = EmployeeService.findById(id);
        model.addAttribute("employee", employee);

        model.addAttribute("PREFECTURES", PREFECTURES);

        return "employees/show";
    }

    /**
     * 社員追加画面
     */
    @GetMapping(value = "/employees/create/{companyId}")
    public String create(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/create";
    }

    /**
     * 社員追加
     */
    @PostMapping(value = "/employees/create/{companyId}")
    public String store(@ModelAttribute @Validated Employee Employee, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "employees/create";
        }
        EmployeeService.insert(Employee);

        redirectAttributes.addFlashAttribute("success", "社員を追加しました。");

        return "redirect:/employees/index";
    }

    /**
     * 社員編集画面
     */
    @GetMapping(value = "/employees/edit/{companyId}/{id}")
    public String edit(@PathVariable int id, Model model) {
        Employee employee = EmployeeService.findById(id);
        model.addAttribute("employee", employee);

        return "employees/edit";
    }

    /**
     * 社員編集
     */
    @PostMapping(value = "/employees/edit/{companyId}/{id}")
    public String update(@ModelAttribute @Validated Employee Employee, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "employees/edit";
        }
        EmployeeService.update(Employee);

        redirectAttributes.addFlashAttribute("success", "社員を編集しました。");

        return "redirect:/employees/index";
    }

    /**
     * 社員削除画面
     */
    @GetMapping(value = "/employees/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Employee employee = EmployeeService.findById(id);
        model.addAttribute("employee", employee);

        model.addAttribute("PREFECTURES", PREFECTURES);

        return "employees/delete";
    }

    /**
     * 社員削除
     */
    @PostMapping(value = "/employees/delete/{id}")
    public String destroy(@PathVariable int id, RedirectAttributes redirectAttributes) {
        EmployeeService.delete(id);

        redirectAttributes.addFlashAttribute("success", "社員を削除しました。");

        return "redirect:/employees/index";
    }
}
