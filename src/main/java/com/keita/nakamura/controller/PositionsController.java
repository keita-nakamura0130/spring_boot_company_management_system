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

import com.keita.nakamura.entity.Position;
import com.keita.nakamura.service.PositionService;

/**
 * Positionsコントローラー
 */
@Controller
public class PositionsController {

    @Autowired
    PositionService positionService;

    /**
     * 役職一覧
     */
    @GetMapping(value = "/positions/index")
    public String index(Model model) {
        List<Position> positions = positionService.findAll();
        model.addAttribute("positions", positions);

        return "positions/index";
    }

    /**
     * 役職追加画面
     */
    @GetMapping(value = "/positions/create")
    public String create(Model model) {
        Position position = new Position();
        model.addAttribute("position", position);

        return "positions/create";
    }

    /**
     * 役職追加
     */
    @PostMapping(value = "/positions/create")
    public String store(@ModelAttribute @Validated Position position, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "positions/create";
        }
        positionService.insert(position);

        redirectAttributes.addFlashAttribute("success", "役職を追加しました。");

        return "redirect:/positions/index";
    }

    /**
     * 役職編集画面
     */
    @GetMapping(value = "/positions/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Position position = positionService.findById(id);
        model.addAttribute("position", position);

        return "positions/edit";
    }

    /**
     * 役職編集
     */
    @PostMapping(value = "/positions/edit/{id}")
    public String update(@ModelAttribute @Validated Position position, BindingResult bidingResult, RedirectAttributes redirectAttributes) {
        if (bidingResult.hasErrors()) {
            return "positions/edit";
        }
        positionService.update(position);

        redirectAttributes.addFlashAttribute("success", "役職を編集しました。");

        return "redirect:/positions/index";
    }

    /**
     * 役職削除画面
     */
    @GetMapping(value = "/positions/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        Position position = positionService.findById(id);
        model.addAttribute("position", position);

        return "positions/delete";
    }

    /**
     * 役職削除
     */
    @PostMapping(value = "/positions/delete/{id}")
    public String destroy(@PathVariable int id, RedirectAttributes redirectAttributes) {
        positionService.delete(id);

        redirectAttributes.addFlashAttribute("success", "役職を削除しました。");

        return "redirect:/positions/index";
    }
}
