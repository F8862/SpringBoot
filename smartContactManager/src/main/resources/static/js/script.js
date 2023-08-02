console.log("this is script file");


function toggleSidebar() {
    
    const sidebar =  document.getElementsByClassName("sidebar")[0];
    const content =  document.getElementsByClassName("content")[0];

    if(window.getComputedStyle(sidebar).display === "none"){
        sidebar.style.display = "block";
        content.style.marginLeft = "20%";
    }
    else{
        sidebar.style.display = "none";
        content.style.marginLeft = "0%";
    }
}

/*const toggleSidebar = () =>{
    if($('.sidebar').is(":visible")){
        $('.sidebar').css("dispaly","none");
        $('.content').css("margin-left","0%");
        console.log("this is if");

    }else{
        $(".sidebar").css("dispaly","block");
        $(".content").css("margin-left","20%");
        console.log("this is else");

    }
};*/

const search=()=>{
    //console.log("searching....");
    let query=$("#search-input").val();
    
    if(query==''){
        $(".search-result").hide();
    }else{
        //console.log(query);
        //sending reaquest to server
        let url=`http://localhost:8282/search/${query}`;
        fetch(url).then((response)=>{
            return response.json();
        }).then((data)=>{
           // console.log(data);
            let text=`<div class="list-group">`;
            data.forEach((contact) => {
                text+=`<a href="/user/${contact.cId}/contact" class=" list-group-item list-group-item-action">${contact.name}</a>`

            });

            text+=`</div>`;
            $(".search-result").html(text);
            $(".search-result").show();
        });
        
    }
};

//first request to server for create order
const paymentStart=()=>{
    console.log("payment started");
    let amount=$("#payment_field").val();
    console.log(amount);
    if(amount=='' || amount==null){
        //alert("Amount is required!!");
        swal("Failed!","Amount is required!!","error");

        return;
    }
    //we will use ajax to send request to server for create order
    $.ajax(
        {
            url: '/user/create_order',
            data:JSON.stringify({amount:amount,info:'other_request'}),
            contentType:'application/json',
            type:'POST',
            dataType:'json',
            success:function(response){
                //invoked when success
                console.log(response);
                if(response.status=="created"){
                    //open payment form
                    let options={
                        key:'rzp_test_oNev6IkaoHm5lt',
                        amount:response.amount,
                        currency:'INR',
                        name:'Smart Contact Manager',
                        description:"Donation",
                        image:'',
                        order_id:response.id,
                        handler:function(response){
                            console.log(response.razorpay_payment_id);
                            console.log(response.razorpay_order_id);
                            console.log(response.razorpay_signature);
                            console.log('payment successfull');
                            updatePaymentOnServer(response.razorpay_payment_id,response.razorpay_order_id,'paid');
                            //alert("payment successfull");
                            //swal("Good Job!","payment successfull!!","success");
                        },
                        prefill:{
                            name:"",
                            email:"",
                            contact:"",
                        },
                        notes:{
                            address:"Ansari coding",
                        },
                        theme:{
                            color:"#3399cc"
                        },
                    };

                    let rzp=new Razorpay(options);
                    rzp.on("payment failed",function (response){
                        console.log(response.error.code);
                        console.log(response.error.description);
                        console.log(response.error.source);
                        console.log(response.error.step);
                        console.log(response.error.reason);
                        console.log(response.error.metadata.order_id);
                        console.log(response.error.metadata.payment_id);
                        //alert("Oops payment failed!!");
                        swal("Failed!","Oops payment failed!!","error");

                    });
                    rzp.open();

                }
            },
            error:function(error){
                //invojed when error
                console.log(error);
                alert("Something went wrong!!");
            }

    }
    )

};

function updatePaymentOnServer(payment_id,order_id,status)
{
$.ajax({
    url: '/user/update_order',
    data:JSON.stringify({payment_id:payment_id,order_id:order_id,status:status}),
    contentType:'application/json',
    type:'POST',
    dataType:'json',
    success:function(response){
        swal("Good Job!","payment successfull!!","success");
    },
    error:function(error){
        swal("Failed!","your payment is successfull but we did not get on server,we will contact you as soon as possible","error");
    },
});
}

