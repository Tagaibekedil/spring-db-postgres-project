package kg.megalab.springbootjpa.controller.idea;

import kg.megalab.springbootjpa.model.ideadto.CommentDto;
import kg.megalab.springbootjpa.service.serv.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService service;
    @PostMapping
    public ResponseEntity<?>saveComment(@RequestBody CommentDto dto){
        service.saveComments(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
