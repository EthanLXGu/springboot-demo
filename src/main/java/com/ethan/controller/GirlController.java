package com.ethan.controller;

import com.ethan.ResultUtil;
import com.ethan.aspect.HttpAspect;
import com.ethan.domain.Result;
import com.ethan.repository.GirlRepository;
import com.ethan.domain.Girl;
import com.ethan.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ethan L X Gu on 2017/3/18.
 */
@RestController
public class GirlController {

    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    private final GirlRepository girlRepository;

    private final GirlService girlService;

    @Autowired
    public GirlController(final GirlRepository girlRepository, final GirlService girlService) {
        this.girlRepository = girlRepository;
        this.girlService = girlService;
    }

    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
//        System.out.println("girl list");
        logger.info("girlList");
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
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
//            return null;
//            return bindingResult.getFieldError().getDefaultMessage();

//            Result result = new Result();
//            result.setCode(1);
//            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        girl.setMoney(girl.getMoney());

//        Result result = new Result();
//        result.setCode(0);
//        result.setMsg("Success");
//        result.setData(girlRepository.save(girl));

//        return girlRepository.save(girl);
        return ResultUtil.success(girl);
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
                           @RequestParam("age") final Integer age,
                           @RequestParam("money") final Double money) {
        Girl girl = girlRepository.findOne(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setMoney(money);
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

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") final Integer id) throws Exception{
        girlService.getAge(id);
    }
}
