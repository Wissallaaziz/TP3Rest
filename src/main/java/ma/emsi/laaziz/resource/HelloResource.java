package ma.emsi.laaziz.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class HelloResource {

    /**
     * Retourne un tableau JSON contenant le nom de la ville ou du pays.
     *
     * @param villeOuPays nom de la ville ou du pays
     * @return tableau contenant le nom du lieu demandé
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] endroitsDeVisite(
            @PathParam("ville_ou_pays") String villeOuPays) {

        return new String[]{villeOuPays};
    }
}