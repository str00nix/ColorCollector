package my.stuff.colorcollector.web.controller;

import my.stuff.colorcollector.model.ColorInfo;
import my.stuff.colorcollector.service.ColorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Pattern colorGradientHexPattern = Pattern.compile("^(#[a-f0-9]{6}\\s#[a-f0-9]{6}|#[a-f0-9]{3}\\s#[a-f0-9]{3})$");
        Matcher colorGradientHexMatcher = colorGradientHexPattern.matcher(colorValue);

        if(colorGradientHexMatcher.find()){
            String[] colors = colorValue.split(" ");

            colorService.addColor(colorName, colors[0], colors[1]);
        }else{
            System.out.printf("Invalid color value (%s)", colorValue);
        }

        return "redirect:index";
    }

}
