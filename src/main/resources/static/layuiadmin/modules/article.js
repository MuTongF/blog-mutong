/*文章模块*/
layui.define(['form', 'jquery', 'table', 'dataformat'], function (exports) {
  var form = layui.form,
      layer = layui.layer,
      table = layui.table,
      $ = layui.jquery;

  table.render({
    elem: "#LAY-app-content-list",
    url: "/article/page",
    method: 'post',
    cols: [[
      {type: "checkbox", fixed: "left"},
      {field: "id", minWidth: 100, title: "文章ID"},
      {field: "title", minWidth: 100, title: "文章标题"},
      {field: "author", minWidth: 100, title: "作者"},
      {
        field: "creatTime", minWidth: 160, title: "发布时间",
        templet: function (d) {
          return DateUtil.toDateString(d.creatTime);
        }
      },
      {
        field: "updateTime",
        minWidth: 160,
        title: "最近更新时间",
        templet: function (d) {
          return DateUtil.toDateString(d.updateTime);
        }
      },
      {
        field: "status",
        width: 90,
        title: "发布状态",
        templet: "#buttonTpl"
      },
      {title: "操作", minWidth: 210, toolbar: "#table-content-list"}
    ]],
    page: !0,
    limit: 10,
    // limits: [10, 15, 20, 25, 30],
    text: "对不起，加载出现异常！"
    , toolbar: '#toolbar-tags' //开启头部工具栏，并为其绑定左侧模板
    , defaultToolbar: false //不开启头部右侧的打印栏
    , done: function (d, page) {

    }
  });

  table.on('tool(LAY-app-content-list)', function (obj) {
    var data = obj.data;
    if (obj.event === 'del') {
      layer.confirm('真的删除该文章么?', function (index) {
        $.ajax({
          url: '/article/delete'
          , type: 'post'
          , data: {
            'id': data.id,
          }
          , success: function (result) {
            if (result.flag) {
              // obj.del();
              layer.close(index);
              success_msg(result.msg);
              table.reload('LAY-app-content-list');
            } else {
              error_msg(result.msg);
            }
          }
        });

      });
    } else if (obj.event === 'release') {
      release(data.id)
    }
  });

  form.on('submit(release)', function (data) {

    submit(1, data);
    return false;
  });

  form.on('submit(draft)', function (data) {
    console.log(data)
    submit(0, data);
    return false;
  });

  function release(id) {
    var field = {id: id, status: 1};
    $.ajax({
      url: '/article/save'
      , type: 'post'
      , data: field
      , success: function (result) {
        if (result.flag) {
          success_msg("发布成功");
          table.reload('LAY-app-content-list');
        } else {
          error_msg("发布失败");
        }
      }
    });
  }

  function submit(i, obj) {

    obj.field['status'] = i;
    obj.field['content'] = obj.field['editormd-html-code'];
    obj.field['contentMd'] = getMarkdownContent();

    $.ajax({
      url: '/article/save'
      , type: 'post'
      , data: obj.field
      , success: function (result) {
        if (result.flag) {
          success_msg(result.msg);
        } else {
          error_msg(result.msg);
        }
      }
    });

    /*$.post({
      url:'',
      data:obj.field,
      success:function () {

      }
    })*/
  }

  //获取Markdown
  function getMarkdownContent() {
    var content = $('.editormd-markdown-textarea').val();
    return content;
  }

  exports("article", {})
});