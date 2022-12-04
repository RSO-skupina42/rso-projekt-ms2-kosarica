package si.fri.rso.samples.firstmicroservice.services.beans;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.fri.rso.samples.firstmicroservice.lib.KosaricaMetadata;
import si.fri.rso.samples.firstmicroservice.models.converters.KosaricaMetadataConverter;
import si.fri.rso.samples.firstmicroservice.models.entities.KosaricaMetadataEntity;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequestScoped
public class KosaricaMetadataBean {

    private Logger log = Logger.getLogger(KosaricaMetadataBean.class.getName());

    @Inject
    private EntityManager em;

    public List<KosaricaMetadata> getKosaricaMetadata() {

        TypedQuery<KosaricaMetadataEntity> query = em.createNamedQuery(
                "KosaricaMetadataEntity.getAll", KosaricaMetadataEntity.class);

        List<KosaricaMetadataEntity> resultList = query.getResultList();

        return resultList.stream().map(KosaricaMetadataConverter::toDto).collect(Collectors.toList());
    }

    public List<KosaricaMetadata> getKosaricaMetadataFilter(UriInfo uriInfo) {
        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();
        List<KosaricaMetadata> something = JPAUtils.queryEntities(em, KosaricaMetadataEntity.class, queryParameters).stream()
                .map(KosaricaMetadataConverter::toDto).collect(Collectors.toList());
        return something;
    }

    public KosaricaMetadata getKosaricaMetadata(Integer id) {

        KosaricaMetadataEntity kosaricaMetadataEntity = em.find(KosaricaMetadataEntity.class, id);

        if (kosaricaMetadataEntity == null) {
            throw new NotFoundException();
        }

        KosaricaMetadata kosaricaMetadata = KosaricaMetadataConverter.toDto(kosaricaMetadataEntity);

        return kosaricaMetadata;
    }
}
