package com.ethan.controller;

import com.ethan.repository.GirlRepository;
import com.ethan.domain.Girl;
import com.ethan.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by lingxingu on 2017/3/18.
 */
@RestController
public class GirlController {

    private final GirlRepository girlRepository;

    private final GirlService girlService;

    @Autowired
    public GirlController(final GirlRepository girlRepository, final GirlService girlService) {
        this.girlRepository = girlRepository;
        this.girlService = girlService;
    }

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlRepository.findAll();
    }

//    @PostMapping(value = "/girls")
//    public Girl girlAdd(@RequestParam("cupSize") final String cupSize,
//                          @RequestParam("age") final Integer age) {
//        final Girl girl = new Girl();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//        return girlRepository.save(girl);
//    }

    @PostMapping(value = "/girls")
    public Girl girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return girlRepository.save(girl);
    }


    @GetMapping(value = "girls/{id}")
    public Girl findGirl(@PathVariable("id") final Integer id) {
        return girlRepository.findOne(id);
    }

    @GetMapping(value = "girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") final Integer age) {
        return girlRepository.findByAge(age);
    }

    @PutMapping(value = "girls/{id}")
    public Girl updateGirl(@PathVariable("id") final Integer id,
                           @RequestParam("cupSize") final String cupSize,
                           @RequestParam("age") final Integer age) {
        Girl girl = girlRepository.findOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girl;
    }

    @DeleteMapping(value = "girls/{id}")
    public void deleteGirl(@PathVariable("id") final Integer id) {
        girlRepository.delete(id);
    }

    @PostMapping(value = "girls/two")
    public void girlTwo() {
        girlService.insertTwoData();
    }
}
