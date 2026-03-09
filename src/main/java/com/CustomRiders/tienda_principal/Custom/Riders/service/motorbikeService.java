import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.CustomRiders.tienda_principal.Custom.Riders.dto.motorbikeRequest;
import com.CustomRiders.tienda_principal.Custom.Riders.dto.motorbikeResponse;
import com.CustomRiders.tienda_principal.Custom.Riders.entity.motorbikeEntity;
import com.CustomRiders.tienda_principal.Custom.Riders.repository.motorbikeRepository;

@Service
public class motorbikeService {

    private final motorbikeRepository motorbikeRepository;

    public motorbikeService(motorbikeRepository motorbikeRepository) {
        this.motorbikeRepository = motorbikeRepository;
    }

    public List<motorbikeResponse> getMotorbikeEntity() {
        List<motorbikeEntity> entities = motorbikeRepository.findAll();
        List<motorbikeResponse> responseList = new ArrayList<>();

        for (motorbikeEntity entity : entities) {
            motorbikeResponse dto = new motorbikeResponse();
            dto.setBrand(entity.getBrand());
            dto.setModel(entity.getModel());
            dto.setCc(entity.getCc());
            dto.setPrice(entity.getPrice());
            dto.setQuantity(entity.getQuantity());
            responseList.add(dto);
        }
        return responseList;
    }

    public motorbikeResponse createMoto(motorbikeRequest request) {
        motorbikeEntity entity = new motorbikeEntity();
        entity.setBrand(request.getBrand());
        entity.setModel(request.getModel());
        entity.setCc(request.getCc());
        entity.setPrice(request.getPrice());
        entity.setQuantity(request.getQuantity());

        motorbikeRepository.save(entity);

        motorbikeResponse dto = new motorbikeResponse();
        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setCc(entity.getCc());
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());

        return dto;
    }

    public void deleteMoto(Long id) {
        if (!motorbikeRepository.existsById(id)) {
            throw new RuntimeException("No existe moto con ese id");
        }
        motorbikeRepository.deleteById(id);
    }

    // esto es para agrupar las motos

    public List<String> getQuantityByBrand() {
        List<Object[]> results = motorbikeRepository.findQuantityByBrand();
        List<String> responseList = new ArrayList<>();

        for (Object[] row : results) {
            String brand = (String) row[0];
            Long quantity = (Long) row[1];
            responseList.add(brand + "(" + quantity + ")");
        }
        return responseList;
    }

    // GET /motorbikes/by-brand en postman

}