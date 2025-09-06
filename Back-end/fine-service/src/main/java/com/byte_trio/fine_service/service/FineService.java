package com.byte_trio.fine_service.service;

import com.byte_trio.fine_service.model.Fine;
import com.byte_trio.fine_service.repo.FineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class FineService {

    @Autowired
    FineRepo fineRepo;

    public String save(Fine fine) {
        fineRepo.save(fine);
        return "New Fine Saved.";
    }

    public Boolean checkFine(String fineId) {
        if (!fineRepo.existsById(fineId)) {
            return null;
        } else {
            return fineRepo.findById(fineId).get().isPaidStatus();
        }
    }


    public String deletefine(String id) {
        fineRepo.updatestatus(new String(Base64.getDecoder().decode(id)));
        fineRepo.deletefine();
        return "Fine statement deleted.";
    }
}
