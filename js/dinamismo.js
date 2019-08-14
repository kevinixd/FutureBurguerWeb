$(document).ready(function () {
    $("#btnIncrementar").click(function () {
        if($('#txt1').val()<10){
            btnIncrementarVal($('#txt1'));
         
        }
    })

    $("#btnDisminuir").click(function () {
        if($('#txt1').val()>1){
           
            btnDisminuirVal($('#txt1'));
        }    

    })

    $('.producto').click(function(e){
        e.stopPropagation();
         paypal.minicart.cart.add({
         business: 'uhperezoscar@gmail.com', // Cuenta paypal para recibir el dinero
         item_name: $(this).attr("titulo"),
          amount: $(this).attr("precio"),
          currency_code: 'USD',
         
         });
    });
    

    function btnIncrementarVal(selector) {
        var $Item = selector;
        var $curVal = $Item.attr("value");
        $Item.attr("value", parseInt($curVal) + 1);
    }


    
    function btnDisminuirVal(selector) { 
        var $Item = selector; 
        var $curVal = $Item.attr("value"); 
        $Item.attr("value", parseInt($curVal) - 1); 
    }

  
    

});


