/*数据处理的js*/
/*处理时间的工具*/
var DateUtil = {
  /**
   *
   * @param time 时间戳:"2019-09-11T10:11:54.000+0000"
   * @param format 格式:"yyyy-MM-dd HH:mm:ss"
   * @returns {*|string}
   */
  toDateString(time, format) {
    if (time == null) {
      return "";
    }
    if (format == null) {
      format = "yyyy-MM-dd HH:mm:ss";
    }
    var date = new Date(time);
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    month = month < 10 ? ('0' + month) : month;
    var day = date.getDate();
    day = day < 10 ? ('0' + day) : day;
    var h = date.getHours();
    h = h < 10 ? ('0' + h) : h;
    var m = date.getMinutes();
    m = m < 10 ? ('0' + m) : m;
    var s = date.getSeconds();
    s = s < 10 ? ('0' + s) : s;
    format = format.replace("yyyy", year).replace("MM", month).replace("dd",
        day).replace("HH", h).replace("mm", m).replace("ss", s);
    return format;
  }
};

/*处理字符的工具*/
var StrUtil = {
  /**
   * 去除空格
   */
  removeSpaces(str) {
    return str.replace(/\s+/g, "");
  }
  /**
   * 获取地址栏参数
   * @param name
   * @returns {*}
   */
  , getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) {
      return unescape(r[2]);
    }
    return null; //返回参数值
  }
};

/*处理字符的工具*/
var DataUtil = {
  /**
   * 获取地址栏参数
   */
  getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) {
      return unescape(r[2]);
    }
    return null; //返回参数值
  }
};
/*Html工具类*/
var HtmlUtil = {
  /**
   * Html反转义
   */
  Decode(text) {
    return text.replace(/&lt;/g, "<").replace(/&gt;/g, '>').replace(/&quot;/g,
        '"');
  }
  , Encode(html) {//Html转义
    return html.replace(/</g, "&lt;").replace(/>/g, '&gt;').replace(/"/g,
        '&quot;');
  }
};
layui.define(['form'], function (exports) {
  exports("dataformat", {})
});

