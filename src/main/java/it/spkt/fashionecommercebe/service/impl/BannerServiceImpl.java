package it.spkt.fashionecommercebe.service.impl;

import it.spkt.fashionecommercebe.repository.BannerRepository;
import it.spkt.fashionecommercebe.service.BannerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BannerServiceImpl implements BannerService {
    @Autowired
    BannerRepository bannerRepository;
}
