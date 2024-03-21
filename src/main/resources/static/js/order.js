function cartadd(event) {
    let row = event.target.closest("tr");
    let ordermenu = row.querySelector("td:nth-child(2)").textContent;
    let orderprice = row.querySelector("td:nth-child(3)").textContent.replace(/[^0-9]/g, '');
    let orderqunt = row.querySelector("td:nth-child(4) input").value;

    window.location.href = "/cart?orderid=aa1&ordermenu="+ordermenu+"&orderprice="+orderprice+"&orderqunt="+orderqunt;
}