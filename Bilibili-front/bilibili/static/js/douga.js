$(function () {
    $('.dropdown-menu-myclass').hover(
        function () {
            $(this).addClass('open')
            $(this).find('aria-expanded').toggleClass('false', 'true')
            if($(this).index() < 1 || $(this).index() > 15){
                $(this).find('.btn').css('background-color','white')
            }
            $(this).css('cursor', 'pointer')
        },
        function () {
            $(this).removeClass('open')
            $(this).find('aria-expanded').toggleClass('true', 'false')
        }
    )

    $('.douga-catogory-wrapper ul li a').hover(
        function () {
            $(this).addClass('on')
        },
        function () {
            if($(this).parent().index() != 0){
                $(this).removeClass('on')
            }
        }
    )

    $('[data-toggle="tooltip"]').tooltip()


    $('.douga-recommend-item').hover(
        function () {
            $(this).find('.douga-item-hover').css({
                'top' : '-80px',
                'cursor' : 'pointer'
            })
            $(this).find('.douga-item-hover').find('.douga-item-mask').css('border-radius','4px')
        },
        function () {
            $(this).find('.douga-item-hover').css('top','0px')
            $(this).find('.douga-item-hover').find('.douga-item-mask').css('border-radius','0px')
        }
    )

    $('.douga-highEnergy-item').hover(
        function () {
            $(this).find('.douga-highEnergy-item-hover').show()
            $(this).find('p').css('color','#2aabd2')
        },
        function () {
            $(this).find('.douga-highEnergy-item-hover').hide()
            $(this).find('p').css('color','black')
        }
    )

    $('.douga-hot p').hover(
        function () {
            $(this).css({
                'cursor' : 'pointer',
                'color' : '#2aabd2'
            })
        },
        function () {
            $(this).css({
                'color' : 'black'
            })
        }
    )

    $('.douga-hot-top-li').hover(
        function () {
            $(this).find('i').show()
            $(this).find('p').css('color','#2aabd2')
            $(this).css('cursor','pointer')
        },
        function () {
            $(this).find('i').hide()
            $(this).find('p').css('color','black')
        }
    )

    $('.MADAMV-content-item').hover(
        function () {
            $(this).find('.MADAMV-item-playinfo-div').stop().animate(
                {
                    'top': '-100px',
                },"fast")
            $(this).find('.MADAMV-mask').css('visibility' , 'visible')
            $(this).find('.MADAMV-mask-time').css('visibility' , 'visible')
            $(this).find('.MADAMV-item-title').css('color','#2aabd2')
        },
        function () {
            $(this).find('.MADAMV-item-playinfo-div').stop().animate(
                {
                    'top': '-119px',
                },"fast")
            $(this).find('.MADAMV-mask').css('visibility' , 'hidden')
            $(this).find('.MADAMV-mask-time').css('visibility' , 'hidden')
            $(this).find('.MADAMV-item-title').css('color','black')
        }
    )

    $('.MADAMV-new-status-num').rotate({
        bind : {
            mouseover : function(){
                $(this).css('background-color','#ccd0d7')
                $(this).find(".MADAMV-refresh-icon").rotate({animateTo: 360,duration:700});
            }, mouseout : function(){
                $(this).css('background-color','white')
                $(this).find(".MADAMV-refresh-icon").rotate({animateTo: 0,duration:700});
            }
        }
    });

    $('.MADAMV-more').hover(
        function () {
            $(this).find('span').stop().animate(
                {
                    "right":"3px"
                },"fast")
            $(this).find('i').stop().animate(
                {
                    "left":"3px"
                },"fast")
            $(this).css({
                'background-color':'#ccd0d7',
                'font-size' : '13px'
            })
        },
        function () {
            $(this).find('span').stop().animate(
                {
                    "right":"0px"
                },"fast")
            $(this).find('i').stop().animate(
                {
                    "left":"0px"
                },"fast")
            $(this).css({
                'background-color':'white',
                'font-size' : '12px'
            })
        }
    )

    $('.MADAMV-title').hover(
        function () {
            $(this).css('color','#00a1d6')
        },
        function () {
            $(this).css('color','black')
        }
    )

    $('.MADAMV-head-item').hover(
        function () {
            $(this).css('color','#00a1d6')
        },
        function () {
            if($(this).hasClass('MADAMV-on')){
                return
            }
            $(this).css('color','black')
        }
    )

    $('.MADAMV-head-item').click(function () {
        $(this).addClass('MADAMV-on');
        $(this).siblings().removeClass('MADAMV-on')
        $(this).siblings().css('color','black')
    })

    $('.MADAMV-rank-head-item').hover(
        function () {
            slideMADAMVRank($(this))
            $(this).addClass('MADAMV-rank-head-item-on')
            $(this).siblings().removeClass('MADAMV-rank-head-item-on')
        },
        function () {

        }
    )

    function slideMADAMVRank(obj) {

        let tmp_0 = $('.MADAMV-wrapper').find('.MADAMV-rank-content')[0]
        let tmp_1 = $('.MADAMV-wrapper').find('.MADAMV-rank-content')[1]

        if(obj.index() === 2){

            $(tmp_1).stop().animate({
                'left':'-280px'
            })

            $(tmp_0).stop().animate({
                'left':'-280px'
            })
        }
        if(obj.index() === 1 && !obj.hasClass('MADAMV-rank-head-item-on')){

            $(tmp_1).stop().animate({
                'left':'0px'
            })

            $(tmp_0).stop().animate({
                'left':'0px'
            })
        }
    }

    $('.MMD3D-content-item').hover(
        function () {
            $(this).find('.MMD3D-item-playinfo-div').stop().animate(
                {
                    'top': '-100px',
                },"fast")
            $(this).find('.MMD3D-mask').css('visibility' , 'visible')
            $(this).find('.MMD3D-mask-time').css('visibility' , 'visible')
            $(this).find('.MMD3D-item-title').css('color','#2aabd2')
        },
        function () {
            $(this).find('.MMD3D-item-playinfo-div').stop().animate(
                {
                    'top': '-119px',
                },"fast")
            $(this).find('.MMD3D-mask').css('visibility' , 'hidden')
            $(this).find('.MMD3D-mask-time').css('visibility' , 'hidden')
            $(this).find('.MMD3D-item-title').css('color','black')
        }
    )

    $('.MMD3D-new-status-num').rotate({
        bind : {
            mouseover : function(){
                $(this).css('background-color','#ccd0d7')
                $(this).find(".MMD3D-refresh-icon").rotate({animateTo: 360,duration:700});
            }, mouseout : function(){
                $(this).css('background-color','white')
                $(this).find(".MMD3D-refresh-icon").rotate({animateTo: 0,duration:700});
            }
        }
    });

    $('.MMD3D-more').hover(
        function () {
            $(this).find('span').stop().animate(
                {
                    "right":"3px"
                },"fast")
            $(this).find('i').stop().animate(
                {
                    "left":"3px"
                },"fast")
            $(this).css({
                'background-color':'#ccd0d7',
                'font-size' : '13px'
            })
        },
        function () {
            $(this).find('span').stop().animate(
                {
                    "right":"0px"
                },"fast")
            $(this).find('i').stop().animate(
                {
                    "left":"0px"
                },"fast")
            $(this).css({
                'background-color':'white',
                'font-size' : '12px'
            })
        }
    )

    $('.MMD3D-title').hover(
        function () {
            $(this).css('color','#00a1d6')
        },
        function () {
            $(this).css('color','black')
        }
    )

    $('.MMD3D-head-item').hover(
        function () {
            $(this).css('color','#00a1d6')
        },
        function () {
            if($(this).hasClass('MMD3D-on')){
                return
            }
            $(this).css('color','black')
        }
    )

    $('.MMD3D-head-item').click(function () {
        $(this).addClass('MMD3D-on');
        $(this).siblings().removeClass('MMD3D-on')
        $(this).siblings().css('color','black')
    })

    $('.MMD3D-rank-head-item').hover(
        function () {
            slideMMD3DRank($(this))
            $(this).addClass('MMD3D-rank-head-item-on')
            $(this).siblings().removeClass('MMD3D-rank-head-item-on')
        },
        function () {

        }
    )

    function slideMMD3DRank(obj) {

        let tmp_0 = $('.MMD3D-wrapper').find('.MMD3D-rank-content')[0]
        let tmp_1 = $('.MMD3D-wrapper').find('.MMD3D-rank-content')[1]

        if(obj.index() === 2){

            $(tmp_1).stop().animate({
                'left':'-280px'
            })

            $(tmp_0).stop().animate({
                'left':'-280px'
            })
        }
        if(obj.index() === 1 && !obj.hasClass('MMD3D-rank-head-item-on')){

            $(tmp_1).stop().animate({
                'left':'0px'
            })

            $(tmp_0).stop().animate({
                'left':'0px'
            })
        }
    }

    //临时测试
    $('#app img').hover(
        function () {
            $(this).css('cursor','pointer')
        },
        function () {
            
        }
    )
    //临时测试
    $('#app a').click(function () {
        window.location.href="video.html";
    })
});