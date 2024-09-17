package api.Repository;

import api.Model.ApiModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApiRepository extends JpaRepository<ApiModel, UUID> {
    ApiModel getOneProductById(UUID uuid);
}
