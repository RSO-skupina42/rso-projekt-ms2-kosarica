package si.fri.rso.samples.firstmicroservice.services.beans;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import javax.enterprise.context.RequestScoped;
import si.fri.rso.samples.firstmicroservice.lib.UserMetadata;
import si.fri.rso.samples.firstmicroservice.models.converters.UserMetadataConverter;
import si.fri.rso.samples.firstmicroservice.models.entities.UserMetadataEntity;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequestScoped
public class UserMetadataBean {

    private Logger log = Logger.getLogger(UserMetadataBean.class.getName());

    @Inject
    private EntityManager em;

    public List<UserMetadata> getUserMetadata() {

        TypedQuery<UserMetadataEntity> query = em.createNamedQuery(
                "UserMetadataEntity.getAll", UserMetadataEntity.class);

        List<UserMetadataEntity> resultList = query.getResultList();

        return resultList.stream().map(UserMetadataConverter::toDto).collect(Collectors.toList());
    }

    public List<UserMetadata> getUserMetadataFilter(UriInfo uriInfo) {
        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();
        List<UserMetadata> something = JPAUtils.queryEntities(em, UserMetadataEntity.class, queryParameters).stream()
                .map(UserMetadataConverter::toDto).collect(Collectors.toList());
        return something;
    }

    public UserMetadata getUserMetadata(Integer id) {

        UserMetadataEntity userMetadataEntity = em.find(UserMetadataEntity.class, id);

        if (userMetadataEntity == null) {
            throw new NotFoundException();
        }

        UserMetadata userMetadata = UserMetadataConverter.toDto(userMetadataEntity);

        return userMetadata;
    }
}
