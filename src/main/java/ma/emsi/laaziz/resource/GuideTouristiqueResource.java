package ma.emsi.laaziz.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Ressource REST pour obtenir des informations touristiques.
 */
@Path("/guide")
public class GuideTouristiqueResource {

    /**
     * Retourne le nom de la ville ou du pays demandé.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @return nom du lieu demandé
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.TEXT_PLAIN)
    public String endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays) {

        return villeOuPays;
    }
}
