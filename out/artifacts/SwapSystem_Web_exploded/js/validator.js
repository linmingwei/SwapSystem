
//注册验证器
$(function () {
    $('#registerForm').bootstrapValidator({
    message: 'This value is not valid',
    feedbackIcons: {
        valid: 'glyphicon glyphicon-ok',
        invalid: 'glyphicon glyphicon-remove',
        validating: 'glyphicon glyphicon-refresh'
    },
    fields:{
        username:{
            message:'用户名验证失败',
            validators:{
                notEmpty:{
                    message:'用户名不能为空'
                },
                stringLength:{
                    min:6,
                    max:12,
                    message:'用户名不少于6位'
                },
                threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
                remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                    url: '/user/valid.do',//验证地址
                    message: '用户已存在',//提示消息
                    delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                    type: 'POST'//请求方式
                    /**自定义提交数据，默认值提交当前input value
                     *  data: function(validator) {
                               return {
                                   password: $('[name="passwordNameAttributeInYourForm"]').val(),
                                   whatever: $('[name="whateverNameAttributeInYourForm"]').val()
                               };
                            }
                     */
                },
                regexp:{
                    regexp:/^[a-zA-Z0-9_]+$/,
                    message:'用户名只能包含大写、小写、数字和下划线'
                }

            }
        },
        password:{
            message:'您的输入有误',
            validators:{
                notEmpty:{
                    message:'密码不能为空'
                },
                different:{
                    field:'username',
                    message:'不能与用户名相同'
                },
                stringLength:{
                    min:6,
                    max:12,
                    message:'密码长度在6到12之间'
                },
                regexp:{
                    regexp:/^[a-zA-Z0-9_]+$/,
                    message:'密码只能包含大写、小写、数字和下划线'
                }
            }
        },
        repassword:{
            message:'您的输入有误',
            validators:{
                identical:{
                    field:'password',
                    message:'密码两次输入不一致，请重新输入'
                }
            }

        },
        phone:{
            message:'您的输入有误',
            validators:{
                notEmpty:{
                    message:'手机号不能为空'
                },
                regexp:{
                    regexp:/^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$/,
                    message:'请输入有效的手机号码'
                }
            }
        },
        email:{
            message:'您的输入有误',
            validators:{
                notEmpty:{
                    message:'密码不能为空'
                },
                emailAddress:{
                    message:'请输入有效的邮箱'
                }
            }
        }


    }
})

})
//



