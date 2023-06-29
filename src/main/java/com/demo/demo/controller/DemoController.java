package com.demo.demo.controller;

import com.demo.demo.dto.ResponseDTO;
import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/exec")
public class DemoController {

    @GetMapping(value = "/status")
    public ResponseEntity<ResponseDTO> getIpAddress(HttpServletRequest request){
        ResponseDTO response = new ResponseDTO();

        String remoteAddress = request.getRemoteAddr();
        System.out.println(remoteAddress);
        log.info("IpAdress with value: {}", remoteAddress);
        if (!StringUtils.isBlank(remoteAddress)) {
            response.setStatus("OK");
        }else{
            response.setStatus("Error");
        }
        //System.out.println(getIpAddressFromHeader(request));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
