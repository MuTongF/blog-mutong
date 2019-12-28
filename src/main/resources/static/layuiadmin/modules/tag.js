/*标签模块*/
layui.define(['form', 'jquery', 'table', 'index'], function (exports) {
  var form = layui.form,
      table = layui.table,
      $ = layui.jquery,
      active = {
        addTag: function () {
          layer.prompt({
                formType: 0
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
                      layer.close(index);
                      success_msg(result.msg);
                      table.reload('LAY-app-content-tags');
                    } else {
                      error_msg(result.msg);
                    }
                  }
                });
              });
        },
        addCategory: function () {
          layer.prompt({
                formType: 0
                , title: '添加分类'
                , btnAlign: 'c'
              }
              , function (value, index, elem) {

                $.ajax({
                  url: '/article/category/save'
                  , type: 'post'
                  , data: {
                    'name': value,
                  }
                  , success: function (result) {
                    if (result.flag) {
                      layer.close(index);
                      success_msg(result.msg);
                      table.reload('LAY-app-content-category');
                    } else {
                      error_msg(result.msg);
                    }
                  }
                });
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
      {title: "操作", minWidth: 100, toolbar: "#layuiadmin-app-cont-tagsbar"}
    ]],
    page: !0,
    limit: 10,
    // limits: [10, 15, 20, 25, 30],
    text: "对不起，加载出现异常！"
    , toolbar: '#toolbar-tags' //开启头部工具栏，并为其绑定左侧模板
    , defaultToolbar: false //不开启头部右侧的打印栏
    , done: function (d, page) {
      /*点击添加按钮*/
      $('.layuiadmin-btn-add').click(function () {
        var type = $(this).data('type');
        active[type];
      });
    }
  });
//监听标签工具条
  table.on('tool(LAY-app-content-tags)', function (obj) {
    var data = obj.data;
    if (obj.event === 'edit') {
      layer.prompt({
            formType: 0
            , url: '/article/tag/save'
            , title: '编辑标签'
            , btnAlign: 'c'
            , value: data.name
          }
          , function (value, index, elem) {
            if (value == data.name) {
              success_msg("没有做修改");
              layer.close(index);
              return;
            }

            $.ajax({
              url: '/article/tag/save'
              , type: 'post'
              , data: {
                'id': data.id,
                'name': value
              }
              , success: function (result) {
                if (result.flag) {
                  layer.close(index);
                  success_msg(result.msg);
                  table.reload('LAY-app-content-tags');
                } else {
                  error_msg(result.msg);
                }
              }
            });
          });
    } else if (obj.event === 'del') {
      layer.confirm('真的删除该标签么?', function (index) {
        $.ajax({
          url: '/article/tag/delete'
          , type: 'post'
          , data: {
            'id': data.id,
          }
          , success: function (result) {
            if (result.flag) {
              // obj.del();
              layer.close(index);
              success_msg(result.msg);
              table.reload('LAY-app-content-tags');
            } else {
              error_msg(result.msg);
            }
          }
        });

      });
    }
  });
  /*分类表*/
  table.render({
    elem: "#LAY-app-content-category",
    url: "/article/category/page",
    method: 'post',
    cols: [[
      {field: "id", minWidth: 100, title: "标签ID"},
      {field: "name", minWidth: 100, title: "分类名"},
      {title: "操作", minWidth: 100, toolbar: "#layuiadmin-app-cont-tagsbar"}
    ]],
    page: !0,
    limit: 10,
    // limits: [10, 15, 20, 25, 30],
    text: "对不起，加载出现异常！"
    , toolbar: '#toolbar-category' //开启头部工具栏，并为其绑定左侧模板
    , defaultToolbar: false //不开启头部右侧的打印栏
    , done: function (d, page) {
      /*点击添加按钮*/
      $('.layuiadmin-btn-add').click(function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
      });
    }
  });

//监听分类工具条
  table.on('tool(LAY-app-content-category)', function (obj) {
    var data = obj.data;
    if (obj.event === 'edit') {
      layer.prompt({
            formType: 0
            , url: '/article/category/save'
            , title: '编辑分类'
            , btnAlign: 'c'
            , value: data.name
          }
          , function (value, index, elem) {
            if (value == data.name) {
              success_msg("没有做修改");
              layer.close(index);
              return;
            }

            $.ajax({
              url: '/article/category/save'
              , type: 'post'
              , data: {
                'id': data.id,
                'name': value
              }
              , success: function (result) {
                if (result.flag) {
                  layer.close(index);
                  success_msg(result.msg);
                  table.reload('LAY-app-content-category');
                } else {
                  error_msg(result.msg);
                }
              }
            });
          });
    } else if (obj.event === 'del') {
      layer.confirm('真的删除该分类么?', function (index) {
        $.ajax({
          url: '/article/category/delete'
          , type: 'post'
          , data: {
            'id': data.id,
          }
          , success: function (result) {
            if (result.flag) {
              // obj.del();
              layer.close(index);
              success_msg(result.msg);
              table.reload('LAY-app-content-category');
            } else {
              error_msg(result.msg);
            }
          }
        });

      });
    }
  });

  exports("tag", {})
});