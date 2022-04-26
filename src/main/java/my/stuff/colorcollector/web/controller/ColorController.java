package my.stuff.colorcollector.web.controller;

import my.stuff.colorcollector.model.ColorInfo;
import my.stuff.colorcollector.service.ColorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = {"/", "/index"})
public class ColorController {
    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public String getColorPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<ColorInfo> colorInfos = colorService.getAllColors();

        model.addAttribute("colors", colorInfos);
        model.addAttribute("selectedColorValues", null);

        return "index";
    }

    @PostMapping("/addColor")
    public String addColor(@RequestParam String colorName, @RequestParam String colorValue){

        String[] colors = colorValue.split(" ");



        colorService.addColor(colorName, colors[0], colors[1]);

        return "redirect:index";
    }

}
