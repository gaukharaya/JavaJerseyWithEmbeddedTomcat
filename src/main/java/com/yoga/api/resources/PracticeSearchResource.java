package com.yoga.api.resources;

import com.yoga.api.model.Practice;
import com.yoga.api.model.PracticeSearch;
import com.yoga.api.repository.PracticeRepository;
import com.yoga.api.repository.PracticeRepositoryStub;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;


@Path("search/practices")
@Api(value = "search/practices", description = "End-point to create, read, update and delete yoga practices")
public class PracticeSearchResource {

	private PracticeRepository practiceRepository = new PracticeRepositoryStub();
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@ApiOperation(value = "Updates yoga practice")
	public Response searchForPractices(PracticeSearch search) {
		System.out.println(search.getDescriptions() + ", " + search.getDurationFrom());
		
		List<Practice> practices = practiceRepository.findByConstraints(search);
		
		if(practices == null || practices.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Practice>> (practices) {}).build();
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response searchForPractices(@QueryParam(value = "description") List<String> descriptions,
			@QueryParam(value = "durationFrom") int durationFrom,
			@QueryParam(value = "durationTo") int durationTo) {
		
		System.out.println(descriptions + ", " + durationFrom + ", " + durationTo);
		
		List<Practice> practices = practiceRepository.findByDescription(descriptions, durationFrom, durationTo);
		
		if(practices == null || practices.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Practice>>(practices) {}).build();
	}
	
}
