package com.example.wsproject;

import java.util.List;
import java.util.Optional;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.wsproject.Entity.Ispit;
import com.example.wsproject.Repo.IspitRepo;

import io.spring.guides.gs_producing_web_service.AddIspitRequest;
import io.spring.guides.gs_producing_web_service.AddIspitResponse;
import io.spring.guides.gs_producing_web_service.DeleteIspitRequest;
import io.spring.guides.gs_producing_web_service.DeleteIspitResponse;
import io.spring.guides.gs_producing_web_service.GetIspitsByKolRequest;
import io.spring.guides.gs_producing_web_service.GetIspitsResponse;
import io.spring.guides.gs_producing_web_service.UpdateIspitRequest;
import io.spring.guides.gs_producing_web_service.UpdateIspitResponse;

@Endpoint
public class IspitEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final IspitRepo ispitRepo;

    public IspitEndpoint(IspitRepo ispitRepo) {
        this.ispitRepo = ispitRepo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIspitsByKolRequest")
    @ResponsePayload
    public GetIspitsResponse getIspits(@RequestPayload GetIspitsByKolRequest request) {
        GetIspitsResponse response = new GetIspitsResponse();
        List<Ispit> ispits = ispitRepo.findByKol(request.getKol());
        ispits.forEach(ispit -> response.getIspit().add(mapEntityToSoapIspit(ispit)));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addIspitRequest")
    @ResponsePayload
    public AddIspitResponse addKol(@RequestPayload AddIspitRequest request) {
        AddIspitResponse response = new AddIspitResponse();
        Ispit ispit = new Ispit();
        ispit.setDatum(request.getIspit().getDatum());
        ispit.setVreme(request.getIspit().getVreme());
        ispit.setPredmet(request.getIspit().getPredmet());
        ispit.setProstorija(request.getIspit().getProstorija());
        ispit.setStGod(request.getIspit().getStgod());
        ispit.setKol(request.getIspit().getKol());
        ispitRepo.save(ispit);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateIspitRequest")
    @ResponsePayload
    public UpdateIspitResponse updateKol(@RequestPayload UpdateIspitRequest request) {
        UpdateIspitResponse response = new UpdateIspitResponse();
        int id = request.getIspit().getId();
        Optional<Ispit> ispit1 = ispitRepo.findById(id);
        if (ispit1.isPresent()) {
            Ispit ispit2 = ispit1.get();
            ispit2.setDatum(request.getIspit().getDatum());
            ispit2.setVreme(request.getIspit().getVreme());
            ispit2.setPredmet(request.getIspit().getPredmet());
            ispit2.setProstorija(request.getIspit().getProstorija());
            ispit2.setStGod(request.getIspit().getStgod());
            ispit2.setKol(request.getIspit().getKol());
            ispitRepo.save(ispit2);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteIspitRequest")
    @ResponsePayload
    public DeleteIspitResponse deleteKol(@RequestPayload DeleteIspitRequest request) {
        DeleteIspitResponse response = new DeleteIspitResponse();
        Optional<Ispit> ispit = ispitRepo.findById(request.getId());
        if (ispit.isPresent()) {
            ispitRepo.delete(ispit.get());
        }
        return response;
    }

    private io.spring.guides.gs_producing_web_service.Ispit mapEntityToSoapIspit(com.example.wsproject.Entity.Ispit entityIspit) {
        io.spring.guides.gs_producing_web_service.Ispit soapIspit = new io.spring.guides.gs_producing_web_service.Ispit();
        soapIspit.setId(entityIspit.getId());
        soapIspit.setKol(entityIspit.getKol());
        soapIspit.setPredmet(entityIspit.getPredmet());
        soapIspit.setDatum(entityIspit.getDatum());
        soapIspit.setVreme(entityIspit.getVreme());
        soapIspit.setProstorija(entityIspit.getProstorija());
        soapIspit.setStgod(entityIspit.getStGod());
        soapIspit.setSem(entityIspit.getSem());
        return soapIspit;
    }


    

}
