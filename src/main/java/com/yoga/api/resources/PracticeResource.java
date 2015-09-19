package com.yoga.api.resources;

import com.yoga.api.model.Practice;
import com.yoga.api.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.yoga.api.repository.PracticeRepository;
import com.yoga.api.repository.PracticeRepositoryStub;
import io.swagger.annotations.ApiParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("practices")
@Api(value = "practices", description = "End-point to create, read, update and delete yoga practices")
public class PracticeResource {

	private PracticeRepository practiceRepository = new PracticeRepositoryStub();

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ApiOperation(value = "Finds all yoga practices")
	public List<Practice> getAllPractices() {
		return practiceRepository.findAllPractices();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{practiceId}")
	@ApiOperation(value = "Finds yoga practice by practice id")
	public Response getPractice(@ApiParam(value="practiceId",required=true)@PathParam("practiceId") String practiceId) {
		if(practiceId == null || practiceId.length() < 4) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Practice practice = practiceRepository.findPractice(practiceId);
		
		if(practice == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(practice).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{practiceId}/user")
	@ApiOperation(value = "Finds user of the yoga practice", notes = "Requires practice id")
	public User getPracticeUser(@ApiParam(value="practiceId",required=true)@PathParam("practiceId") String practiceId) {
		return practiceRepository.findPractice(practiceId).getUser();
	}

	@POST
	@Path("practice")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ApiOperation(value = "Creates new yoga practice using url encoded form")
	public Practice createPracticeParams(MultivaluedMap<String, String> formParams) {

		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));

		Practice practice = new Practice();
		practice.setDescription(formParams.getFirst("description"));
		practice.setDuration(Integer.parseInt(formParams.getFirst("duration")));

		practiceRepository.create(practice);

		return practice;
	}

	@POST
	@Path("practice")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ApiOperation(value = "Creates new yoga practice using object derived from json")
	public Response createPractice(Practice practice) {

		System.out.println(practice.getDescription());
		System.out.println(practice.getDuration());

		practiceRepository.create(practice);

		return Response.ok().entity(practice).build();
	}

	@PUT
	@Path("{practiceId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ApiOperation(value = "Updates yoga practice")
	public Response update(Practice practice) {

		System.out.println(practice.getId());

		practice = practiceRepository.update(practice);

		return Response.ok().entity(practice).build();

	}

	@DELETE
	@Path("{practiceId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.   APPLICATION_XML})
	@ApiOperation(value = "Deletes yoga practice")
	public Response delete (@ApiParam(value="practiceId",required=true)@PathParam("practiceId") String practiceId) {
		System.out.println(practiceId);

		practiceRepository.delete(practiceId);

		return Response.ok().build();
	}
}
