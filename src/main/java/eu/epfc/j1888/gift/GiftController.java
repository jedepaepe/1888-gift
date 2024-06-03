package eu.epfc.j1888.gift;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/gift-create")
    public String showGiftForm(Model model) {
        Gift gift = new Gift(null, "tv", 400, "joie");
        model.addAttribute("gift", gift);
        return "gift-create-view";
    }

    @PostMapping("/gifts")
    public String createGiftProcessor(@ModelAttribute("gift") Gift gift) {
        repository.save(gift);
        return "gift-create-succes-view";
    }
}
