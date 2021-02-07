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

import com.keita.nakamura.entity.Department;
import com.keita.nakamura.service.DepartmentService;

/**
 * Departmentsコントローラー
 */
@Controller
public class DepartmentsController {

    @Autowired
    DepartmentService departmentService;

    /**
     * 部署一覧
     */
    @GetMapping(value = "/departments/index")
    public String index(Model model) {
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);

        return "departments/index";
    }

    /**
     * 部署追加画面
     */
    @GetMapping(value = "/departments/create")
    public String create(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);

        return "departments/create";
    }

    /**
     * 部署追加
     */
    @PostMapping(value = "/departments/create")
    public String store(@ModelAttribute @Validated Department department, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "departments/create";
        }
        departmentService.insert(department);

        redirectAttributes.addFlashAttribute("success", "部署を追加しました。");

        return "redirect:/departments/index";
    }

    /**
     * 部署編集画面
     */
    @GetMapping(value = "/departments/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);

        return "departments/edit";
    }

    /**
     * 部署編集
     */
    @PostMapping(value = "/departments/edit/{id}")
    public String update(@ModelAttribute @Validated Department department, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "departments/edit";
        }
        departmentService.update(department);

        redirectAttributes.addFlashAttribute("success", "部署を編集しました。");

        return "redirect:/departments/index";
    }

    /**
     * 部署削除画面
     */
    @GetMapping(value = "/departments/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Department department = departmentService.findById(id);
        model.addAttribute("department", department);

        return "departments/delete";
    }

    /**
     * 部署削除
     */
    @PostMapping(value = "/departments/delete/{id}")
    public String destroy(@PathVariable int id, RedirectAttributes redirectAttributes) {
        departmentService.delete(id);

        redirectAttributes.addFlashAttribute("success", "部署を削除しました。");

        return "redirect:/departments/index";
    }
}
