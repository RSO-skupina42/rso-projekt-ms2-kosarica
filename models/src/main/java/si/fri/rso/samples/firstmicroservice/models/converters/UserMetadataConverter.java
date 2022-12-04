package si.fri.rso.samples.firstmicroservice.models.converters;

import si.fri.rso.samples.firstmicroservice.lib.UserMetadata;
import si.fri.rso.samples.firstmicroservice.models.entities.UserMetadataEntity;

public class UserMetadataConverter {

    public static UserMetadata toDto(UserMetadataEntity entity) {

        UserMetadata dto = new UserMetadata();
        dto.setPersonId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());

        return dto;
    }

    public static UserMetadataEntity toEntity(UserMetadata dto) {

        UserMetadataEntity entity = new UserMetadataEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());

        return entity;
    }
}
