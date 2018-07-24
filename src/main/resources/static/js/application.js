function makeAjaxCallGet(urlToCall) {
    $.ajax({
      url: urlToCall,
      cache: false,
      //data: JSON.stringify(formData),
      success: function(html){
        $("#container").html(html);
      },
      error: function(error) {
          alert("some error");
       }
    });
}

function makeAjaxCallPost(urlToCall, formData) {
    $.ajax({
      url: urlToCall,
      cache: false,
      data: formData,
      type: "POST",
      success: function(html){
        console.log(html);
        $("#container").html(html);
      },
      error: function (xhr, ajaxOptions, thrownError) {
        console.log(response)
      }
    });
}

function postJobOfferGet() {
    makeAjaxCallGet("postJobOffer");
}

function postJobOfferPost() {
    makeAjaxCallPost("postJobOffer",$("#form").serialize());
}