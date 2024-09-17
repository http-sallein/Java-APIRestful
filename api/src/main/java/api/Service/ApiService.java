package api.Service;

import api.DTO.ApiDTO;
import api.Model.ApiModel;

import java.util.List;
import java.util.UUID;

public interface ApiService {
    String insertProduct(ApiDTO dto);
    List<ApiModel> getAllProducts();
    ApiModel getOneProduct(UUID uuid);
    String updateProduct(UUID uuid, ApiDTO dto);
    String deleteProduct(UUID uuid);
}
