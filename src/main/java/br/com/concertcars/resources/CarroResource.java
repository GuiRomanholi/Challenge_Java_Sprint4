package br.com.concertcars.resources;

import br.com.concertcars.dto.CarroRequestDto;
import br.com.concertcars.service.CarroService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/carros")
public class CarroResource {

    private CarroService service = new CarroService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(CarroRequestDto carro, @Context UriInfo uriInfo){
        service.cadastrar(carro);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path((carro.getPlaca()));
        return Response.created(builder.build()).build();
    }
     @GET
     @Produces(MediaType.APPLICATION_JSON)
     public List<CarroRequestDto> listar(){
         return service.listar();
     }

    @GET
    @Path("/{placa}")
    @Produces(MediaType.APPLICATION_JSON)
    public CarroRequestDto buscar(@PathParam("placa") String codigo){
        return service.buscarPorId(codigo);
    }

    @DELETE
    @Path("/{placa}")
    public Response excluir(@PathParam("placa") String placa) {
        CarroRequestDto carro = service.buscarPorId(placa);
        if (carro == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Carro não encontrado").build();
        }
        service.deletar(placa);
        return Response.ok("Carro excluído com sucesso").build();
    }

    @PUT
    @Path("/{placa}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response alterar(CarroRequestDto novoProduto, @PathParam("placa") String placa) {

        if (novoProduto.getPlaca() != null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("O CPF não deve ser incluído no corpo da requisição").build();
        }

        novoProduto.setPlaca(placa);
        service.atualizar(novoProduto);

        return Response.ok("Carro atualizado com sucesso").build();

    }

}
