package my.stuff.colorcollector.repository.jpa;

import my.stuff.colorcollector.model.ColorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<ColorInfo, Long> {

    @Override
    Optional<ColorInfo> findById(Long aLong);
//    Optional<ColorInfo> findColorInfoById(Long aLong);


}
