package it.spkt.fashionecommercebe.service.impl;

import it.spkt.fashionecommercebe.repository.DiscountRepository;
import it.spkt.fashionecommercebe.service.DiscountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DiscountServiceImpl implements DiscountService {
    @Autowired
    DiscountRepository discountRepository;
}
