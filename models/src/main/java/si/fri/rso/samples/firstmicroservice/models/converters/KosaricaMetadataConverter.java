package si.fri.rso.samples.firstmicroservice.models.converters;

import si.fri.rso.samples.firstmicroservice.lib.KosaricaMetadata;
import si.fri.rso.samples.firstmicroservice.models.entities.KosaricaMetadataEntity;

public class KosaricaMetadataConverter {

    public static KosaricaMetadata toDto(KosaricaMetadataEntity entity) {

        KosaricaMetadata dto = new KosaricaMetadata();
        dto.setKosaricaId(entity.getId());
        dto.setimeTrgovine(entity.getImeTrgovine());
        dto.setImeKosarice(entity.getImeKosarice());
        dto.setIzdelek1(entity.getIzdelek1(), entity.getCena_izdelek1());
        dto.setIzdelek2(entity.getIzdelek2(), entity.getCena_izdelek2());
        dto.setIzdelek3(entity.getIzdelek3(), entity.getCena_izdelek3());

        //TODO do it better
        return dto;
    }

    public static KosaricaMetadataEntity toEntity(KosaricaMetadata dto) {

        KosaricaMetadataEntity entity = new KosaricaMetadataEntity();
        entity.setimeTrgovine(dto.getImeTrgovine());
        entity.setImeKosarice(dto.getImeKosarice());
        entity.setIzdelek1(dto.getIzdelek1(), dto.getCena_izdelek1());
        entity.setIzdelek2(dto.getIzdelek2(), dto.getCena_izdelek2());
        entity.setIzdelek3(dto.getIzdelek3(), dto.getCena_izdelek3());

        //TODO do it better

        return entity;
    }
}
