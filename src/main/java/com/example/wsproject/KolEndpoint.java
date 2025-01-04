package com.example.wsproject;

import java.util.List;
import java.util.Optional;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.wsproject.Entity.Kol;
import com.example.wsproject.Repo.KolRepo;

import io.spring.guides.gs_producing_web_service.AddKolRequest;
import io.spring.guides.gs_producing_web_service.AddKolResponse;
import io.spring.guides.gs_producing_web_service.DeleteKolRequest;
import io.spring.guides.gs_producing_web_service.DeleteKolResponse;
import io.spring.guides.gs_producing_web_service.GetAllKolResponse;
import io.spring.guides.gs_producing_web_service.UpdateKolRequest;
import io.spring.guides.gs_producing_web_service.UpdateKolResponse;


@Endpoint
public class KolEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final KolRepo kolRepo;

    public KolEndpoint(KolRepo kolRepo) {
        this.kolRepo = kolRepo;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllKolRequest")
    @ResponsePayload
    public GetAllKolResponse getAllKols() {
        GetAllKolResponse response = new GetAllKolResponse();
        List<Kol> kols = kolRepo.findAll();
        kols.forEach(kol -> response.getKol().add(mapEntityToSoapKol(kol)));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addKolRequest")
    @ResponsePayload
    public AddKolResponse addKol(@RequestPayload AddKolRequest request) {
        AddKolResponse response = new AddKolResponse();
        Kol kol = new Kol();
        kol.setSem(request.getKol().getSem());
        kol.setRed(request.getKol().getRed());
        kol.setStudiska(request.getKol().getStudiska());
        kolRepo.save(kol);
        return response;
    }
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateKolRequest")
    @ResponsePayload
    public UpdateKolResponse updateKol(@RequestPayload UpdateKolRequest request) {
        UpdateKolResponse response = new UpdateKolResponse();
        int id = request.getId();
        Optional<Kol> kol1 = kolRepo.findById(id);
        if (kol1.isPresent()) {
            Kol kol2 = kol1.get();
            kol2.setRed(request.getRed());
            kol2.setSem(request.getSem());
            kol2.setStudiska(request.getStudiska());
            kolRepo.save(kol2);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteKolRequest")
    @ResponsePayload
    public DeleteKolResponse deleteKol(@RequestPayload DeleteKolRequest request) {
        DeleteKolResponse response = new DeleteKolResponse();
        Optional<Kol> kol = kolRepo.findById(request.getId());
        if (kol.isPresent()) {
            kolRepo.delete(kol.get());
        }
        return response;
    }

    private io.spring.guides.gs_producing_web_service.Kol mapEntityToSoapKol(Kol kol) {
        io.spring.guides.gs_producing_web_service.Kol soapKol = new io.spring.guides.gs_producing_web_service.Kol();
        soapKol.setId(kol.getId());
        soapKol.setRed(kol.getRed());
        soapKol.setSem(kol.getSem());
        soapKol.setStudiska(kol.getStudiska());
        return soapKol;
    }
}

