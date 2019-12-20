$(function () {
    $("[data-toggle='popover']").popover();


    $('#myPopover-danmu').on('shown.bs.popover', function () {
        $('.btbtn').hover(
            function () {
                $(this).css('color', '#00a1d6')
            },
            function () {
                $(this).css('color', 'black')
            }
        )
    })

    $('.danmu-ad button').click(function () {
        $(this).parent().fadeOut()
    })

    $('.oper-danmu').click(function () {
        if ($(this).html() === '展开') {
            $(this).html('收起')
            $('.video-play-danmu-content').stop().animate(
                {
                    'height': '455px'
                }
                , function () {
                    $('.danmu-content-item-content').css({
                        'position': 'absolute',
                        'margin-left': '18px'
                    })
                });
        } else {
            $(this).html('展开')
            $('.danmu-content-item-content').css({
                'position': 'static',
                'margin-left': '15px'
            })
            $('.video-play-danmu-content').stop().animate(
                {
                    'height': '0px'
                }
            )
        }
    })

    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    })


/*    $('.danmu-content-item').hover(
        function () {
          alert(1)
            $(this).find('.danmu-content-item-send-time').css('display', 'none')
            $(this).find('.danmu-button-group').css('visibility', 'visible')
        },
        function () {
            $(this).find('.danmu-content-item-send-time').css('display', 'inline-block')
            $(this).find('.danmu-button-group').css('visibility', 'hidden')
        }
    )

    $('.danmu-button').hover(
        function () {
            $(this).css({
                'color': 'white',
                'background': '#00a1d6'
            })
            if ($(this).index() === 2) {
                $(this).prev().prev().css('visibility', 'visible')
            }
            if ($(this).index() === 3) {
                $(this).prev().prev().css('visibility', 'visible')
            }
        },
        function () {
            $(this).css({
                'color': '#03a0d6',
                'background': '#fff'
            })
            if ($(this).index() === 2) {
                $(this).prev().prev().css('visibility', 'hidden')
            }
            if ($(this).index() === 3) {
                $(this).prev().prev().css('visibility', 'hidden')
            }
        }
    )*/

    $('#myPopover-complaint').popover({trigger: 'hover'})
        .on('mouseenter', function () {
            let _this = this;   // 这里的this触发的dom,需要存起来 否则在下面 .popover的逻辑中this会变为弹出的dom
            $(this).popover('show');
            $(".popover").on('mouseenter',function () {
                $('.complaintbtn').on('mouseenter',function () {
                    $(this).css('color','#00a1d6')
                }).on('mouseleave',function () {
                    $(this).css('color','black')
                })
            })

            $(".popover").on('mouseleave', function () {
                $(_this).popover('hide');
            });
        })
        .on('mouseleave', function () {
            let _this = this;
            if (!$('.popover:hover').length) {
                $(_this).popover('hide');
            }
        });

    $('.complaint a,.more-video-introduction a').hover(
        function () {
            $(this).css('color','#00a1d6')
        },
        function () {
            $(this).css('color','black')
        }
    )

    let ori_height=0
    let new_height=0
  $('.more-video-introduction a').click(function () {
        if($(this).html() == '展示更多'){
            ori_height = $('.video-introduction').css('height')
            $('.video-introduction').css({
                'overflow': 'visible'
            })
            new_height = $('.video-intro').css('height')
          if (parseInt(new_height)< parseInt(ori_height)){
              $('.video-more-info').css('top', 0)
              $(this).css('top',0)
            }else{
              $(this).css('top',pxOper(0, new_height, ori_height))
              $('.video-more-info').css('top',pxOper(0, new_height, ori_height))
            }

            $(this).html("收起")
        }else{
            $('.video-introduction').css({
                'height' : '75px',
                'overflow': 'hidden'
            })
            $(this).css('top',0)
            $('.video-more-info').css('top',0)
            $(this).html("展示更多")
        }
    })

    function pxOper(ori_top,new_height,ori_height) {
        return (
            ori_top+
            parseInt(new_height.slice(0,new_height.length-2)) -
            parseInt(ori_height.slice(0,ori_height.length-2))
        )
    }

    console.log($('#id').children());
    console.log(document.getElementById('id').childNodes);
    console.log(document.getElementById('id').children);;
});
