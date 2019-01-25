package com.redhat.coolstore.rest;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.redhat.coolstore.model.Product;
import com.redhat.coolstore.service.CatalogService;


@RestController
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION)
@Path("/products")
public class CatalogEndpoint implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7227732980791688773L;

    @Autowired
    private CatalogService catalogService;

    //@RequestMapping(path = "/", method = RequestMethod.GET)
    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> listAll() {
        return catalogService.getProducts();
    }

    //@RequestMapping(path = "/", method = RequestMethod.POST)
    @Path("/")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Product product) {
        catalogService.add(product);
        return Response.ok().type(MediaType.APPLICATION_JSON).build();
    }

}
