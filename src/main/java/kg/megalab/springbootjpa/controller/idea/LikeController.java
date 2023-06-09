package kg.megalab.springbootjpa.controller.idea;

import kg.megalab.springbootjpa.model.ideadto.LikeDto;
import kg.megalab.springbootjpa.service.serv.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/likes")
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<?>saveLike(@RequestBody LikeDto dto){
        likeService.saveLikes(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
