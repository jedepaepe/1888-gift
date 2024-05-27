package eu.epfc.j1888.gift;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GiftController {
    private final GiftRepository repository;

    public GiftController(GiftRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/gifts")
    public String showGifts(Model model) {
        List<Gift> gifts = repository.findAll();
        model.addAttribute("list", gifts);
        return "gifts-view";
    }
}
