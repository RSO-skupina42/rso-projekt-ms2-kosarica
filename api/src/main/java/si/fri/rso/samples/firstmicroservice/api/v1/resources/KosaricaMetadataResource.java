package si.fri.rso.samples.firstmicroservice.api.v1.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.rso.samples.firstmicroservice.lib.KosaricaMetadata;
import si.fri.rso.samples.firstmicroservice.services.beans.KosaricaMetadataBean;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/kosarica")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class KosaricaMetadataResource {

    private Logger log = Logger.getLogger(KosaricaMetadataResource.class.getName());

    @Inject
    private KosaricaMetadataBean kosaricaMetadataBean;

    @Context
    protected UriInfo uriInfo;

    @Operation(description = "Pridobi vse shranjene kosarice", summary = "Get all kosaricas")
    @APIResponses({
            @APIResponse(responseCode = "200",
                description = "Seznam vseh kosaric",
                content = @Content(schema = @Schema(implementation = KosaricaMetadata.class, type = SchemaType.ARRAY)),
                headers = {@Header(name = "X-Total-Count", description = "Number of objects in list")}
            )})
    @GET
    public Response getKosaricaMetadata() {

        List<KosaricaMetadata> kosaricaMetadata = kosaricaMetadataBean.getKosaricaMetadataFilter(uriInfo);

        return Response.status(Response.Status.OK).entity(kosaricaMetadata).build();
    }
}
