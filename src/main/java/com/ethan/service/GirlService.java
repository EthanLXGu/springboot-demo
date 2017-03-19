package com.ethan.service;

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
        girlRepository.save(girlA);

        final Girl girlB = new Girl();
        girlB.setAge(21);
        girlB.setCupSize("DDDDD");
        girlRepository.save(girlB);
    }
}
