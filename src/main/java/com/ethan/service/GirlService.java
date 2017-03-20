package com.ethan.service;

import com.ethan.enums.ResultEnum;
import com.ethan.exception.GirlException;
import com.ethan.repository.GirlRepository;
import com.ethan.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lingxingu on 2017/3/18.
 */
@Service
public class GirlService {

    final GirlRepository girlRepository;

    @Autowired
    public GirlService(final GirlRepository girlRepository) {
        this.girlRepository = girlRepository;
    }

    @Transactional
    public void insertTwoData() {

        final Girl girlA = new Girl();
        girlA.setAge(21);
        girlA.setCupSize("C");
        girlA.setMoney(20000.0);
        girlRepository.save(girlA);

        final Girl girlB = new Girl();
        girlB.setAge(21);
        girlB.setCupSize("DDDDD");
        girlB.setMoney(60000.0);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (20 >= age) {
            // maybe u r in primary school
//            throw new GirlException(100, "maybe u r in primary school");
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if(age > 20 && age < 25) {
            // maybe u r in middle school
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }
}
