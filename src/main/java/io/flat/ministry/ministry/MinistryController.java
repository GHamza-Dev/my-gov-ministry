package io.flat.ministry.ministry;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ministries")
public class MinistryController {

    private MinistryService ministryService;

    public MinistryController(MinistryService ministryService) {
        this.ministryService = ministryService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MinistryDto ministryDto){
        if(ministryService.createMinistry(ministryDto)){
            return ResponseEntity.ok("Ministry created successfully");
        }

        return ResponseEntity.status(500).body("Ops something went wrong while creating the ministry");
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(
                ministryService.getAll()
        );
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<?> getByUUID(@PathVariable("uuid") String uuid){
        return ResponseEntity.ok(
                ministryService.getByUUID(uuid)
        );
    }
}
