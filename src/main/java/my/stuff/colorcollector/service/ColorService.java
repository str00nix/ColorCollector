package my.stuff.colorcollector.service;

import my.stuff.colorcollector.model.ColorInfo;

import java.util.List;

public interface ColorService {
    List<ColorInfo> getAllColors();
    ColorInfo getColorById(Long id);
    ColorInfo addColor(String name, String value1, String value2);
    void deleteColorById(Long id);
}
