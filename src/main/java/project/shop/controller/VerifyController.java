//package project.shop.controller;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.IOException;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/verifyIamport")
//public class VerifyController {
//
//    /** Iamport 결제 검증 컨트롤러 **/
//    private final IamportClient iamportClient;
//
//    // 생성자를 통해 REST API 와 REST API secret 입력
//    public VerifyController() {
//        Dotenv dotenv = Dotenv.load();
//        String apiKey = dotenv.get("API_KEY");
//        String secretKey = dotenv.get("SECRET_KEY");
//
//        this.iamportClient = new IamportClient(apiKey, secretKey);
//    }
//
//    /** 프론트에서 받은 PG사 결괏값을 통해 아임포트 토큰 발행 **/
//    @PostMapping("/{imp_uid}")
//    public IamportResponse<Payment> paymentByImpUid(@PathVariable String imp_uid) throws IamportResponseException, IOException {
//        log.info("paymentByImpUid 진입");
//        return iamportClient.paymentByImpUid(imp_uid);
//    }
//
//}
