/*标签模块*/
layui.define(['form', 'jquery', 'table', 'index'], function (exports) {
  var form = layui.form,
      table = layui.table,
      $ = layui.jquery,
      active = {
        addTag: function () {
          layer.prompt({
                formType: 0
                , url: '/article/tag/save'
                , title: '添加标签'
                , btnAlign: 'c'
              }
              , function (value, index, elem) {

                $.ajax({
                  url: '/article/tag/save'
                  , type: 'post'
                  , data: {
                    'name': value,
                  }
                  , success: function (result) {
                    if (result.flag) {
                      console.log(result)
                      console.log(value)
                      layer.close(index);
                      // layer.msg(result.msg, {icon: 1});
                      success_msg(result.msg);
                      table.reload('LAY-app-content-tags');
                    } else {
                      layer.msg(result.message, {icon: 2})
                    }
                  }
                });
              });
        },
        addCategory: function () {
          layer.prompt({
            formType: 0
            , url: '/article/tag/save'
            , title: '添加分类'
            , btn: ['确定', '取消']
            , yes: function (index, layero) {

              table.reload('LAY-app-content-tags');
              console.log(layero);
              layer.close(index);
            }
          });
        }
      };

  /*标签表*/
  table.render({
    elem: "#LAY-app-content-tags",
    url: "/article/tag/page",
    method: 'post',
    cols: [[
      {field: "id", minWidth: 100, title: "标签ID"},
      {field: "name", minWidth: 100, title: "标签名"},
      {field: "操作", minWidth: 100, toolbar: "#layuiadmin-app-cont-tagsbar"}
    ]],
    page: !0,
    limit: 10,
    // limits: [10, 15, 20, 25, 30],
    text: "对不起，加载出现异常！"
    , toolbar: '#toolbar-tags' //开启头部工具栏，并为其绑定左侧模板
    , defaultToolbar: false //不开启头部右侧的打印栏
    , done: function (d, page) {

      /*点击添加标签*/
      $('.layuiadmin-btn-tags').click(function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
      });
    }
  });

  exports("tag", {})
});