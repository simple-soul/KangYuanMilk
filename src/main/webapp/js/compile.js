
// 封装 console.log 函数
function printLog(title, info) {
    window.console && console.log(title, info);
}

// 初始化七牛上传
function uploadInit() {
    // this 即 editor 对象
    var editor = this;
    // 触发选择文件的按钮的id
    var btnId = editor.customUploadBtnId;
    // 触发选择文件的按钮的父容器的id
    var containerId = editor.customUploadContainerId;

    // 创建上传对象
    var uploader = Qiniu.uploader({
        runtimes: 'html5,flash,html4',    //上传模式,依次退化
        browse_button: btnId,       //上传选择的点选按钮，**必需**
        // uptoken_url: '/uptoken',
        // uptoken_func: function(){
        //     // 在需要获取uptoken时，该方法会被调用
        //     var uptoken;
        //        $.ajax({
        //            url:'/uptoken',
        //            type: 'post',
        //            success: function (data)
        //            {
        //                 uptoken = data.response.message;
        //            },
        //            error: function (e)
        //            {
        //                console.log(e);
        //            }
        //        });
        //        return uptoken;
        //     },
        uptoken : 'KXLzuFCOxgNar5whqU3-0bmrH6rTHOqaidcohRes:3RDMSLOgHUSkGVxAjb2IOZ8OLOs=:eyJzY29wZSI6ImJ1Y2tldCIsImRlYWRsaW5lIjoxNTAyODcyNDgyfQ==',
        //Ajax请求upToken的Url，**强烈建议设置**（服务端提供）
        // uptoken : '<Your upload token>',
        //若未指定uptoken_url,则必须指定 uptoken ,uptoken由其他程序生成
        // unique_names: true,
        // 默认 false，key为文件名。若开启该选项，SDK会为每个文件自动生成key（文件名）
        // save_key: true,
        // 默认 false。若在服务端生成uptoken的上传策略中指定了 `sava_key`，则开启，SDK在前端将不对key进行任何处理
        domain: 'http://otdmrup4y.bkt.clouddn.com/',
        //bucket 域名，下载资源时用到，**必需**
        container: containerId,           //上传区域DOM ID，默认是browser_button的父元素，
        max_file_size: '100mb',           //最大文件体积限制
        flash_swf_url: '/lib/Moxie.swf',  //引入flash,相对路径
        filters: {
            mime_types: [
                //只允许上传图片文件 （注意，extensions中，逗号后面不要加空格）
                { title: "图片文件", extensions: "jpg,gif,png,bmp" }
            ]
        },
        max_retries: 3,                   //上传失败最大重试次数
        dragdrop: true,                   //开启可拖曳上传
        drop_element: 'editor-container',        //拖曳上传区域元素的ID，拖曳文件或文件夹后可触发上传
        chunk_size: '4mb',                //分块上传时，每片的体积
        auto_start: true,                 //选择文件后自动上传，若关闭需要自己绑定事件触发上传
        init: {
            'FilesAdded': function(up, files) {
                plupload.each(files, function(file) {
                    // 文件添加进队列后,处理相关的事情
                    printLog('on FilesAdded');
                });
            },
            'BeforeUpload': function(up, file) {
                // 每个文件上传前,处理相关的事情
                printLog('on BeforeUpload');
            },
            'UploadProgress': function(up, file) {
                // 显示进度条
                editor.showUploadProgress(file.percent);
            },
            'FileUploaded': function(up, file, info) {
                // 每个文件上传成功后,处理相关的事情
                // 其中 info 是文件上传成功后，服务端返回的json，形式如
                // {
                //    "hash": "Fh8xVqod2MQ1mocfI4S4KpRL6D98",
                //    "key": "gogopher.jpg"
                //  }
                printLog(info);
                // 参考http://developer.qiniu.com/docs/v6/api/overview/up/response/simple-response.html

                var domain = up.getOption('domain');
                var res = $.parseJSON(info);
                var sourceLink = domain + res.key; //获取上传成功后的文件的Url

                printLog(sourceLink);

                // 插入图片到editor
                editor.command(null, 'insertHtml', '<img src="' + sourceLink + '" style="max-width:100%;"/>')
            },
            'Error': function(up, err, errTip) {
                //上传出错时,处理相关的事情
                printLog('on Error');
            },
            'UploadComplete': function() {
                //队列文件处理完毕后,处理相关的事情
                printLog('on UploadComplete');

                // 隐藏进度条
                editor.hideUploadProgress();
            }
        }
    });
}

// 生成编辑器
var editor = new wangEditor('editor');
// 配置自定义参数（举例）
// editor.config.uploadParams = {
//     token: 'KXLzuFCOxgNar5whqU3-0bmrH6rTHOqaidcohRes:3RDMSLOgHUSkGVxAjb2IOZ8OLOs=:eyJzY29wZSI6ImJ1Y2tldCIsImRlYWRsaW5lIjoxNTAyODcyNDgyfQ==',
// };
// editor.config.uploadImgUrl = "http://upload.qiniu.com/";
editor.config.customUpload = true;  // 设置自定义上传的开关
editor.config.customUploadInit = uploadInit;  // 配置自定义上传初始化事件，uploadInit方法在上面定义了
editor.config.uploadImgMaxLength = 1;
editor.create();
window.onbeforeunload = function ()
{
    return "确认离开当前页面吗？未保存的数据将会丢失";
};

