package ru.anikey.crudtest2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.anikey.crudtest2.entity.Game;
import ru.anikey.crudtest2.repository.GameRepository;

import java.util.ArrayList;
import java.util.List;


@Controller
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public String getAll(Model model, @Param("keyword") String keyword) {
        try {
            List<Game> games = new ArrayList<Game>();

            if (keyword == null) {
                gameRepository.findAll().forEach(games::add);
            } else {
                gameRepository.findByTitleContainingIgnoreCase(keyword).forEach(games::add);
                model.addAttribute("keyword", keyword);
            }

            model.addAttribute("games", games);
        } catch (Exception e) {

            model.addAttribute("message", e.getMessage());
        }


        return "games";
    }

    @GetMapping("/games/new")
    public String addGame(Model model) {
            Game game = new Game();

            model.addAttribute("game", game);
            model.addAttribute("pageTitle", "Add new Game");


        return "game_form";
    }

    @PostMapping("/games/save")
    public String saveGame(Game game, RedirectAttributes redirectAttributes) {
            try {
                gameRepository.save(game);

                redirectAttributes.addFlashAttribute("message", "The Game has been added successfully!");
            } catch (Exception e) {
                redirectAttributes.addAttribute("message", e.getMessage());
            }

        return "redirect:/games";
    }

    @GetMapping("/games/{id}")
    public String editGame(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Game game = gameRepository.findById(id).get();

            model.addAttribute("game", game);
            model.addAttribute("pageTitle", "Edit game (ID: " + id + ")");

            return "game_form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());

            return "redirect:/games";
        }
    }

    @GetMapping("/games/delete/{id}")
    public String deleteGame(@PathVariable("id") Integer id, Model model, RedirectAttributes redirectAttributes) {
        try {
            gameRepository.deleteById(id);

            redirectAttributes.addFlashAttribute("message", "The Game with id=" + id + " has been deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", e.getMessage());
        }

        return "redirect:/games";
    }



}
