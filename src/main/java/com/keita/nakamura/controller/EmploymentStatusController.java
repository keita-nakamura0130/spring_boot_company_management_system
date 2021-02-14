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

import com.keita.nakamura.entity.EmploymentStatus;
import com.keita.nakamura.service.EmploymentStatusService;

/**
 * EmploymentStatusコントローラー
 */
@Controller
public class EmploymentStatusController {

    @Autowired
    EmploymentStatusService employmentStatusService;

    /**
     * 雇用形態一覧
     */
    @GetMapping(value = "/employment-status/index")
    public String index(Model model) {
        List<EmploymentStatus> employmentStatus = employmentStatusService.findAll();
        model.addAttribute("employmentStatus", employmentStatus);

        return "employment-status/index";
    }

    /**
     * 雇用形態追加画面
     */
    @GetMapping(value = "/employment-status/create")
    public String create(Model model) {
        EmploymentStatus employmentStatus = new EmploymentStatus();
        model.addAttribute("employmentStatus", employmentStatus);

        return "employment-status/create";
    }

    /**
     * 雇用形態追加
     */
    @PostMapping(value = "/employment-status/create")
    public String store(@ModelAttribute @Validated EmploymentStatus employmentStatus, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "employment-status/create";
        }
        employmentStatusService.insert(employmentStatus);

        redirectAttributes.addFlashAttribute("success", "雇用形態を追加しました。");

        return "redirect:/employment-status/index";
    }

    /**
     * 雇用形態編集画面
     */
    @GetMapping(value = "/employment-status/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        EmploymentStatus employmentStatus = employmentStatusService.findById(id);
        model.addAttribute("employmentStatus", employmentStatus);

        return "employment-status/edit";
    }

    /**
     * 雇用形態編集
     */
    @PostMapping(value = "/employment-status/edit/{id}")
    public String update(@ModelAttribute @Validated EmploymentStatus employmentStatus, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "employment-status/edit";
        }
        employmentStatusService.update(employmentStatus);

        redirectAttributes.addFlashAttribute("success", "雇用形態を編集しました。");

        return "redirect:/employment-status/index";
    }

    /**
     * 雇用形態削除画面
     */
    @GetMapping(value = "/employment-status/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        EmploymentStatus employmentStatus = employmentStatusService.findById(id);
        model.addAttribute("employmentStatus", employmentStatus);

        return "employment-status/delete";
    }

    /**
     * 雇用形態削除
     */
    @PostMapping(value = "/employment-status/delete/{id}")
    public String destroy(@PathVariable int id, RedirectAttributes redirectAttributes) {
        employmentStatusService.delete(id);

        redirectAttributes.addFlashAttribute("success", "雇用形態を削除しました。");

        return "redirect:/employment-status/index";
    }
}
