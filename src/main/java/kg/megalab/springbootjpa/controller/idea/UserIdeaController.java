package kg.megalab.springbootjpa.controller.idea;

import jakarta.validation.Valid;
import kg.megalab.springbootjpa.model.ideadto.UserIdeaDto;
import kg.megalab.springbootjpa.service.serv.UserIdeaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usersId")
public class UserIdeaController {

    private final UserIdeaService service;

    @PostMapping
    public ResponseEntity<?>saveUserIdea( @Valid @RequestBody UserIdeaDto dto){
        service.saveUserIdea(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?>getUserIdea(@RequestParam(name = "id")Long id){
        return new ResponseEntity<>(service.getUsers(id),HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?>getAllUsers(){return new ResponseEntity<>(service.getAllUsers(),HttpStatus.OK);}

    @DeleteMapping
    public boolean deleteUser(@RequestParam(name = "id") Long id){
        return service.deleteUser(id);

    }

    @PutMapping("/put")
    public ResponseEntity<?>putUser(@Valid @RequestBody UserIdeaDto dto){
        service.putUser(dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
