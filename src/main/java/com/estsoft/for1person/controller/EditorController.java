package com.estsoft.for1person.controller;


//import com.estsoft.for1person.domain.PhotoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EditorController {
    @PostMapping("/api/post/imageUpload")
    public String handleImageUpload(@RequestParam("title") String title, @RequestParam("content") String content) {
        // 여기서 content 변수에는 사용자가 입력한 내용이 들어있습니다.
        // 이 내용을 데이터베이스에 저장하거나 다른 작업을 수행할 수 있습니다.

        log.info(title);
        log.info(content);

        return "Data received and stored.";
    }
}
