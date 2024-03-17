//const IMP = window.IMP;
IMP.init('imp31427128')

const buyButton = document.getElementById('payment');
buyButton.addEventListener("click", onClickPay);

const onClickPay= async () =>{
 IMP.request_pay({
                pg: 'kakaopay.TC0ONETIME', // PG사 코드표에서 선택
                pay_method: 'card', // 결제 방식
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: `커어어피`, // 제품명
                amount: 2000, // 가격
                //구매자 정보 ↓
                //buyer_num: `${useremail}`,
                //buyer_name: `${username}`,
}, function(response){
    const { status, err_msg} = response;
    if (err_msg) {
        alert(err_msg);
    }
    if (status === "paid") {
        const {imp_uid} = response;
        verifyPayment(imp_uid);
    }
});
};
