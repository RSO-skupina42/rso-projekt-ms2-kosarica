package si.fri.rso.samples.firstmicroservice.api.v1.resources;


import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.rso.samples.firstmicroservice.services.beans.UserMetadataBean;
import si.fri.rso.samples.firstmicroservice.lib.UserMetadata;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserMetadataResource {

    private Logger log = Logger.getLogger(UserMetadataResource.class.getName());

    @Inject
    private UserMetadataBean userMetadataBean;

    @Context
    protected UriInfo uriInfo;

    @Operation(description = "Get all users metadata", summary = "Get all users")
    @APIResponses({
            @APIResponse(responseCode = "200",
                description = "List of user metadata",
                content = @Content(schema = @Schema(implementation = UserMetadata.class, type = SchemaType.ARRAY)),
                headers = {@Header(name = "X-Total-Count", description = "Number of objects in list")}
            )})
    @GET
    public Response getUserMetadata() {

        List<UserMetadata> userMetadata = userMetadataBean.getUserMetadataFilter(uriInfo);

        return Response.status(Response.Status.OK).entity(userMetadata).build();
    }
}
