package com.mysite.prom;

import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.prom.coment.Coment;
import com.mysite.prom.coment.ComentRepository;
import com.mysite.prom.details.Details;
import com.mysite.prom.details.DetailsRepository;


@SpringBootTest
class PromptGuide2ApplicationTests {

    @Autowired
    private DetailsRepository detailsRepository;
    
    @Autowired
    private ComentRepository answerRepository;

    @Transactional
    @Test
    void testJpa() {        
    	Optional<Details> oq = this.detailsRepository.findById(2);
        assertTrue(oq.isPresent());
        Details q = oq.get();

        Coment a = new Coment();
        a.setContent("네 자동으로 생성됩니다.");
        a.setDetails(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }
}
