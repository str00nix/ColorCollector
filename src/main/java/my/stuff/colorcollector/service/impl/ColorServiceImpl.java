package my.stuff.colorcollector.service.impl;

import my.stuff.colorcollector.model.ColorInfo;
import my.stuff.colorcollector.repository.jpa.ColorRepository;
import my.stuff.colorcollector.service.ColorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ColorServiceImpl implements ColorService {

    private final ColorRepository colorRepository;

    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public List<ColorInfo> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public ColorInfo getColorById(Long id) {
        return colorRepository.getById(id);
    }

    @Override
    public ColorInfo addColor(String name, String value1, String value2) {

        List<ColorInfo> colors = colorRepository.findAll();

        boolean colorAlreadyExists = false;
        for(int i = 0; i < colors.size(); i++){
            if(Objects.equals(value1, colors.get(i).getValue1()) && Objects.equals(value2, colors.get(i).getValue2())){
                colorAlreadyExists = true;
                System.out.printf("Color gradient already exists. (%s - %s)\n", value1, value2);
                break;
            }
        }


        ColorInfo tempColor = new ColorInfo(name, value1, value2);

        if(!colorAlreadyExists){
            return colorRepository.save(tempColor);
        }else{
            return tempColor;
        }
    }

    @Override
    public void deleteColorById(Long id) {
        colorRepository.deleteById(id);
    }
}
