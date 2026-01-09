package com.linkit.backend.service;

import com.linkit.backend.entity.Click;
import com.linkit.backend.repository.ClickRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClickService {
    
    private final ClickRepository clickRepository;
    
    @Transactional
    public Long incrementAndGetCount() {
        Click click = clickRepository.findById(1L)
                .orElseGet(() -> {
                    Click newClick = new Click();
                    newClick.setCount(0L);
                    return clickRepository.save(newClick);
                });
        
        click.incrementCount();
        clickRepository.save(click);
        
        return click.getCount();
    }
    
    @Transactional(readOnly = true)
    public Long getCount() {
        return clickRepository.findById(1L)
                .map(Click::getCount)
                .orElse(0L);
    }
}