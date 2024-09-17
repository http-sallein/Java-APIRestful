package api.Controller;

import api.DTO.ApiDTO;
import api.Model.ApiModel;
import api.Service.ApiServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class ApiController {

    private final ApiServiceImpl service;

    @PostMapping
    public String insertProduct(@RequestBody ApiDTO dto) {
        return service.insertProduct(dto);
    }

    @GetMapping
    public List<ApiModel> getAllProducts() {
        return service.getAllProducts();
    }

    @GetMapping("/{uuid}")
    public ApiModel getOneProduct(@PathVariable("uuid") UUID uuid) {
        return service.getOneProduct(uuid);
    }

    @PutMapping("/{uuid}")
    public String updateProduct(
            @PathVariable("uuid") UUID uuid,
            @Valid  @RequestBody ApiDTO dto
    ) {
        return service.updateProduct(uuid, dto);
    }

    @DeleteMapping("/{uuid}")
    public String deleteProduct(@PathVariable("uuid") UUID uuid) {
        return service.deleteProduct(uuid);
    }
}
