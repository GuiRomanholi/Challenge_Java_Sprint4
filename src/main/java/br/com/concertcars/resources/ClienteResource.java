package br.com.concertcars.resources;

import br.com.concertcars.dto.ClienteRequestDto;
import br.com.concertcars.service.ClienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/clientes")
public class ClienteResource {

    private ClienteService service = new ClienteService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(ClienteRequestDto cliente, @Context UriInfo uriInfo) {
        service.cadastrar(cliente);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(cliente.getCpf());

        // Retorna um JSON com mensagem de sucesso
        return Response.created(builder.build())
                .entity("{\"message\": \"Cliente cadastrado com sucesso\"}")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ClienteRequestDto> listar() {
        return service.listar();
    }

    @GET
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(@PathParam("cpf") String cpf) {
        ClienteRequestDto cliente = service.buscarPorId(cpf);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Cliente não encontrado\"}")
                    .build();
        }
        return Response.ok(cliente).build();
    }

    @DELETE
    @Path("/{cpf}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response excluir(@PathParam("cpf") String cpf) {
        ClienteRequestDto cliente = service.buscarPorId(cpf);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"error\": \"Cliente não encontrado\"}")
                    .build();
        }
        service.deletar(cpf);
        return Response.ok("{\"message\": \"Cliente excluído com sucesso\"}").build();
    }

    @PUT
    @Path("/{cpf}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response alterar(ClienteRequestDto produto, @PathParam("cpf") String cpf) {
        if (produto.getCpf() != null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\": \"O CPF não deve ser incluído no corpo da requisição\"}")
                    .build();
        }

        produto.setCpf(cpf);
        service.atualizar(produto);

        return Response.ok("{\"message\": \"Cliente atualizado com sucesso\"}").build();
    }
}
