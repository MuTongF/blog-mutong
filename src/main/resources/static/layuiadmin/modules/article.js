/*文章模块*/
layui.define(['form','jquery'],function (exports) {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery;

  form.on('submit(release)', function (data) {

    submit(1,data);
    return false;
  });

  form.on('submit(draft)', function (data) {
    console.log(data)
    submit(0,data);
    return false;
  });



    function submit(i,obj){

      obj.field['state'] = i;
      obj.field['content'] = obj.field['editormd-html-code'];
      obj.field['contentMd'] = getMarkdownContent();
      console.log(obj.field);

      /*$.post({
        url:'',
        data:obj.field,
        success:function () {

        }
      })*/
    }

  //获取Markdown
  function getMarkdownContent(){
    var content = $('.editormd-markdown-textarea').val();
    return content;
  }

  exports("article", {})
});