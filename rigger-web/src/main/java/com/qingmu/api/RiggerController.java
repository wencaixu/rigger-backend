package com.qingmu.api;

import com.qingmu.vos.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wencai.xu
 */
@RestController
public class RiggerController implements RiggerControllerApi {

    @RequestMapping("/rigger")
    @Override
    public ResponseEntity riggerStarter() {
        System.out.println(Thread.currentThread().getId());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(1, "success");
    }
}
