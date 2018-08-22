var i = 0;
var timer;
$(document).ready(function () {   //页面加载完在加载js
    // $(".container").hover(function(){
    //     $(".btn").show();
    // },function(){
    //     $(".btn").hide();
    // })
    $(".pig").eq(0).show().siblings().hide();  //.pig索引为0的显示，其他隐藏
    showTime();

    //旁边按钮
    $(".btn1").click(function () {
        clearInterval(timer);
        i--;
        if (i == -1) {
            i = 4
        }
        change();
        showTime();
    });
    $(".btn2").click(function () {
        clearInterval(timer);
        i++;
        if (i == 5) {
            i = 0
        }
        change();
        showTime();
    });

    // 导航圆点
    $(".tab").hover(function () {
        clearInterval(timer);
        i = $(this).index();   //获取当前鼠标所在的索引
        change();
    }, function () {
        showTime();
    })

    $(".nav-cont-l").find("li").mouseover(function(){
        $(".nav-cont-l").find("li").eq(0).css({"background-color":"white"})
        $(".nav-cont-l-dis").css("display","block")
    })
    $(".nav-cont-l").find("li").mouseout(function(){
        $(".nav-cont-l").find("li").eq(0).css("background-color","#f5f5f5")
        $(".nav-cont-l-dis").css("display","none")
    })
});

function showTime() {
    timer = setInterval(function () {
        i++;
        if (i == 5) {
            i = 0;
        }
        change();
    }, 2000);

}

function change() {
    $(".pig").eq(i).fadeIn(300).siblings().fadeOut();  //fadeIn()fadeOut()
    $(".tab").eq(i).addClass("bg").siblings().removeClass("bg");
}
