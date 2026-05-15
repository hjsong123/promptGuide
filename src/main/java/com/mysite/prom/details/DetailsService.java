package com.mysite.prom.details;

import java.util.List;

import com.mysite.prom.DataNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;


import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DetailsService {

    private final DetailsRepository detailsRepository;

    public List<Details> getList() {
        return this.detailsRepository.findAll();
    }
    
    public Details getDetail(Integer id) {  
        Optional<Details> detail = this.detailsRepository.findById(id);
        if (detail.isPresent()) {
            return detail.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

	public List<Details> getListByCategory(Integer category) {
		List<Details> detail = this.detailsRepository.findByCategory(category);
        if (detail != null) {
            return detail;
        } else {
            throw new DataNotFoundException("question not found");
        }
	}
}
