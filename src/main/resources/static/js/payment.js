function paymentCof(){
    const total = calculateTotal();
    const confirmation = confirm(total + " 원 결제 하시겠습니까?");

    if(confirmation){
    IMP.init('imp31427128')
         IMP.request_pay(
              {
                // param
                pg: 'kakaopay.TC0ONETIME', // PG사 코드표에서 선택
                pay_method: 'card', // 결제 방식
                merchant_uid: makeMerchantUid(), // 결제 고유 번호
                name: `커어어피`, // 제품명
                amount: total, // 가격
                //구매자 정보 ↓
                buyer_email: "alsqod89@naver.com",
                buyer_name: "홍길동",
                buyer_tel: "010-4242-4242",
                buyer_addr: "서울특별시 강남구 신사동",
                buyer_postcode: "01181",
              },
              async (rsp) => {
                // callback
                if (rsp.success) {
                    alert("결제성공");
                    window.location.href = "/pay_seccess?sf='결제성공'";
                } else {
                    alert("결제실패");
                    window.location.href = "/pay_seccess?sf='결제실패'";
                }
              }
            );
          }
}

// yymmddhhmm 형식으로 현재 시각을 반환하는 함수
function makeMerchantUid() {
    const now = new Date();
    const year = now.getFullYear().toString().slice(2);
    const month = (now.getMonth() + 1).toString().padStart(2, '0');
    const day = now.getDate().toString().padStart(2, '0');
    const hours = now.getHours().toString().padStart(2, '0');
    const minutes = now.getMinutes().toString().padStart(2, '0');
    return 'IMP' + year + month + day + hours + minutes;
}

// 메뉴 합계
function calculateTotal() {
    const totals = document.querySelectorAll('tbody input[type="text"]'); // 모든 합계 입력란
    let totalSum = 0;
    totals.forEach(function (element) {
        totalSum += parseFloat(element.value || 0); // 빈 값이거나 문자열을 0으로 처리
    });
    return totalSum.toFixed(0);
}