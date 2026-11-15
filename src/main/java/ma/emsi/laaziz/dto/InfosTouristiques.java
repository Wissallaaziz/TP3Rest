
package ma.emsi.laaziz.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.emsi.laaziz.llm.LlmClient;

@Path("/guide")
public class InfosTouristiques {

    @Inject
    private LlmClient llmClient;

    /**
     * Génère un guide touristique JSON pour une ville ou un pays.
     *
     * Exemple : /api/guide/lieu/Paris?nb=4
     *
     * @param villeOuPays 
     * @param nombre 
     * @return 
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays,
            @QueryParam("nb") @DefaultValue("2") int nombre) {

        if (nombre < 1 || nombre > 20) {
            throw new WebApplicationException(
                    "Le paramètre nb doit être compris entre 1 et 20.",
                    Response.Status.BAD_REQUEST);
        }

        try {
            String json = llmClient.endroitsDeVisite(
                    villeOuPays, nombre);

            return Response.ok(json, MediaType.APPLICATION_JSON)
                    .build();

        } catch (IllegalArgumentException e) {
            throw new WebApplicationException(
                    e.getMessage(),
                    Response.Status.BAD_REQUEST);

        } catch (RuntimeException e) {
            throw new WebApplicationException(
                    "Il est Impossible de générer les infos touristiques.",
                    Response.Status.BAD_GATEWAY);
        }
    }
}
