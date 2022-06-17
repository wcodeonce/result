package cn.codeonce.controller;

import cn.codeonce.pojo.Book;
import cn.codeonce.result.NotControllerResponseAdvice;
import cn.codeonce.result.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/book")
public class Controller {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping
    public ResultVo insert(@Validated @RequestBody Book book) {
        log.info(book.toString());
        mongoTemplate.save(book);
        return new ResultVo(book);
    }

    @GetMapping("/health")
    @NotControllerResponseAdvice
    public String health() {
        return "success";
    }


    @GetMapping
    public ResultVo list() {
        List<Book> bookList = mongoTemplate.findAll(Book.class);
        return new ResultVo(bookList);
    }

    @GetMapping("/list")
    public List<Book> getList() {
        return mongoTemplate.findAll(Book.class);
    }


}
