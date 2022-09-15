function CalcSum(){
   var total_sum = 0;
   $("#product-list .product_total").each(function (){
      var val = $(this).val();
      if ($.isNumeric(val)) {
         total_sum += parseFloat(val);
      }
   });
   $("#count_price").html(total_sum);
}

$("#product-list").on('input','.product_quantity',function (){
   var self = $(this);
   var tr = self.closest("tr");

   var quantity = self.val();
   var Price = tr.find(".product_price").val();

   var amount = 0;
   if ($.isNumeric(quantity) && $.isNumeric(Price)) {
      amount = quantity * Price;
   }
   tr.find(".product_total").val(amount);

   CalcSum();
});