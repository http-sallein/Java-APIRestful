package api.Service;

import api.DTO.ApiDTO;
import api.Model.ApiModel;
import api.Repository.ApiRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ApiServiceImpl implements ApiService{
    private final ApiRepository repository;

    @Override
    public String insertProduct(ApiDTO dto) {
        ApiModel model = new ApiModel();

        BeanUtils.copyProperties(dto, model);

        repository.save(model);

        return "Product insert success";
    }

    @Override
    public List<ApiModel> getAllProducts() {
        return repository.findAll();
    }

    @Override
    public ApiModel getOneProduct(UUID uuid) {
        return repository.getOneProductById(uuid);
    }

    @Override
    public String updateProduct(UUID uuid, ApiDTO dto) {
        ApiModel productFound = repository.findById(uuid).orElseThrow(() -> new RuntimeException("product not found"));

        BeanUtils.copyProperties(dto, productFound);

        repository.save(productFound);

        return "product updated!";
    }

    @Override
    public String deleteProduct(UUID uuid) {
        ApiModel productFound = repository.findById(uuid).orElseThrow(() -> new RuntimeException("product not found"));

        repository.delete(productFound);

        return "product deleted";
    }
}
