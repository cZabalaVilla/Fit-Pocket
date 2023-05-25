package edu.fpdual.webservice.controller;

import edu.fpdual.webservice.model.persistence.dao.Profile;
import edu.fpdual.webservice.model.persistence.dao.User;
import edu.fpdual.webservice.model.persistence.manager.impl.ProfileManagerImpl;
import edu.fpdual.webservice.service.ProfileService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;

public class ProfileController {
    private final ProfileService profileService;

    //@TODO Añadir Javadoc
    public ProfileController() {
        this.profileService = new ProfileService(new ProfileManagerImpl());
    }

    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/all")
    public Response findAll() {
        try {
            return Response.ok().entity(profileService.findAllProfiles()).build();
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{userId}")
    public Response findByUserId(@PathParam("userId") int userId) {
        try {
            if (profileService.findByUserId(userId).getUserId() <= 0) {
                return Response.status(400).entity("Profile Not Found").build();
            } else {
                return Response.ok().entity(profileService.findByUserId(userId)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get/{email}")
    public Response findByEmail(@PathParam("email") String email) {
        try {
            if (profileService.findByEmail(email).getUserId() <= 0) {
                return Response.status(400).entity("Profile Not Found").build();
            } else {
                return Response.ok().entity(profileService.findByEmail(email)).build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }
    @PUT
    @Path("/put")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateProfile(Profile profile) {
        try {
            Profile profileToUpdate = profileService.findByUserId(profile.getUserId());
            if (profileToUpdate != null) {
                return Response.status(200).entity(profileService.updateProfile(profile)).build();
            } else {
                return Response.status(400).entity("Profile Not Found").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }

    @POST
    @Path("/post")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProfile(Profile profile) {
        try {
            if (findByUserId(profile.getUserId()) != null) {
                if (profileService.createProfile()) {
                    return Response.status(200).entity("Profile created.").build();
                } else {
                    return Response.status(400).entity("Profile not created.").build();
                }
            } else {
                return Response.status(400).entity("Profile already exists.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction.").build();
        }
    }

    @DELETE
    @Path("/delete")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteProfile(Profile profile) {
        try {
            if (findByUserId(profile.getUserId()) != null) {
                if (profileService.deleteProfile(profile)) {
                    return Response.status(200).entity(profile).build();
                } else {
                    return Response.status(400).entity("Profile Was Not Deleted.").build();
                }
            } else {
                return Response.status(404).entity("Profile Not Found.").build();
            }
        } catch (SQLException | ClassNotFoundException e) {
            return Response.status(500).entity("Internal Error During DB Interaction").build();
        }
    }
}
