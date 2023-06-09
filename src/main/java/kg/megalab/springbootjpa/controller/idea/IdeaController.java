package kg.megalab.springbootjpa.controller.idea;

import jakarta.validation.Valid;
import kg.megalab.springbootjpa.model.ideadto.IdeaDto;
import kg.megalab.springbootjpa.service.serv.IdeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/idea")
public class IdeaController {

    private final IdeaService service;

    @PostMapping
    public ResponseEntity<?>saveIdea(@Valid @RequestBody IdeaDto dto){
        service.saveIdea(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?>getIdea(){
        return new ResponseEntity<>(service.getAllIdea(),HttpStatus.OK);
    }


    @DeleteMapping
    public boolean deleteIdea(@RequestParam(name = "id")Long id){
        return service.deleteIdea(id);
    }
}
