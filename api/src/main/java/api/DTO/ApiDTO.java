package api.DTO;

import jakarta.validation.constraints.NotNull;

public record ApiDTO(
        @NotNull String name,
        @NotNull float price,
        @NotNull String description
) {
}
