/** layuiAdmin.std-v1.2.1 LPPL License By http://www.layui.com/admin/ */
;layui.define(["admin", "table", "util"], function (e) {
  var t = layui.$, i = (layui.admin, layui.table), l = (layui.element, {
    all: {text: "全部消息", id: "LAY-app-message-all"},
    notice: {text: "通知", id: "LAY-app-message-notice"},
    direct: {text: "私信", id: "LAY-app-message-direct"}
  }), a = function (e) {
    return '<a href="detail.html?id=' + e.id + '">' + e.title
  };
  i.render({
    elem: "#LAY-app-message-all",
    url: layui.setter.base + "json/message/all.js",
    page: !0,
    cols: [[{type: "checkbox", fixed: "left"},
      {field: "title", title: "标题内容", minWidth: 300, templet: a}, {
        field: "time",
        title: "时间",
        width: 170,
        templet: "<div>{{ layui.util.timeAgo(d.time) }}</div>"
      }]],
    skin: "line"
  }), i.render({
    elem: "#LAY-app-message-notice",
    url: layui.setter.base + "json/message/notice.js",
    page: !0,
    cols: [[{type: "checkbox", fixed: "left"},
      {field: "title", title: "标题内容", minWidth: 300, templet: a}, {
        field: "time",
        title: "时间",
        width: 170,
        templet: "<div>{{ layui.util.timeAgo(d.time) }}</div>"
      }]],
    skin: "line"
  }), i.render({
    elem: "#LAY-app-message-direct",
    url: layui.setter.base + "json/message/direct.js",
    page: !0,
    cols: [[{type: "checkbox", fixed: "left"},
      {field: "title", title: "标题内容", minWidth: 300, templet: a}, {
        field: "time",
        title: "时间",
        width: 170,
        templet: "<div>{{ layui.util.timeAgo(d.time) }}</div>"
      }]],
    skin: "line"
  });
  var d = {
    del: function (e, t) {
      var a = l[t], d = i.checkStatus(a.id), s = d.data;
      return 0 === s.length ? layer.msg("未选中行") : void layer.confirm(
          "确定删除选中的数据吗？", function () {
            layer.msg("删除成功", {icon: 1}), i.reload(a.id)
          })
    }, ready: function (e, t) {
      var a = l[t], d = i.checkStatus(a.id), s = d.data;
      return 0 === s.length ? layer.msg("未选中行") : (layer.msg("标记已读成功",
          {icon: 1}), void i.reload(a.id))
    }, readyAll: function (e, t) {
      var i = l[t];
      layer.msg(i.text + "：全部已读", {icon: 1})
    }
  };
  t(".LAY-app-message-btns .layui-btn").on("click", function () {
    var e = t(this), i = e.data("events"), l = e.data("type");
    d[i] && d[i].call(this, e, l)
  }), e("message", {})
});