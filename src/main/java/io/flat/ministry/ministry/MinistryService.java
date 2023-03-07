package io.flat.ministry.ministry;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MinistryService {
    private MinistryRepository ministryRepository;

    public MinistryService(MinistryRepository ministryRepository) {
        this.ministryRepository = ministryRepository;
    }

    public boolean createMinistry(MinistryDto ministryDto){
        Ministry ministry = new Ministry();
        ministry.setName(ministryDto.name);
        ministry.setUuid(UUID.randomUUID().toString());
        ministryRepository.save(ministry);
        return ministry.getId() != null;
    }

    public List<Ministry> getAll(){
        return ministryRepository.findAll();
    }

    public Ministry getByUUID(String uuid){
        return ministryRepository.findAllByUuid(uuid)
                .orElseGet(null);
    }

    //    public Ministry getByUUID(String uuid){
    //        return ministryRepository.findAllByUuid(uuid)
    //                .orElseThrow(()->new RuntimeException("No ministry found with the uuid: "+uuid));
    //    }
}
